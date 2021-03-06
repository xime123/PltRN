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
// Generated from file `plt_proxy_service.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.juzix.plt.slice.proxy;

/**
 * Provides type-specific helper functions.
 **/
public final class PltProxyServicePrxHelper extends Ice.ObjectPrxHelperBase implements PltProxyServicePrx
{
    private static final String __invoke_name = "invoke";

    public PltInvokeResp invoke(PltInvokeReq req)
        throws com.juzix.plt.slice.common.PltException
    {
        return invoke(req, null, false);
    }

    public PltInvokeResp invoke(PltInvokeReq req, java.util.Map<String, String> __ctx)
        throws com.juzix.plt.slice.common.PltException
    {
        return invoke(req, __ctx, true);
    }

    private PltInvokeResp invoke(PltInvokeReq req, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws com.juzix.plt.slice.common.PltException
    {
        __checkTwowayOnly(__invoke_name);
        return end_invoke(begin_invoke(req, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_invoke(PltInvokeReq req)
    {
        return begin_invoke(req, null, false, false, null);
    }

    public Ice.AsyncResult begin_invoke(PltInvokeReq req, java.util.Map<String, String> __ctx)
    {
        return begin_invoke(req, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_invoke(PltInvokeReq req, Ice.Callback __cb)
    {
        return begin_invoke(req, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_invoke(PltInvokeReq req, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_invoke(req, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_invoke(PltInvokeReq req, Callback_PltProxyService_invoke __cb)
    {
        return begin_invoke(req, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_invoke(PltInvokeReq req, java.util.Map<String, String> __ctx, Callback_PltProxyService_invoke __cb)
    {
        return begin_invoke(req, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_invoke(PltInvokeReq req, 
                                        IceInternal.Functional_GenericCallback1<PltInvokeResp> __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_invoke(req, null, false, false, __responseCb, __userExceptionCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_invoke(PltInvokeReq req, 
                                        IceInternal.Functional_GenericCallback1<PltInvokeResp> __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                        IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_invoke(req, null, false, false, __responseCb, __userExceptionCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_invoke(PltInvokeReq req, 
                                        java.util.Map<String, String> __ctx, 
                                        IceInternal.Functional_GenericCallback1<PltInvokeResp> __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_invoke(req, __ctx, true, false, __responseCb, __userExceptionCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_invoke(PltInvokeReq req, 
                                        java.util.Map<String, String> __ctx, 
                                        IceInternal.Functional_GenericCallback1<PltInvokeResp> __responseCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                        IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                        IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_invoke(req, __ctx, true, false, __responseCb, __userExceptionCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_invoke(PltInvokeReq req, 
                                         java.util.Map<String, String> __ctx, 
                                         boolean __explicitCtx, 
                                         boolean __synchronous, 
                                         IceInternal.Functional_GenericCallback1<PltInvokeResp> __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                         IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_invoke(req, __ctx, __explicitCtx, __synchronous, 
                            new IceInternal.Functional_TwowayCallbackArg1UE<com.juzix.plt.slice.proxy.PltInvokeResp>(__responseCb, __userExceptionCb, __exceptionCb, __sentCb)
                                {
                                    public final void __completed(Ice.AsyncResult __result)
                                    {
                                        PltProxyServicePrxHelper.__invoke_completed(this, __result);
                                    }
                                });
    }

    private Ice.AsyncResult begin_invoke(PltInvokeReq req, 
                                         java.util.Map<String, String> __ctx, 
                                         boolean __explicitCtx, 
                                         boolean __synchronous, 
                                         IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__invoke_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__invoke_name, __cb);
        try
        {
            __result.prepare(__invoke_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            PltInvokeReq.__write(__os, req);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public PltInvokeResp end_invoke(Ice.AsyncResult __iresult)
        throws com.juzix.plt.slice.common.PltException
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __invoke_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(com.juzix.plt.slice.common.PltException __ex)
                {
                    throw __ex;
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            PltInvokeResp __ret = null;
            __ret = PltInvokeResp.__read(__is, __ret);
            __result.endReadParams();
            return __ret;
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __invoke_completed(Ice.TwowayCallbackArg1UE<PltInvokeResp> __cb, Ice.AsyncResult __result)
    {
        com.juzix.plt.slice.proxy.PltProxyServicePrx __proxy = (com.juzix.plt.slice.proxy.PltProxyServicePrx)__result.getProxy();
        PltInvokeResp __ret = null;
        try
        {
            __ret = __proxy.end_invoke(__result);
        }
        catch(Ice.UserException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.LocalException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        catch(Ice.SystemException __ex)
        {
            __cb.exception(__ex);
            return;
        }
        __cb.response(__ret);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltProxyServicePrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), PltProxyServicePrx.class, PltProxyServicePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltProxyServicePrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), PltProxyServicePrx.class, PltProxyServicePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltProxyServicePrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), PltProxyServicePrx.class, PltProxyServicePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltProxyServicePrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), PltProxyServicePrx.class, PltProxyServicePrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @return A proxy for this type.
     **/
    public static PltProxyServicePrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, PltProxyServicePrx.class, PltProxyServicePrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    public static PltProxyServicePrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, PltProxyServicePrx.class, PltProxyServicePrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::proxy::PltProxyService"
    };

    /**
     * Provides the Slice type ID of this type.
     * @return The Slice type ID.
     **/
    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, PltProxyServicePrx v)
    {
        __os.writeProxy(v);
    }

    public static PltProxyServicePrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            PltProxyServicePrxHelper result = new PltProxyServicePrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
