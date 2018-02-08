package com.juzix.plt.service.model;

public class DownFileResp implements Cloneable, java.io.Serializable {
    /**
     * 文件id
     */
    public String fileId;
    /**
     * 文件总字节数
     */
    public int    totalBytes;
    /**
     * 开始字节数
     **/
    public int    startBytes;
    /**
     * 结束字节数
     **/
    public int    endBytes;
    /**
     * 内容
     **/
    public byte[] content;

    public DownFileResp(String fileId, int totalBytes, int startBytes, int endBytes, byte[] contents) {
        this.fileId = fileId;
        this.totalBytes = totalBytes;
        this.startBytes = startBytes;
        this.endBytes = endBytes;
        this.content = contents;
    }
}
