package com.juzix.plt.service.callback;

import com.juzix.plt.slice.common.PltException;
import com.juzix.plt.slice.session._PltMsgCallbackDisp;

import Ice.Current;


public class MsgCallback extends _PltMsgCallbackDisp {
    private final String TAG = "MsgCallback";

    private static final long serialVersionUID = 1L;
    private OnMsgCallback mOnMsgCallback;

    public MsgCallback(OnMsgCallback onCallback){
        mOnMsgCallback = onCallback;
    }

    /**
     * 消息回调
     *
     * @param cd         业务代码
     * @param msgType    消息类型。 D:设备消息。U:用户消息
     * @param mode       消息模式。1：消息即入库、又通知。2：仅通知
     * @param label      消息标题
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     **/
    @Override
    public void push(String cd, String msgType, String mode, String label, String msgContent, Current __current) throws PltException {
        if (mOnMsgCallback != null){
            mOnMsgCallback.push(cd, msgType, mode, label, msgContent);
        }
    }

    public interface OnMsgCallback {
        void push(String cd, String msgType, String mode, String label, String msgContent);
    }
}
