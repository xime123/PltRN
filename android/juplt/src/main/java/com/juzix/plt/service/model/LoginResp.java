package com.juzix.plt.service.model;

public class LoginResp extends BaseResp {
    public String data;
    public String token;
    public String userId;

    public LoginResp(int errorCode, String errorMsg, String data, String token, String userId) {
        super(errorCode, errorMsg);
        this.data = data;
        this.token = token;
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "LoginResp{" +
            "data='" + data + '\'' +
            ", token='" + token + '\'' +
            ", userId='" + userId + '\'' +
            ", errorCode=" + errorCode +
            ", errorMsg='" + errorMsg + '\'' +
            '}';
    }
}
