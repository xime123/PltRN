package com.juzix.plt.service.callback;


import com.juzix.plt.service.IServiceManager;
import com.juzix.plt.service.PltServiceManager;
import com.juzix.plt.service.model.PLTMessage;

import java.util.ArrayList;
import java.util.List;

public class MsgCallbackManager implements IServiceManager, MsgCallback.OnMsgCallback{

    private List<OnMessageReceive> messageReceives=new ArrayList<>();
    private MsgCallback mMsgCallback;
    private MsgCallbackManager() {

    }

    @Override
    public boolean checkNetwork() {
        return PltServiceManager.getInstance().getConnectionManager().checkNetWork();
    }

    @Override
    public boolean connected() {
        return PltServiceManager.getInstance().getConnectionManager().isConnected();
    }

    public static MsgCallbackManager getInstance() {
        return InstanceHolder.INSTANCE;
    }

    public void init() {
        mMsgCallback = new MsgCallback(this);
    }

    public MsgCallback getMsgCallback() {
        return mMsgCallback;
    }

    @Override
    public void push(String cd, String msgType, String mode, String label, String msgContent) {
        //处理接收到的push消息
        PLTMessage message=new PLTMessage(cd,msgType,mode,label,msgContent);
        notifyMessageObersvers(message);
    }

    /**
     * 新增消息观察者
     */
    public void addMessageObserver(OnMessageReceive messageReceive){
        messageReceives.add(messageReceive);
    }

    /**
     * 通知观察者来了新的消息
     * @param newMsg
     */
    private void notifyMessageObersvers(PLTMessage newMsg){
        if(messageReceives.size()==0)return;
        for(OnMessageReceive receive:messageReceives){
            receive.onReceive(newMsg);
        }
    }

    private static class InstanceHolder {
        private static volatile MsgCallbackManager INSTANCE = new MsgCallbackManager();
    }

    public interface OnMessageReceive{
        void onReceive(PLTMessage newMsg);
    }
}
