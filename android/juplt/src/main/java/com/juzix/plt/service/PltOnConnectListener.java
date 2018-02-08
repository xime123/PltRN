package com.juzix.plt.service;

public interface PltOnConnectListener {
    void onConnected(String deviceId);
    void onConnecting();
    void onReconnecting();
    void onDisconnected();
}
