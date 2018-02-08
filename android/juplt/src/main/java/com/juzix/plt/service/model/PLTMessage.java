package com.juzix.plt.service.model;

/**
 * Created by xumin on 2018/2/6.
 * 收到消息的封装类
 */

public class PLTMessage {
    public String cd;
    public String msgType;
    public String mode;
    public String label;
    public String msgContent;

    public PLTMessage(String cd, String msgType, String mode, String label, String msgContent) {
        this.cd = cd;
        this.msgType = msgType;
        this.mode = mode;
        this.label = label;
        this.msgContent = msgContent;
    }
}
