package juzix.com.pltmodule.rooter;

/**
 * Created by xumin on 2018/2/9.
 */

public interface RNNativeRooterInterface {
    /**
     * 打开原生的界面或者RN界面
     * @param rooterActionJson RooterAction的JSON数据格式
     */
    void pushComponent(String rooterActionJson);


    /**
     * 返回上一个界面
     * @param rooterActionJson RooterAction的JSON数据格式
     */
    void popComponent(RooterAction rooterActionJson);


    /**
     * 退回到root页面
     * @param rooterActionJson RooterAction的JSON数据格式
     */
    void popToRootComponent(RooterAction rooterActionJson);
}
