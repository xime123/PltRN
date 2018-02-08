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
public interface PltMsgCallbackPrx extends Ice.ObjectPrx
{
    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param msgType 消息类型。 D:设备消息。U:用户消息
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param label 消息标题
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     **/
    public void push(String cd, String msgType, String mode, String label, String msgContent)
        throws com.juzix.plt.slice.common.PltException;

    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param msgType 消息类型。 D:设备消息。U:用户消息
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param label 消息标题
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     * @param __ctx The Context map to send with the invocation.
     **/
    public void push(String cd, String msgType, String mode, String label, String msgContent, java.util.Map<String, String> __ctx)
        throws com.juzix.plt.slice.common.PltException;

    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_push(String cd, String msgType, String mode, String label, String msgContent);

    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     * @param __ctx The Context map to send with the invocation.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_push(String cd, String msgType, String mode, String label, String msgContent, java.util.Map<String, String> __ctx);

    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_push(String cd, String msgType, String mode, String label, String msgContent, Ice.Callback __cb);

    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_push(String cd, String msgType, String mode, String label, String msgContent, java.util.Map<String, String> __ctx, Ice.Callback __cb);

    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_push(String cd, String msgType, String mode, String label, String msgContent, Callback_PltMsgCallback_push __cb);

    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     * @param __ctx The Context map to send with the invocation.
     * @param __cb The asynchronous callback object.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_push(String cd, String msgType, String mode, String label, String msgContent, java.util.Map<String, String> __ctx, Callback_PltMsgCallback_push __cb);

    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_push(String cd, 
                                      String msgType, 
                                      String mode, 
                                      String label, 
                                      String msgContent, 
                                      IceInternal.Functional_VoidCallback __responseCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @param __sentCb The lambda sent callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_push(String cd, 
                                      String msgType, 
                                      String mode, 
                                      String label, 
                                      String msgContent, 
                                      IceInternal.Functional_VoidCallback __responseCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                      IceInternal.Functional_BoolCallback __sentCb);

    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     * @param __ctx The Context map to send with the invocation.
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_push(String cd, 
                                      String msgType, 
                                      String mode, 
                                      String label, 
                                      String msgContent, 
                                      java.util.Map<String, String> __ctx, 
                                      IceInternal.Functional_VoidCallback __responseCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb);

    /**
     * 消息回调(客户端)
     * @param cd 业务代码
     * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
     * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
     * @param __ctx The Context map to send with the invocation.
     * @param __responseCb The lambda response callback.
     * @param __userExceptionCb The lambda user exception callback.
     * @param __exceptionCb The lambda exception callback.
     * @param __sentCb The lambda sent callback.
     * @return The asynchronous result object.
     **/
    public Ice.AsyncResult begin_push(String cd, 
                                      String msgType, 
                                      String mode, 
                                      String label, 
                                      String msgContent, 
                                      java.util.Map<String, String> __ctx, 
                                      IceInternal.Functional_VoidCallback __responseCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                      IceInternal.Functional_BoolCallback __sentCb);

    /**
     * 消息回调(客户端)
     * @param __result The asynchronous result object.
     **/
    public void end_push(Ice.AsyncResult __result)
        throws com.juzix.plt.slice.common.PltException;
}