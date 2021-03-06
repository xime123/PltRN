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
// Generated from file `plt_message_service.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.juzix.plt.slice.message;

/**
 * 消息服务
 **/
public interface _PltMessageServiceOperationsNC
{
    /**
     * 推送消息
     * @param __cb The callback object for the operation.
     **/
    void push_async(AMD_PltMessageService_push __cb, String msgType, String[] receivers, String mode, String label, String msgContent, String cd, String sender, String chainType)
        throws com.juzix.plt.slice.common.PltException;
}
