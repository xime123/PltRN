package com.juzix.plt.service.connection;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import Glacier2.CannotCreateSessionException;
import Glacier2.PermissionDeniedException;
import Glacier2.RouterPrx;
import Glacier2.SessionPrx;
import Ice.Communicator;
import Ice.ConnectFailedException;
import Ice.ObjectPrx;
import IceInternal.Ex;

import com.juzix.plt.service.util.IceUtil;

abstract class IceConnection {
    protected final String TAG = "ICE";

    //连接状态的定义
    public enum ConnectionState {
        CONNECTED, CONNECTING, DISCONNECTED
    }

    //工作状态的定义
    public enum WorkState {
        IDLE,//空闲
        TRYING,//正在尝试建立连接
        STOP,//被要求停止
        CONNECT//已经连接
    }

    //连接状态
    public volatile    ConnectionState        connectState;
    protected volatile WorkState              mWorkState;
    //ICE的3个东东
    protected          Communicator           mCommunicator;
    protected          SessionPrx             mSessionPrx;
    protected          RouterPrx              mRouterPrx;
    //用来放ICE代理对象的MAP
    protected          Map<String, ObjectPrx> mObjectPrxMap;
    protected          Context                mContext;
    protected          String                 mName;


    public IceConnection(Context context, String name) {
        mContext = context;
        mName = name;
        connectState = ConnectionState.DISCONNECTED;
        mWorkState = WorkState.IDLE;
        mObjectPrxMap = new HashMap<>();
    }

    //建立连接，异步方法，建立连接的时候调用者不需要等待。
    public void tryConnect(final String userId, final String password, final String endpoint, final Map<String, String> ctx) {
        throw new RuntimeException("unimplement function!!!");

    }

    //建立连接，同步方法，建立连接的时候调用者需要等待。
    public boolean connect(String userId, String password, String endpoint, Map<String, String> ctx) {
        mWorkState = WorkState.TRYING;
        boolean result = doConnect(userId, password, endpoint, ctx);
        if (result) {
            mWorkState = WorkState.CONNECT;
        } else {
            mWorkState = WorkState.IDLE;
        }
        return result;
    }

    //真正创建连接的方法
    protected boolean doConnect(String userId, String password, String endpoint, Map<String, String> ctx) {
        Log.d(TAG, mName + " trying connect to endpoint:" + endpoint);

        //准备连接参数
        // 虚拟机需要这个设置 否则socket出错 需要明确告诉虚拟器使用IPv4的方式
        System.setProperty("java.net.preferIPv4Stack", "true");
        System.setProperty("java.net.preferIPv6Addresses", "false");

        Ice.InitializationData initData = new Ice.InitializationData();
        initData.properties = Ice.Util.createProperties();
        initData.properties.setProperty("Ice.Default.Router", endpoint);
        initData.properties.setProperty("Ice.ACM.Client", "0");
        initData.properties.setProperty("Ice.RetryIntervals", "-1");
        initData.properties.setProperty("Ice.Override.Timeout", "50000");
        initData.properties.setProperty("Ice.Override.ConnectTimeout", "5000");
        initData.properties.setProperty("Ice.Override.CloseTimeout", "5000");
        initData.properties.setProperty("Ice.Default.Package", "com.juzix.plt.slice");

        //跟踪调试设置，需要时才打开。
        //initData.properties.setProperty("Ice.Trace.Network", "3");
        //initData.properties.setProperty("Ice.Trace.Protocol", "1");
        //initData.properties.setProperty("Ice.Trace.Locator", "2");
        //initData.properties.setProperty("IceSSL.Trace.Security", "1");

        //创建communicator
        if (mWorkState == WorkState.STOP) {
            this.cleanup();
            return false;
        }
        mCommunicator = Ice.Util.initialize(initData);

        //创建router
        if (mWorkState == WorkState.STOP) {
            this.cleanup();
            return false;
        }
        Log.d(TAG, "trying get mRouterPrx...");
        mRouterPrx = Glacier2.RouterPrxHelper.uncheckedCast(mCommunicator.getDefaultRouter());
        Log.d(TAG, "mRouterPrx=" + mRouterPrx);

        //创建SESSION
        try {
            if (mWorkState == WorkState.STOP) {
                this.cleanup();
                return false;
            }
            Log.d(TAG, "trying get mSessionPrx...");
            mSessionPrx = mRouterPrx.createSession(userId, password, ctx);
            Log.d(TAG, "mSessionPrx=" + mSessionPrx);
        } catch (CannotCreateSessionException e) {
            // Glacier2 错误错误 创建session失败
            Log.d(TAG, "ICEConnection failed.", e);
            this.cleanup();
            return false;
        } catch (PermissionDeniedException e) {
            // Glacier2 错误错误验证鉴权错误
            Log.d(TAG, "Create ICEConnection failed.", e);
            this.cleanup();
            return false;
        } catch (ConnectFailedException e) {
            // 连接错误 ice 无法连接到服务器 可能网络不通或服务器关闭
            Log.d(TAG, "Create ICEConnection failed.", e);
            this.cleanup();
            return false;
        } catch (Exception e) {
            // 其他错误
            Log.d(TAG, "Create ICEConnection failed.", e);
            this.cleanup();
            return false;
        }

        //获取代理对象
        if (mWorkState == WorkState.STOP) {
            this.cleanup();
            return false;
        }
        try {
            getProxyObjs();
        } catch (Exception e) {
            Log.d(TAG, "getProxyObjs failed.", e);
            this.cleanup();
            return false;
        }

        connectState = ConnectionState.CONNECTED;
        afterCreate();
        return true;
    }

    //创建完毕之后需要做的事情，有需要的话子类可以覆盖
    protected void afterCreate() {

    }

    //关闭完毕之后需要做的事情，有需要的话子类可以覆盖
    protected void afterClose() {

    }

    //如何去获取ICE代理对象，子类必须覆盖
    protected abstract void getProxyObjs();

    //关闭时真正的资源释放，外部不直接调用这个。
    protected void cleanup() {
        Log.d(TAG, mName + ".cleanup()================================");
        //清空代理对象的map
        mObjectPrxMap.clear();
        if (mSessionPrx != null) {
            try {
                mSessionPrx.destroy();
            } catch (Exception exp) {

            }
        }
        if (mRouterPrx != null) {
            try {
                mRouterPrx.destroySession();
            } catch (Exception exp) {

            }
        }
        if (mCommunicator != null) {
            Log.d(TAG, mName + ",mCommunicator.destroyConnect() begin!================");
            try {
                mCommunicator.destroy();
            } catch (Throwable e) {
                Log.d(TAG, "mCommunicator.destroyConnect failed!!!!!!");
            }
            Log.d(TAG, mName + ",mCommunicator.destroyConnect() finished!================");
        }

        mSessionPrx = null;
        mRouterPrx = null;
        mCommunicator = null;
        connectState = ConnectionState.DISCONNECTED;
    }

    public ObjectPrx getObjectPrx(String name) {
        return mObjectPrxMap.get(name);
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

}
