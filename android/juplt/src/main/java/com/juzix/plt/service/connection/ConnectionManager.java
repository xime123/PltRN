package com.juzix.plt.service.connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.util.Log;

import com.juzix.plt.service.PltOnConnectListener;
import com.juzix.plt.service.PltServiceManager;
import com.juzix.plt.service.callback.MsgCallback;
import com.juzix.plt.service.callback.MsgCallbackManager;
import com.juzix.plt.service.connection.PltConnection.OnConnectListener;
import com.juzix.plt.service.crypt.RSA;
import com.juzix.plt.service.device.DeviceServiceManager;
import com.juzix.plt.service.util.IceUtil;
import com.juzix.plt.service.util.NetworkUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ice.ObjectPrx;

public class ConnectionManager {

    public static final String TAG = "ConnectionManager";
    // 链接的实例
    private Context       mContext;
    private PltConnection mPltConnection;

    public static ConnectionManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    private List<PltOnConnectListener> connectListeners=new ArrayList<>();

    /**
     * 初始化
     *
     * @param context
     */
    public void init(Context context) {
        mContext = context;
        mPltConnection = new PltConnection(context, "COMMAND");
        mPltConnection.setOnConnectListener(mConnectionListener);
        mContext.registerReceiver(mBroadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));
    }

    /**
     * 创建连接
     */
    public void startConnect() {
        Log.d(TAG, "startConnect()");
        doConnect();
        notifyAllConnectListener(0, "");
        notifyAllConnectListener(0,"");
    }

    /**
     * 销毁
     */
    public void destroyConnect() {
        try {
            mContext.unregisterReceiver(mBroadcastReceiver);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        closeConnect();
        mConnectionListener = null;
        mPltConnection = null;
    }

    public void addPltOnConnectListener(PltOnConnectListener listener){
        connectListeners.add(listener);
    }

    public void notifyPltConnectListeners(String deviceId){

    }

    /**
     * 获取ICE代理对象
     *
     * @param name 对象名称
     * @return 代理对象
     */
    public ObjectPrx getObjectProxy(String name) {
        if (!isConnected()) {
            return null;
        }

        if (mPltConnection == null){
            return null;
        }

        return mPltConnection.getObjectPrx(name);
    }

    /**
     * 是否有网络连接
     */
    public boolean checkNetWork(){
        return NetworkUtil.checkNetWork(mContext);
    }

    /**
     * 判断是否已经连接服务器。
     */
    public boolean isConnected() {
        if (mPltConnection == null){
            return false;
        }
        return mPltConnection.connectState == IceConnection.ConnectionState.CONNECTED;
    }

    /**
     * 设置回调
     */
    private boolean setConnectCallback(String deviceId, MsgCallback callback) {
        if (mPltConnection == null){
            return false;
        }

        return mPltConnection.setMsgCallback(deviceId, callback);
    }



    private void notifyAllConnectListener(int status, String deviceId) {
        if(connectListeners.size()==0)return;
        switch (status) {
            case -1:
                for(PltOnConnectListener connectListener:connectListeners){
                    connectListener.onDisconnected();
                }
                break;
            case 0:
                for(PltOnConnectListener connectListener:connectListeners){
                    connectListener.onConnecting();
                }
                break;
            case 1:
                for(PltOnConnectListener connectListener:connectListeners){
                    connectListener.onConnected(deviceId);
                }
                break;
            case 2:
                for(PltOnConnectListener connectListener:connectListeners){
                    connectListener.onReconnecting();
                }
                break;
        }
    }

    private void doConnect() {
        // 检查物理网络是否可用
        if (!checkNetWork()) {
            return;
        }

        String uid = IceUtil.getIdentifier(mContext);
        String pwd = RSA.encrypt(uid);

        // 建立cmd链接
        Map<String, String> ctx = new HashMap<>();
        ctx.put("osType", IceUtil.getOsType());
        if (mPltConnection != null){
            mPltConnection.tryConnect(uid, pwd, "MyRouter/router:tcp -h 192.168.9.80 -p 4065", ctx);
        }
    }

    private void closeConnect() {
        if (mPltConnection != null) {
            mPltConnection.close();
        }
    }

    // 关闭所有连接，同时再重试
    private void reconnect() {
        Log.d(TAG, "reConnect()");
        closeConnect();
        doConnect();
    }

    private BroadcastReceiver mBroadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, "ConnectionManager Inner BroadcastReceiver.onReceive:");
            if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
                if (NetworkUtil.checkNetWork(context)) {
                    reconnect();
                    notifyAllConnectListener(2,"");
                } else {
                    closeConnect();
                    notifyAllConnectListener(-1,"");
                }
            }
        }
    };

    private OnConnectListener mConnectionListener = new OnConnectListener() {

        @Override
        public void onConnected() {
            PltServiceManager    pltServiceManager    = PltServiceManager.getInstance();
            DeviceServiceManager deviceServiceManager = pltServiceManager.getDeviceServiceManager();
            String               deviceId             = deviceServiceManager.getDeviceId(IceUtil.getOsType(), IceUtil.getIdentifier(mContext));
            MsgCallbackManager   msgCallbackManager   = pltServiceManager.getMsgCallbackManager();
            boolean              enabled              = setConnectCallback(deviceId, msgCallbackManager.getMsgCallback());
            ConnectionManager.this.notifyAllConnectListener(1, deviceId);
        }

        @Override
        public void onClosed() {
            reconnect();
            ConnectionManager.this.notifyAllConnectListener(2, "");
        }
    };

    private ConnectionManager() {
        /*
         * 步骤：
         *
         * 1、初始化
         * 2、创建连接
         * 3、获取deviceId
         * 4、设置回调
         */
    }

    private static class InstanceHolder {
        private static volatile ConnectionManager INSTANCE = new ConnectionManager();
    }
}
