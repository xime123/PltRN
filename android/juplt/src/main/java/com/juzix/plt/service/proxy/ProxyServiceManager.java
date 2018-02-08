package com.juzix.plt.service.proxy;


import com.juzix.plt.service.IServiceManager;
import com.juzix.plt.service.PltServiceManager;
import com.juzix.plt.service.model.InvokeReq;
import com.juzix.plt.service.model.InvokeResp;
import com.juzix.plt.service.util.IceDefine;
import com.juzix.plt.slice.common.PltException;
import com.juzix.plt.slice.proxy.PltInvokeReq;
import com.juzix.plt.slice.proxy.PltInvokeResp;
import com.juzix.plt.slice.proxy.PltProxyServicePrx;

public class ProxyServiceManager implements IServiceManager {

    private ProxyServiceManager() {
    }

    public static ProxyServiceManager getInstance() {
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

    public InvokeResp proxyInvoke(InvokeReq invokeReq) {
        if (!checkNetwork()){
            return new InvokeResp(invokeReq.cd, InvokeResp.ERROR_CODE_NET_EXCEPTION, InvokeResp.ERROR_MSG_NET_EXCEPTION, "");
        }

        if (!connected()){
            return new InvokeResp(invokeReq.cd, InvokeResp.ERROR_CODE_PLT_DISCONNECTED, InvokeResp.ERROR_MSG_PLT_DISCONNECTED, "");
        }

        try {
            PltProxyServicePrx proxyServicePrx = (PltProxyServicePrx) PltServiceManager.getInstance().getConnectionManager().getObjectProxy(IceDefine.PROXY_OBJ_NAME_PROXY_SERVICE);
            if (proxyServicePrx == null) {
                return new InvokeResp(invokeReq.cd, InvokeResp.ERROR_CODE_PLT_NO_OBJECTPROXY, InvokeResp.ERROR_MSG_PLT_NO_OBJECTPROXY, "");
            }
            PltInvokeResp pltInvokeResp = proxyServicePrx.invoke(new PltInvokeReq(invokeReq.cd, invokeReq.data, invokeReq.userId, invokeReq.token));
            if (pltInvokeResp == null) {
                return new InvokeResp(invokeReq.cd, InvokeResp.ERROR_CODE_PLT_EXCEPTION, InvokeResp.ERROR_MSG_PLT_EXCEPTION, "");
            }

            return new InvokeResp(pltInvokeResp.getCd(), pltInvokeResp.getErrorCode(), pltInvokeResp.getErrorMsg(), pltInvokeResp.getData());
        } catch (Exception e) {
            e.printStackTrace();
            return new InvokeResp(invokeReq.cd, InvokeResp.ERROR_CODE_PLT_EXCEPTION, InvokeResp.ERROR_MSG_PLT_EXCEPTION, "");
        }
    }

    private static class InstanceHolder {
        private static volatile ProxyServiceManager INSTANCE = new ProxyServiceManager();
    }
}
