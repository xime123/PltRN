package com.juzix.plt.service.model;

public class DownTaskReq extends BaseReq {
    /**
     * 文件id
     */
    public String fileId;

    public DownTaskReq(String userId, String token, String fileId) {
        super(userId, token);
        this.fileId = fileId;
    }
}
