package juzix.com.pltmodule;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import juzix.com.pltmodule.modules.JUPltEventEmitter;
import juzix.com.pltmodule.modules.JUPltModule;
import juzix.com.pltmodule.rooter.RNNativeRooter;

/**
 * Created by xumin on 2018/2/5.
 */

public class PltReactPackage implements ReactPackage {
    private List<NativeModule> moduleList=new ArrayList<>();
    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext reactContext) {
        moduleList.add(new JUPltEventEmitter(reactContext));
        moduleList.add(new JUPltModule(reactContext));
        moduleList.add(new RNNativeRooter(reactContext));
        return moduleList;
    }

    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext reactContext) {
        return Collections.emptyList();
    }

    public List<NativeModule> getModuleList() {
        return moduleList;
    }
}
