package juzix.com.pltmodule.modules;

import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableMap;
import com.juzix.plt.service.model.BaseReq;
import com.juzix.plt.service.model.InvokeReq;
import com.juzix.plt.service.model.InvokeResp;
import com.juzix.plt.service.model.LoginReq;
import com.juzix.plt.service.model.LoginResp;

import juzix.com.pltmodule.util.Hash;
import juzix.com.pltmodule.util.Numeric;

/**
 * Created by xumin on 2018/2/6.
 */

public class JUPltModule extends BaseModule {
    public JUPltModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return JUPltModule.class.getSimpleName();
    }



    @ReactMethod
    public void userLogin(String loginData,  Promise promise){
        Log.i("userLogin","loginData="+loginData);
        LoginReq loginReq=GsonUtil.jsonToObject(loginData,LoginReq.class);
        loginReq.password= Numeric.toHexStringNoPrefix(Hash.sha3(Numeric.hexStringToByteArray(Numeric.toHexString(loginReq.password.trim())))).toUpperCase();
        String deviceId=pltServiceManager.getDeviceServiceManager().getmDeviceId();
        LoginResp loginResp=pltServiceManager.getUserServiceManager().login(deviceId,GsonUtil.objectToJson(loginReq,LoginReq.class));
        Log.i("userLogin","loginResp="+loginResp.toString());
        promise.resolve(GsonUtil.objectToJson(loginResp,LoginResp.class));
    }

    @ReactMethod
    public void userLogout(String userID,String token,Promise promise){
        BaseReq baseReq=new BaseReq(userID,token);
        pltServiceManager.getUserServiceManager().logout(baseReq);
        promise.resolve("logout success");
    }

    @ReactMethod
    public void proxyInvokeWithInvokeReq(ReadableMap params,Promise promise){
        InvokeResp invokeResp=pltServiceManager.getProxyServiceManager().proxyInvoke(map2InvokeReq(params));
        promise.resolve(invokeResp);
    }

    @ReactMethod
    public void testRNCallObj(ReadableMap params, Promise promise){
        if(params!=null){
            Log.i("testRNCallObj",params.getString("test"));
            Log.i("testRNCallObj",params.getString("key"));
            promise.resolve("成功");
        }else {
            promise.resolve("失败");
        }
    }

    private InvokeReq map2InvokeReq(ReadableMap params){
        InvokeReq invokeReq=new InvokeReq(params.getString("userID"),params.getString("token"),params.getString("cd"),params.getString("data"));
        return invokeReq;
    }
}
