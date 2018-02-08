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
 * 会话服务
 **/
public interface _PltSessionOperations extends Glacier2._SessionOperations
{
    /**
     * 添加消息回调对象(客户端)
     * @param __cb The callback object for the operation.
     * @param deviceId 设备id
     * @param __current The Current object for the invocation.
     **/
    void addMsgCallback_async(AMD_PltSession_addMsgCallback __cb, String deviceId, PltMsgCallbackPrx proxy, Ice.Current __current)
        throws com.juzix.plt.slice.common.PltException;
}
