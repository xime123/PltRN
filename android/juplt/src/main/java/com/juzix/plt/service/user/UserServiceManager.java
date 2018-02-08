package com.juzix.plt.service.user;

import com.juzix.plt.service.IServiceManager;
import com.juzix.plt.service.PltServiceManager;
import com.juzix.plt.service.model.BaseReq;
import com.juzix.plt.service.model.InvokeResp;
import com.juzix.plt.service.model.LoginResp;
import com.juzix.plt.service.util.IceDefine;
import com.juzix.plt.slice.user.PltLoginResp;
import com.juzix.plt.slice.user.PltUserServicePrx;


public class UserServiceManager implements IServiceManager {

    private UserServiceManager() {
    }

    public static UserServiceManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void init() {

    }

    @Override
    public boolean checkNetwork() {
        return PltServiceManager.getInstance().getConnectionManager().checkNetWork();
    }

    @Override
    public boolean connected() {
        return PltServiceManager.getInstance().getConnectionManager().isConnected();
    }

    public LoginResp login(String deviceId, String data) {
        if (!checkNetwork()){
            return new LoginResp(InvokeResp.ERROR_CODE_NET_EXCEPTION, InvokeResp.ERROR_MSG_NET_EXCEPTION,
                    "", "", "");
        }

        if (!connected()){
            return new LoginResp(InvokeResp.ERROR_CODE_PLT_DISCONNECTED, InvokeResp.ERROR_MSG_PLT_DISCONNECTED,
                    "", "", "");
        }

        PltUserServicePrx proxyServicePrx = (PltUserServicePrx) PltServiceManager.getInstance().getConnectionManager().getObjectProxy(IceDefine.PROXY_OBJ_NAME_USER_SERVICE);
        if (proxyServicePrx == null) {
            return new LoginResp(InvokeResp.ERROR_CODE_PLT_NO_OBJECTPROXY, InvokeResp.ERROR_MSG_PLT_NO_OBJECTPROXY,
                    "", "", "");
        }

        try {
            PltLoginResp pltLoginResp = proxyServicePrx.login(deviceId, data);
            if (pltLoginResp == null) {
                return new LoginResp(InvokeResp.ERROR_CODE_PLT_EXCEPTION, InvokeResp.ERROR_MSG_PLT_EXCEPTION,
                        "", "", "");
            }

            return new LoginResp(pltLoginResp.getErrorCode(), pltLoginResp.getErrorMsg(), pltLoginResp.getData(),
                    pltLoginResp.getToken(), pltLoginResp.getUserId());
        } catch (Exception e) {
            e.printStackTrace();
            return new LoginResp(InvokeResp.ERROR_CODE_PLT_EXCEPTION, InvokeResp.ERROR_MSG_PLT_EXCEPTION,
                    "", "", "");
        }
    }

    public void logout(BaseReq req) {

        PltUserServicePrx proxyServicePrx = (PltUserServicePrx) PltServiceManager.getInstance().getConnectionManager().getObjectProxy(IceDefine.PROXY_OBJ_NAME_USER_SERVICE);
        if (proxyServicePrx == null) {
            return;
        }

        try {
            proxyServicePrx.logout(req.userId, req.token);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static class InstanceHolder {
        private static volatile UserServiceManager INSTANCE = new UserServiceManager();
    }
}
