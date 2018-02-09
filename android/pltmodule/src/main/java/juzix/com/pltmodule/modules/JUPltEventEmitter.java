package juzix.com.pltmodule.modules;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.juzix.plt.service.callback.MsgCallbackManager;
import com.juzix.plt.service.model.PLTMessage;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Nullable;

/**
 * Created by xumin on 2018/2/6.
 */

public class JUPltEventEmitter extends BaseModule {

    public JUPltEventEmitter(ReactApplicationContext reactContext) {
        super(reactContext);
       // addMessageObserver();
    }

    @Override
    public String getName() {
        return JUPltEventEmitter.class.getSimpleName();
    }

    /**
     * 观察PLT推过来的消息
     */
    private void addMessageObserver(){
        MsgCallbackManager.OnMessageReceive onMessageReceive=new MsgCallbackManager.OnMessageReceive() {
            @Override
            public void onReceive(PLTMessage newMsg) {
                reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class).emit(newMsg.msgType,newMsg);
            }
        };
        pltServiceManager.getMsgCallbackManager().addMessageObserver(onMessageReceive);
    }

    @Nullable
    @Override
    public Map<String, Object> getConstants() {
        final Map<String,Object> constants=new HashMap<>();
        constants.put("kEventNameNetworkStatusChange","");
        constants.put("kEventNameUseForceOffline","");
        constants.put("kEventNameUseReveiveNotify","");
        return constants;
    }

    @Override
    public boolean canOverrideExistingModule() {
        return true;
    }
}
