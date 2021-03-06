// **********************************************************************
//
// Copyright (c) 2003-2016 ZeroC, Inc. All rights reserved.
//
// This copy of Ice is licensed to you under the terms described in the
// ICE_LICENSE file included in this distribution.
//
// **********************************************************************
//
// Ice version 3.6.3
//
// <auto-generated>
//
// Generated from file `plt_glacier2_service.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.juzix.plt.slice.session;

/**
 * 客户端的消息回调对象
 **/
public interface _PltMsgCallbackOperationsNC
{
    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param msgType 消息类型。 D:设备消息。U:用户消息
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param label 消息标题
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     **/
    void push(String cd, String msgType, String mode, String label, String msgContent)
        throws com.juzix.plt.slice.common.PltException;
}
