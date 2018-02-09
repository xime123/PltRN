package juzix.com.pltmodule.rooter;

import android.app.Activity;
import android.content.Intent;

import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.modules.core.DeviceEventManagerModule;

import juzix.com.pltmodule.modules.GsonUtil;

/**
 * Created by xumin on 2018/2/9.
 */

public class RNNativeRooter  extends ReactContextBaseJavaModule implements RNNativeRooterInterface{
    public static int NATIVE_ROOTER_TYPE=1;
    public static int RN_ROOTER_TYPE=2;
    public final static  String ROOTER_RN="ROOTER_RN";
    public RNNativeRooter(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return RNNativeRooter.class.getSimpleName();
    }


    @Override
    @ReactMethod
    public void pushComponent(String rooterActionJson) {
        RooterAction rooterAction= GsonUtil.jsonToObject(rooterActionJson,RooterAction.class);
        if(rooterAction.rooterType==NATIVE_ROOTER_TYPE){
            try{
                Activity currentActivity = getCurrentActivity();
                if(null!=currentActivity){
                    Class toActivity = Class.forName(rooterAction.targetComponent);
                    Intent intent = new Intent(currentActivity,toActivity);
                    intent.putExtra("params", rooterAction.props);
                    currentActivity.startActivity(intent);
                }
            }catch(Exception e){
                throw new JSApplicationIllegalArgumentException(
                    "不能打开Activity : "+e.getMessage());
            }

        }else if(rooterAction.rooterType==RN_ROOTER_TYPE){
                getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(ROOTER_RN,rooterActionJson);
        }else {
            throw new JSApplicationIllegalArgumentException(
                "rooter类型不正确");
        }


    }

    @Override
    @ReactMethod
    public void popComponent(RooterAction rooterActionJson) {

    }

    @Override
    @ReactMethod
    public void popToRootComponent(RooterAction rooterActionJson) {

    }

    @Override
    public boolean canOverrideExistingModule() {
        return true;
    }
}
