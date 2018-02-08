package com.juzix.plt.service.model;

public class UploadTaskReq extends BaseReq {
    public int    totalBytes;
    public byte[] content;
    public String fileType;

    public UploadTaskReq(String userId, String token, int totalBytes, byte[] content, String fileType) {
        super(userId, token);
        this.totalBytes = totalBytes;
        this.content = content;
        this.fileType = fileType;
    }
}
