package juzix.com.pltmodule.modules;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.juzix.plt.service.model.InvokeReq;
import com.juzix.plt.service.model.InvokeResp;

/**
 * Created by xumin on 2018/2/5.
 */

public class ProxyServiceModule extends BaseModule {

    public ProxyServiceModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return ProxyServiceModule.class.getSimpleName();
    }

    @ReactMethod
    public void proxyExcute(String proxyJson, Promise promise){
        InvokeReq invokeReq=GsonUtil.jsonToObject(proxyJson,InvokeReq.class);
        InvokeResp invokeResp= pltServiceManager.getProxyServiceManager().proxyInvoke(invokeReq);
        promise.resolve(invokeResp);
    }


}
