package com.juzix.plt.service.model;

public class DownFileReq extends BaseReq {
    /**
     * 文件id
     */
    public String fileId;

    /**
     * 开始字节数
     **/
    public int startBytes;

    /**
     * 结束字节数
     **/
    public int endBytes;

    public DownFileReq(String fileId, int startBytes, int endBytes) {
        super("", "");
        this.fileId = fileId;
        this.startBytes = startBytes;
        this.endBytes = endBytes;
    }
}
