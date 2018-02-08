package juzix.com.pltmodule.modules;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.juzix.plt.service.PltServiceManager;

/**
 * Created by xumin on 2018/2/5.
 */

public abstract class BaseModule extends ReactContextBaseJavaModule {

    protected PltServiceManager pltServiceManager;
    protected ReactApplicationContext reactContext;

    public BaseModule(ReactApplicationContext reactContext) {
        super(reactContext);
        pltServiceManager= PltServiceManager.getInstance();
        this.reactContext=reactContext;
    }

    public ReactApplicationContext getReactContext() {
        return reactContext;
    }
}
