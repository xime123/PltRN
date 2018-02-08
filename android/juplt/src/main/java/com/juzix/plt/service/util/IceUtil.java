package com.juzix.plt.service.util;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import java.util.UUID;


public class IceUtil {

    private static final String PREFERS_NAME       = "plt_slice.in";
    private static final String PREFERS_KEY_DEV_ID = "dev_id";

    public static String getOsType() {
        return "Android" + "_" + android.os.Build.MODEL + "_" + android.os.Build.VERSION.RELEASE;
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }

    public static String getIdentifier(Context context) {
        String identifier = PrefersUtil.getString(context, PREFERS_NAME, PREFERS_KEY_DEV_ID, "");
        if (TextUtils.isEmpty(identifier)) {
            identifier = generateIndentifier(context);
            PrefersUtil.setString(context, PREFERS_NAME, PREFERS_KEY_DEV_ID, identifier);
        }

        return identifier;
    }

    private static String generateIndentifier(Context context) {
        StringBuilder deviceId = new StringBuilder();
        // 渠道标志
        deviceId.append("os=Android");
        try {
            //wifi mac地址
            WifiManager wifi = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo    info = wifi.getConnectionInfo();
            String      mac  = info.getMacAddress();
            if (!TextUtils.isEmpty(mac)) {
                deviceId.append("&mac=").append(mac);
                return deviceId.toString();
            }
            //IMEI（imei）
            TelephonyManager tm   = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            String           imei = tm.getDeviceId();
            if (!TextUtils.isEmpty(imei)) {
                deviceId.append("&imei=").append(imei);
                return deviceId.toString();
            }
            //序列号（sn）
            String sn = tm.getSimSerialNumber();
            if (!TextUtils.isEmpty(sn)) {
                deviceId.append("&sn=").append(sn);
                return deviceId.toString();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        //如果上面都没有， 则生成一个id：随机码
        deviceId.append("&id=").append(getUUID());

        return deviceId.toString();
    }
}
