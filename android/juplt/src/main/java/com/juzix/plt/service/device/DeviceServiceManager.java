package com.juzix.plt.service.device;


import com.juzix.plt.service.IServiceManager;
import com.juzix.plt.service.PltServiceManager;
import com.juzix.plt.service.util.IceDefine;
import com.juzix.plt.slice.device.PltDeviceServicePrx;

public class DeviceServiceManager implements IServiceManager {

    private String mDeviceId;

    private DeviceServiceManager() {

    }

    public static DeviceServiceManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void init() {

    }

    @Override
    public boolean checkNetwork() {
        return PltServiceManager.getInstance().getConnectionManager().checkNetWork();
    }

    @Override
    public boolean connected() {
        return PltServiceManager.getInstance().getConnectionManager().isConnected();
    }

    /**
     * 设备注册
     *
     * @param osType 系统类型
     * @param identifier 设备标识
     *
     * @return 设备id
     **/
    public String getDeviceId(String osType, String identifier) {
        PltDeviceServicePrx deviceServicePrx = (PltDeviceServicePrx) PltServiceManager.getInstance().getConnectionManager().getObjectProxy(IceDefine.PROXY_OBJ_NAME_DEVICE_SERVICE);
        if (deviceServicePrx == null) {
            mDeviceId = null;
            return null;
        }

        try {
            mDeviceId = deviceServicePrx.register(osType, identifier, "");
            return mDeviceId;
        } catch (Exception e) {
            e.printStackTrace();
            mDeviceId = null;
            return null;
        }
    }

    public String getmDeviceId() {
        return mDeviceId;
    }

    private static class InstanceHolder {
        private static volatile DeviceServiceManager INSTANCE = new DeviceServiceManager();
    }

}
