package juzix.com.pltmodule.modules;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.juzix.plt.service.model.BaseReq;
import com.juzix.plt.service.model.LoginReq;

/**
 * Created by xumin on 2018/2/5.
 */

public class UserServiceModule extends BaseModule {
    public UserServiceModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return UserServiceModule.class.getSimpleName();
    }

    @ReactMethod
    public void login(String loginReqJson, Promise promise){
        LoginReq loginReq=GsonUtil.jsonToObject(loginReqJson,LoginReq.class);
       // LoginResp loginResp=pltServiceManager.getUserServiceManager().login(loginReq.deviceId,loginReq.data);
        //promise.resolve(loginResp);
    }

    @ReactMethod
    public void logout(String logoutJson,Promise promise){
        BaseReq baseReq=GsonUtil.jsonToObject(logoutJson,BaseReq.class);
        pltServiceManager.getUserServiceManager().logout(baseReq);
        promise.resolve("logout success");
    }


}
