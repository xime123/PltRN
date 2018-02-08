package juzix.com.pltmodule.modules;

import android.text.TextUtils;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMethod;
import com.juzix.plt.service.model.DownFileResp;
import com.juzix.plt.service.model.DownTaskReq;
import com.juzix.plt.service.model.UploadTaskReq;

/**
 * Created by xumin on 2018/2/5.
 */

public class FileServiceModule extends BaseModule {

    public FileServiceModule(ReactApplicationContext reactContext) {
        super(reactContext);
    }

    @Override
    public String getName() {
        return FileServiceModule.class.getSimpleName();
    }

    @ReactMethod
    public void smallFileUpload(String uploadReq, Promise promise){
        //这里有可能只传哥路径名，待定
        UploadTaskReq uploadTaskReq=GsonUtil.jsonToObject(uploadReq,UploadTaskReq.class);
        String fileId=pltServiceManager.getFileServiceManager().smallFileUpload(uploadTaskReq);
        if(TextUtils.isEmpty(fileId)){
            promise.reject(new Throwable("upload file failed"));
        }else {
            promise.resolve(fileId);
        }
    }

    @ReactMethod
    public void smallFileDownload(String downTaskReq,Promise promise){
        //这里有可能只传哥路径名，待定
        DownTaskReq downTask=GsonUtil.jsonToObject(downTaskReq,DownTaskReq.class);
        DownFileResp downFileResp=pltServiceManager.getFileServiceManager().smallFileDownload(downTask);
        if(downFileResp==null){
            promise.reject(new Throwable("upload file failed"));
        }else {
            promise.resolve(downFileResp);
        }
    }

}
