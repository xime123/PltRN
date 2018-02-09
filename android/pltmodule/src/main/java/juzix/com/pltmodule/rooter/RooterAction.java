package juzix.com.pltmodule.rooter;

/**
 * Created by xumin on 2018/2/9.
 */

public class RooterAction {
    /**
     * 模块名称  如果是RN界面 moduleName就是对应的模块名称
     *           如果是原生页面传空
     */
    public String moduleName;


    public String targetComponent;

    public String orginComponent;

    /**
     * 路由类型 1,跳转到原生, 2 ，跳转到RN
     */
    public int rooterType;

    /**
     * 参数
     */
    public String props;
}
