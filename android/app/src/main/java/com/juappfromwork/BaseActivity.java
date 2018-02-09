package com.juappfromwork;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import juzix.com.pltmodule.PltReactPackage;
import juzix.com.pltmodule.rooter.RNNativeRooter;

/**
 * Created by xumin on 2018/2/9.
 */

public class BaseActivity extends AppCompatActivity{
    protected RNNativeRooter rnNativeRooter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initModule();
    }

    private void initModule(){
        PltReactPackage  pltReactPackage=(PltReactPackage)MainApplication.getInstance().getReactPackageCache().get(PltReactPackage.class.getSimpleName());
        rnNativeRooter= (RNNativeRooter)pltReactPackage.getModuleList().get(2);
    }
}
