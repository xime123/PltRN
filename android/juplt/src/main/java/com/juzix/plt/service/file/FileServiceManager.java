package com.juzix.plt.service.file;


import com.juzix.plt.service.IServiceManager;
import com.juzix.plt.service.PltServiceManager;
import com.juzix.plt.service.model.DownFileReq;
import com.juzix.plt.service.model.DownFileResp;
import com.juzix.plt.service.model.DownTaskReq;
import com.juzix.plt.service.model.DownTaskResp;
import com.juzix.plt.service.model.UploadTaskReq;
import com.juzix.plt.service.util.IceDefine;
import com.juzix.plt.slice.common.PltException;
import com.juzix.plt.slice.file.PltDownTaskResp;
import com.juzix.plt.slice.file.PltFileDownReq;
import com.juzix.plt.slice.file.PltFileDownResp;
import com.juzix.plt.slice.file.PltFileServicePrx;

public class FileServiceManager implements IServiceManager {

    private FileServiceManager() {
    }

    public static FileServiceManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void init() {

    }

    @Override
    public boolean checkNetwork() {
        return PltServiceManager.getInstance().getConnectionManager().checkNetWork();
    }

    @Override
    public boolean connected() {
        return PltServiceManager.getInstance().getConnectionManager().isConnected();
    }

    /**
     * 小文件上传
     *
     * @param uploadTask 用户id
     * @return fileId 文件id
     */
    public String smallFileUpload(UploadTaskReq uploadTask) {
        PltFileServicePrx fileServicePrx = (PltFileServicePrx) PltServiceManager.getInstance().getConnectionManager().getObjectProxy(IceDefine.PROXY_OBJ_NAME_FILE_SERVICE);
        if (fileServicePrx == null) {
            return null;
        }

        try {
            return fileServicePrx.smallFileUpload(uploadTask.userId, uploadTask.token,
                    uploadTask.totalBytes, uploadTask.content, uploadTask.fileType);
        } catch (PltException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 大文件上传
     *
     * @param uploadTask 用户id
     * @return fileId 文件id
     */
    public String createUpTask(UploadTaskReq uploadTask) {
        PltFileServicePrx fileServicePrx = (PltFileServicePrx) PltServiceManager.getInstance().getConnectionManager().getObjectProxy(IceDefine.PROXY_OBJ_NAME_FILE_SERVICE);
        if (fileServicePrx == null) {

            return null;
        }

        try {
            return fileServicePrx.createUpTask(uploadTask.userId, uploadTask.token,
                    uploadTask.totalBytes, uploadTask.fileType);
        } catch (PltException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 创建文件下载任务
     *
     * @param downTaskReq 下载任务
     * @return fileId 文件id
     */
    public DownTaskResp createDownloadTask(DownTaskReq downTaskReq) {
        PltFileServicePrx fileServicePrx = (PltFileServicePrx) PltServiceManager.getInstance().getConnectionManager().getObjectProxy(IceDefine.PROXY_OBJ_NAME_FILE_SERVICE);
        if (fileServicePrx == null) {
            return null;
        }

        try {
            PltDownTaskResp pltDownTaskResp = fileServicePrx.createDownTask(downTaskReq.userId, downTaskReq.token,
                    downTaskReq.fileId);
            if (pltDownTaskResp == null) {
                return null;
            }

            return new DownTaskResp(pltDownTaskResp.getFileId(), pltDownTaskResp.getTotalBytes());
        } catch (PltException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 下载文件
     *
     * @param downFileReq 下载任务
     * @return fileId 文件id
     */
    public DownFileResp fileDown(DownFileReq downFileReq) {
        PltFileServicePrx fileServicePrx = (PltFileServicePrx) PltServiceManager.getInstance().getConnectionManager().getObjectProxy(IceDefine.PROXY_OBJ_NAME_FILE_SERVICE);
        if (fileServicePrx == null) {
            return null;
        }

        try {
            PltFileDownResp pltFileDownResp = fileServicePrx.fileDown(new PltFileDownReq(downFileReq.fileId, downFileReq.startBytes, downFileReq.endBytes));
            if (pltFileDownResp == null) {
                return null;
            }

            return new DownFileResp(pltFileDownResp.getFileId(), pltFileDownResp.getTotalBytes(), pltFileDownResp.getStartBytes(),
                    pltFileDownResp.getEndBytes(), pltFileDownResp.getContent());
        } catch (PltException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 小文件下载
     *
     * @param downTaskReq 下载任务
     * @return fileId 文件id
     */
    public DownFileResp smallFileDownload(DownTaskReq downTaskReq) {

        PltFileServicePrx fileServicePrx = (PltFileServicePrx) PltServiceManager.getInstance().getConnectionManager().getObjectProxy(IceDefine.PROXY_OBJ_NAME_FILE_SERVICE);
        if (fileServicePrx == null) {
            return null;
        }

        try {
            PltDownTaskResp pltDownTaskResp = fileServicePrx.createDownTask(downTaskReq.userId, downTaskReq.token, downTaskReq.fileId);
            if (pltDownTaskResp == null) {
                return null;
            }

            PltFileDownResp pltFileDownResp = fileServicePrx.fileDown(new PltFileDownReq(pltDownTaskResp.getFileId(), 0, pltDownTaskResp.getTotalBytes()));
            if (pltFileDownResp == null) {
                return null;
            }

            return new DownFileResp(pltFileDownResp.getFileId(), pltFileDownResp.getTotalBytes(),
                    pltFileDownResp.getStartBytes(), pltFileDownResp.getEndBytes(), pltFileDownResp.getContent());
        } catch (PltException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static class InstanceHolder {
        private static volatile FileServiceManager INSTANCE = new FileServiceManager();
    }
}
