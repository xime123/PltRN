package com.juappfromwork;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.facebook.react.ReactApplication;
import com.facebook.react.ReactNativeHost;
import com.facebook.react.ReactPackage;
import com.facebook.react.shell.MainReactPackage;
import com.facebook.soloader.SoLoader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import juzix.com.pltmodule.PltReactPackage;

public class MainApplication extends Application implements ReactApplication {
  private static MainApplication instance;
  private Map<String,ReactPackage> reactPackageCache=new HashMap();
  private final ReactNativeHost mReactNativeHost = new ReactNativeHost(this) {
    @Override
    public boolean getUseDeveloperSupport() {
      return BuildConfig.DEBUG;
    }

    @Override
    protected List<ReactPackage> getPackages() {
      return Arrays.<ReactPackage>asList(
          new MainReactPackage(),
          new PltReactPackage(),
          reactPackageCache.get(PltReactPackage.class.getSimpleName())
      );
    }

    @Override
    protected String getJSMainModuleName() {
      return "index";
    }
  };

  @Override
  public ReactNativeHost getReactNativeHost() {
    return mReactNativeHost;
  }

  @Override
  public void onCreate() {
    super.onCreate();
    SoLoader.init(this, /* native exopackage */ false);
    reactPackageCache.put(PltReactPackage.class.getSimpleName(),new PltReactPackage());
    instance=this;
  }

  @Override
  public void attachBaseContext(Context base) {
    MultiDex.install(base);
    super.attachBaseContext(base);
  }

  public static MainApplication getInstance(){
    return instance;
  }

  public Map<String, ReactPackage> getReactPackageCache() {
    return reactPackageCache;
  }
}
