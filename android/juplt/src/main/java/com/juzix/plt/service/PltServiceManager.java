package com.juzix.plt.service;

import android.content.Context;

import com.juzix.plt.service.callback.MsgCallbackManager;
import com.juzix.plt.service.connection.ConnectionManager;
import com.juzix.plt.service.device.DeviceServiceManager;
import com.juzix.plt.service.file.FileServiceManager;
import com.juzix.plt.service.proxy.ProxyServiceManager;
import com.juzix.plt.service.user.UserServiceManager;

public class PltServiceManager {
    private UserServiceManager   mUserServiceManager;
    private DeviceServiceManager mDeviceServiceManager;
    private FileServiceManager   mFileServiceManager;
    private ProxyServiceManager  mProxyServiceManager;
    private ConnectionManager    mConnectionManager;
    private MsgCallbackManager   mMsgCallbackManager;


    public static PltServiceManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public UserServiceManager getUserServiceManager() {
        return mUserServiceManager;
    }

    public DeviceServiceManager getDeviceServiceManager() {
        return mDeviceServiceManager;
    }

    public FileServiceManager getFileServiceManager() {
        return mFileServiceManager;
    }

    public ProxyServiceManager getProxyServiceManager() {
        return mProxyServiceManager;
    }

    public ConnectionManager getConnectionManager() {
        return mConnectionManager;
    }

    public MsgCallbackManager getMsgCallbackManager() {
        return mMsgCallbackManager;
    }



    public void init(Context context) {
        mConnectionManager = ConnectionManager.getInstance();
        mUserServiceManager = UserServiceManager.getInstance();
        mDeviceServiceManager = DeviceServiceManager.getInstance();
        mFileServiceManager = FileServiceManager.getInstance();
        mProxyServiceManager = ProxyServiceManager.getInstance();
        mMsgCallbackManager = MsgCallbackManager.getInstance();

        mMsgCallbackManager.init();
        mConnectionManager.init(context);
    }

    public void start() {
        mConnectionManager.startConnect();
    }

    public boolean connected(){
        return mConnectionManager.isConnected();
    }

    public void destroy() {
        mConnectionManager.destroyConnect();
    }


//    public String getDeviceId(){
//        return mDeviceServiceManager.getDeviceId(IceUtil.getOsType(), IceUtil.getIdentifier(mContext));
//    }
//
//    public boolean setCallback() {
//        //连接成功后，获取deviceId后设置回调
//        String deviceId = mDeviceServiceManager.getDeviceId(IceUtil.getOsType(), IceUtil.getIdentifier(mContext));
//        if (TextUtils.isEmpty(deviceId)) {
//            return false;
//        }
//
//        return mConnectionManager.setConnectCallback(deviceId, mMsgCallbackManager.getMsgCallback());
//    }

    private PltServiceManager() {
    }

    private static class InstanceHolder {
        private static volatile PltServiceManager INSTANCE = new PltServiceManager();
    }
}
