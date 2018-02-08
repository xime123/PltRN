package com.juzix.plt.service.model;

public class InvokeResp extends BaseResp {
    /**
     * 业务代码
     */
    public String cd;
    /**
     * 业务请求参数
     */
    public String data;

    /**
     * 无网络连接
     */
    public static final int ERROR_CODE_PLT_DISCONNECTED = -90001;
    public static final String ERROR_MSG_PLT_DISCONNECTED = "服务器连接异常！";

    /**
     * 无代理对象
     */
    public static final int ERROR_CODE_PLT_NO_OBJECTPROXY = -90002;
    public static final String ERROR_MSG_PLT_NO_OBJECTPROXY = "服务器连接异常！";

    /**
     * 获取数据异常
     */
    public static final int ERROR_CODE_PLT_EXCEPTION = -90003;
    public static final String ERROR_MSG_PLT_EXCEPTION = "服务器连接异常！";

    /**
     * 获取数据异常
     */
    public static final int ERROR_CODE_NET_EXCEPTION = -90009;
    public static final String ERROR_MSG_NET_EXCEPTION = "网络连接异常，请检查网络设置!";

    public InvokeResp(String cd, int errorCode, String errorMsg, String data) {
        super(errorCode, errorMsg);
        this.cd = cd;
        this.data = data;
    }
}
