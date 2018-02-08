package com.juzix.plt.service.connection;

import android.content.Context;
import android.util.Log;

import com.juzix.plt.service.callback.MsgCallback;
import com.juzix.plt.service.util.IceDefine;
import com.juzix.plt.slice.device.PltDeviceServicePrx;
import com.juzix.plt.slice.device.PltDeviceServicePrxHelper;
import com.juzix.plt.slice.file.PltFileServicePrx;
import com.juzix.plt.slice.file.PltFileServicePrxHelper;
import com.juzix.plt.slice.proxy.PltProxyServicePrx;
import com.juzix.plt.slice.proxy.PltProxyServicePrxHelper;
import com.juzix.plt.slice.session.PltMsgCallbackPrx;
import com.juzix.plt.slice.session.PltMsgCallbackPrxHelper;
import com.juzix.plt.slice.session.PltSessionPrx;
import com.juzix.plt.slice.session.PltSessionPrxHelper;
import com.juzix.plt.slice.user.PltUserServicePrx;
import com.juzix.plt.slice.user.PltUserServicePrxHelper;

import com.juzix.plt.service.util.IceUtil;

import java.util.Map;

import Ice.ObjectPrx;

public class PltConnection extends IceConnection {

    private OnConnectListener mConnectListener;
    private ConnectThread     mConnectThread;
    private HeartbeatThread   mHeartbeatThread;
    private String            mUserId;
    private String            mPassword;

    public PltConnection(Context context, String name) {
        super(context, name);
    }

    public void setOnConnectListener(OnConnectListener listener) {
        mConnectListener = listener;
    }

    public void notifyToHeartbeat() {
        if (mHeartbeatThread != null) {
            mHeartbeatThread.notifyToHeartbeat();
        }
    }

    //建立连接，异步方法，建立连接的时候调用者不需要等待。
    @Override
    public void tryConnect(final String userId, final String password, final String endpoint, final Map<String, String> ctx) {
        Log.d(TAG, "CmdConnection.tryConnect()");
        mUserId = userId;
        mPassword = password;

        if (mConnectThread != null) {
            mConnectThread.kill();
            mConnectThread = null;
        }
        mConnectThread = new ConnectThread(endpoint, ctx);
        mConnectThread.start();
    }

    //设置回调
    public boolean setMsgCallback(String deviceId, MsgCallback msgCallback) {
        //还需要设置回调。。
        try {
            Ice.ObjectAdapter adapter = mCommunicator.createObjectAdapterWithRouter(IceDefine.SESSION_SERVER_ADAPTER, mRouterPrx);
            adapter.activate();

            Ice.Identity callbackId = new Ice.Identity();
            callbackId.name = IceUtil.getUUID();
            callbackId.category = mRouterPrx.getCategoryForClient();

            ObjectPrx objectPrx = adapter.add(msgCallback, callbackId);

            PltMsgCallbackPrx pltMsgCallbackPrx = PltMsgCallbackPrxHelper.checkedCast(objectPrx);
            PltSessionPrx     pltSessionPrx     = PltSessionPrxHelper.checkedCast(mSessionPrx);
            pltSessionPrx.addMsgCallback(deviceId, pltMsgCallbackPrx);

            return true;
        } catch (Exception e) {
            Log.d(TAG, "set ServiceCallback on Cmd Connection failed!", e);
            return false;
        }
    }

    //关闭连接
    public void close() {
        Log.d(TAG, mName + ".close(),WorkState=" + mWorkState);

        //如果已经是idle了，直接return
        if (mWorkState == WorkState.IDLE || mWorkState == WorkState.STOP) return;

        mWorkState = WorkState.STOP;
        this.cleanup();
        mWorkState = WorkState.IDLE;
        afterClose();
    }

    //如何去获取ICE代理对象，子类必须覆盖
    @Override
    protected void getProxyObjs() {
        Log.d(TAG, "get deviceservice proxy obj...");
        ObjectPrx           deviceObjectPrx  = mCommunicator.stringToProxy(IceDefine.PROXY_OBJ_NAME_DEVICE_SERVICE);
        PltDeviceServicePrx deviceServicePrx = PltDeviceServicePrxHelper.checkedCast(deviceObjectPrx);
        mObjectPrxMap.put(IceDefine.PROXY_OBJ_NAME_DEVICE_SERVICE, deviceServicePrx);

        Log.d(TAG, "get userservice proxy obj...");
        ObjectPrx         userObjectPrx  = mCommunicator.stringToProxy(IceDefine.PROXY_OBJ_NAME_USER_SERVICE);
        PltUserServicePrx userServicePrx = PltUserServicePrxHelper.checkedCast(userObjectPrx);
        mObjectPrxMap.put(IceDefine.PROXY_OBJ_NAME_USER_SERVICE, userServicePrx);

//        Log.d(TAG, "get messageservice proxy obj...");
//        ObjectPrx            messageObjectPrx  = mCommunicator.stringToProxy(IceDefine.PROXY_OBJ_NAME_MESSAGE_SERVICE);
//        PltMessageServicePrx messageServicePrx = PltMessageServicePrxHelper.checkedCast(messageObjectPrx);
//        mObjectPrxMap.put(IceDefine.PROXY_OBJ_NAME_MESSAGE_SERVICE, messageServicePrx);

        Log.d(TAG, "get proxyservice proxy obj...");
        ObjectPrx          proxyObjectPrx  = mCommunicator.stringToProxy(IceDefine.PROXY_OBJ_NAME_PROXY_SERVICE);
        PltProxyServicePrx proxyServicePrx = PltProxyServicePrxHelper.checkedCast(proxyObjectPrx);
        mObjectPrxMap.put(IceDefine.PROXY_OBJ_NAME_PROXY_SERVICE, proxyServicePrx);

        Log.d(TAG, "get fileservice proxy obj...");
        ObjectPrx         fileObjectPrx  = mCommunicator.stringToProxy(IceDefine.PROXY_OBJ_NAME_FILE_SERVICE);
        PltFileServicePrx fileServicePrx = PltFileServicePrxHelper.checkedCast(fileObjectPrx);
        mObjectPrxMap.put(IceDefine.PROXY_OBJ_NAME_FILE_SERVICE, fileServicePrx);
    }

