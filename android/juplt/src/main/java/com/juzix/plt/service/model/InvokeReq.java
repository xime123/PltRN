package com.juzix.plt.service.model;

public class InvokeReq extends BaseReq {
    /**
     * 业务代码
     */
    public String cd;
    /**
     * 业务请求参数
     */
    public String data;

    public InvokeReq(String userId, String token, String cd, String data) {
        super(userId, token);
        this.cd = cd;
        this.data = data;
    }
}
