package com.juzix.plt.service.model;

public class DownTaskResp implements java.lang.Cloneable, java.io.Serializable {
    /**
     * 文件id
     */
    public String fileId;
    /**
     * 文件总字节数
     */
    public int    totalBytes;

    public DownTaskResp(String fileId, int totalBytes) {
        this.fileId = fileId;
        this.totalBytes = totalBytes;
    }
}