    //创建完毕之后需要做的事情
    @Override
    protected void afterCreate() {
        Log.d(TAG, "CmdConnection.afterCreate()");

        //起心跳
        if (mHeartbeatThread != null) {
            Log.d(TAG, "CmdConnection mHeartbeatThread alread exists!!! MUST BE a BUG!!!");
            mHeartbeatThread.kill();
        }
        mHeartbeatThread = new HeartbeatThread();
        mHeartbeatThread.start();
    }

    //关闭完毕之后需要做的事情
    @Override
    protected void afterClose() {
        Log.d(TAG, "CmdConnection.afterClose()");
        if (mConnectThread != null) {
            mConnectThread.kill();
            mConnectThread = null;
        }
        //停止心跳
        if (mHeartbeatThread != null) {
            mHeartbeatThread.kill();
            mHeartbeatThread = null;
        }
    }

    //观察者，只通知已经连接上了
    public interface OnConnectListener {
        void onConnected();
        void onClosed();
    }

    private class ConnectThread extends Thread {
        private volatile boolean             runFlag;
        private          String              endpoint;
        private          Map<String, String> ctx;
        private Object mLockObj = new Object();

        public ConnectThread(String endpoint, Map<String, String> ctx) {
            this.endpoint = endpoint;
            this.ctx = ctx;
            this.runFlag = true;
        }

        public void kill() {
            this.runFlag = false;
            synchronized (mLockObj) {
                mLockObj.notify();
            }
        }

        public void run() {
            mWorkState = WorkState.TRYING;
            int tryTimes = 0;
            while (runFlag) {
                tryTimes++;
                try {
                    if (mWorkState == WorkState.STOP) {
                        mWorkState = WorkState.IDLE;
                        return;
                    }
                    Log.d(TAG, "CmdConnection tryTimes:" + tryTimes);
                    if (doConnect(mUserId, mPassword, endpoint, ctx)) {
                        // 创建成功
                        mWorkState = WorkState.CONNECT;
                        // 通知观察者
                        if (mConnectListener != null) {
                            mConnectListener.onConnected();
                        }
                        // 成功，不循环了。
                        break;
                    }
                    if (mWorkState == WorkState.STOP) {
                        mWorkState = WorkState.IDLE;
                        return;
                    }
                    // 走到这里，说明创建失败，休眠一会儿，然后再重试
                    try {
                        synchronized (mLockObj) {
                            mLockObj.wait(8 * 1000);
                        }
                    } catch (Exception e) {
                        Log.d(TAG, "", e);
                    }
                } catch (Exception e) {
                    Log.d(TAG, "Create cmd conn failed!", e);
                }
            }
        }

    }

    private class HeartbeatThread extends Thread {

        private volatile boolean runFlag = true;

        public void kill() {
            Log.d("HeartBeat", "CmdConnection heartBeat[" + getId() + "] killed...");
            runFlag = false;
            synchronized (this) {
                this.notifyAll();
            }
        }

        public void notifyToHeartbeat() {
            Log.d("HeartBeat", "CmdConnection notifyToHeartbeat...");
            synchronized (this) {
                this.notifyAll();
            }
        }

        public void run() {
            //心跳间隔，单位：秒。
            long interval = mRouterPrx.getSessionTimeout() / 2;
            while (runFlag) {
                Log.d("HeartBeat", "CmdConnection heartBeat[" + getId() + "] ......");
                try {
                    mRouterPrx.refreshSession();
                } catch (Exception e) {
                    Log.d("HeartBeat", "CmdConnection heartBeat[" + getId() + "] failed!", e);
                    if (runFlag) {
                        runFlag = false;
                        //这里要让连接模块赶紧去重连，
                        //避免如果这个时候网络好的而服务器故障，后续故障恢复之后系统不会去重连的问题。
//                        ConnectionManager.getInstance().closeAndTry();

                        if (mConnectListener != null) {
                            mConnectListener.onClosed();
                        }
                    }
                }
                if (!runFlag) {
                    break;
                }
                //Log.debug("HeartBeat", "CmdConnection heartBeat read to wait,runFlag:"+runFlag);
                synchronized (this) {
                    try {
                        //Log.info("HeartBeat", "CmdConnection heartBeat wait:"+interval*1000);
                        this.wait(interval * 1000);
                    } catch (Exception e) {
                        Log.d("HeartBeat", "", e);
                    }
                }
            }
        }
    }

}
