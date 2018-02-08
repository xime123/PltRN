package juzix.com.pltmodule.modules;

import com.facebook.react.bridge.ReactApplicationContext;

/**
 * Created by xumin on 2018/2/5.
 */

public class DeviceServiceModule extends BaseModule {


    public DeviceServiceModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return DeviceServiceModule.class.getSimpleName();
    }


}
