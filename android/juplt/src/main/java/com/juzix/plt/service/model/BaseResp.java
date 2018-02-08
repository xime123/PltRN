package com.juzix.plt.service.model;

public class BaseResp implements java.lang.Cloneable, java.io.Serializable {
    /**
     * 错误码
     */
    public int    errorCode;
    /**
     * 错误信息
     */
    public String errorMsg;

    public BaseResp(int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }
}
