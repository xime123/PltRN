package com.juzix.plt.service.model;

public class BaseReq implements java.lang.Cloneable, java.io.Serializable {

    /**
     * 用户id
     */
    public String userId;
    /**
     * 登陆令牌
     */
    public String token;

    public BaseReq(String userId, String token) {
        this.userId = userId;
        this.token = token;
    }
}
