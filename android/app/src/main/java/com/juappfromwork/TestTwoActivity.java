package com.juappfromwork;

import android.os.Bundle;
import android.view.View;

import juzix.com.pltmodule.modules.GsonUtil;
import juzix.com.pltmodule.rooter.RooterAction;

public class TestTwoActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_two);
    }

    public void jumpToRn(View view) {
        RooterAction rooterAction=new RooterAction();
        rooterAction.rooterType=2;
        rooterAction.moduleName="index";
        rooterAction.props="来自Native层的数据";
        rooterAction.orginComponent="TestTwoActivity";
        rooterAction.targetComponent="LoginPage";
        rnNativeRooter.pushComponent(GsonUtil.objectToJson(rooterAction,RooterAction.class));
        finish();
    }
}
