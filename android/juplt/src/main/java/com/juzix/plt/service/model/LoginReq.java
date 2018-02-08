package com.juzix.plt.service.model;

/**
 * Created by xumin on 2018/2/7.
 */

public class LoginReq extends BaseReq {
    public LoginReq(String userId, String token) {
        super(userId, token);
    }
    public String type;
    public String mobile;
    public String password;
}
