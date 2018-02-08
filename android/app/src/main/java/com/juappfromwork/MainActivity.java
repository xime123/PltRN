package com.juappfromwork;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.facebook.react.ReactActivity;
import com.juzix.plt.service.PltOnConnectListener;
import com.juzix.plt.service.PltServiceManager;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript.
     * This is used to schedule rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "JuAppFromwork";
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PltServiceManager.getInstance().init(this);
        PltServiceManager.getInstance().start();
        PltServiceManager.getInstance().getConnectionManager().addPltOnConnectListener(new PltOnConnectListener() {
            @Override
            public void onConnected(String deviceId) {
                Toast.makeText(MainActivity.this,"连接成功 deviceId="+deviceId,Toast.LENGTH_LONG).show();
                Log.i("MainActivity","连接成功 deviceId="+deviceId);
            }

            @Override
            public void onConnecting() {
                Log.i("MainActivity","连接中... ");
                Toast.makeText(MainActivity.this,"连接中...",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onReconnecting() {
                Log.i("MainActivity","重新连接中... ");
                Toast.makeText(MainActivity.this,"重新连接中...",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onDisconnected() {
                Log.i("MainActivity","失去连接... ");
                Toast.makeText(MainActivity.this,"失去连接",Toast.LENGTH_LONG).show();
            }
        });
    }
}
