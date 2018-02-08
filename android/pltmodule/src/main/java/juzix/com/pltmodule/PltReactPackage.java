package juzix.com.pltmodule;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import juzix.com.pltmodule.modules.DeviceServiceModule;
import juzix.com.pltmodule.modules.FileServiceModule;
import juzix.com.pltmodule.modules.JUPltEventEmitter;
import juzix.com.pltmodule.modules.JUPltModule;

/**
 * Created by xumin on 2018/2/5.
 */

public class PltReactPackage implements ReactPackage {
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        return Arrays.<NativeModule>asList(
            new DeviceServiceModule(reactContext),
            new FileServiceModule(reactContext),
            new JUPltEventEmitter(reactContext),
            new JUPltModule(reactContext)
        );
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }
}
