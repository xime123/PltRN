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
// Generated from file `plt_exception_biz.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.juzix.plt.slice.proxy;

/**
 * Provides type-specific helper functions.
 **/
public final class PltBizUserServicePrxHelper extends Ice.ObjectPrxHelperBase implements PltBizUserServicePrx
{
    private static final String __loginForBiz_name = "loginForBiz";

    public PltLoginBizResp loginForBiz(String data)
        throws BizException
    {
        return loginForBiz(data, null, false);
    }

    public PltLoginBizResp loginForBiz(String data, java.util.Map<String, String> __ctx)
        throws BizException
    {
        return loginForBiz(data, __ctx, true);
    }

    private PltLoginBizResp loginForBiz(String data, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws BizException
    {
        __checkTwowayOnly(__loginForBiz_name);
        return end_loginForBiz(begin_loginForBiz(data, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_loginForBiz(String data)
    {
        return begin_loginForBiz(data, null, false, false, null);
    }

    public Ice.AsyncResult begin_loginForBiz(String data, java.util.Map<String, String> __ctx)
    {
        return begin_loginForBiz(data, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_loginForBiz(String data, Ice.Callback __cb)
    {
        return begin_loginForBiz(data, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_loginForBiz(String data, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_loginForBiz(data, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_loginForBiz(String data, Callback_PltBizUserService_loginForBiz __cb)
    {
        return begin_loginForBiz(data, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_loginForBiz(String data, java.util.Map<String, String> __ctx, Callback_PltBizUserService_loginForBiz __cb)
    {
        return begin_loginForBiz(data, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_loginForBiz(String data, 
                                             IceInternal.Functional_GenericCallback1<PltLoginBizResp> __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_loginForBiz(data, null, false, false, __responseCb, __userExceptionCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_loginForBiz(String data, 
                                             IceInternal.Functional_GenericCallback1<PltLoginBizResp> __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_loginForBiz(data, null, false, false, __responseCb, __userExceptionCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_loginForBiz(String data, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_GenericCallback1<PltLoginBizResp> __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_loginForBiz(data, __ctx, true, false, __responseCb, __userExceptionCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_loginForBiz(String data, 
                                             java.util.Map<String, String> __ctx, 
                                             IceInternal.Functional_GenericCallback1<PltLoginBizResp> __responseCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                             IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                             IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_loginForBiz(data, __ctx, true, false, __responseCb, __userExceptionCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_loginForBiz(String data, 
                                              java.util.Map<String, String> __ctx, 
                                              boolean __explicitCtx, 
                                              boolean __synchronous, 
                                              IceInternal.Functional_GenericCallback1<PltLoginBizResp> __responseCb, 
                                              IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                              IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                              IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_loginForBiz(data, __ctx, __explicitCtx, __synchronous, 
                                 new IceInternal.Functional_TwowayCallbackArg1UE<com.juzix.plt.slice.proxy.PltLoginBizResp>(__responseCb, __userExceptionCb, __exceptionCb, __sentCb)
                                     {
                                         public final void __completed(Ice.AsyncResult __result)
                                         {
                                             PltBizUserServicePrxHelper.__loginForBiz_completed(this, __result);
                                         }
                                     });
    }

    private Ice.AsyncResult begin_loginForBiz(String data, 
                                              java.util.Map<String, String> __ctx, 
                                              boolean __explicitCtx, 
                                              boolean __synchronous, 
                                              IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__loginForBiz_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__loginForBiz_name, __cb);
        try
        {
            __result.prepare(__loginForBiz_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeString(data);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public PltLoginBizResp end_loginForBiz(Ice.AsyncResult __iresult)
        throws BizException
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __loginForBiz_name);
        try
        {
            if(!__result.__wait())
            {
                try
                {
                    __result.throwUserException();
                }
                catch(BizException __ex)
                {
                    throw __ex;
                }
                catch(Ice.UserException __ex)
                {
                    throw new Ice.UnknownUserException(__ex.ice_name(), __ex);
                }
            }
            IceInternal.BasicStream __is = __result.startReadParams();
            PltLoginBizResp __ret = null;
            __ret = PltLoginBizResp.__read(__is, __ret);
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

    static public void __loginForBiz_completed(Ice.TwowayCallbackArg1UE<PltLoginBizResp> __cb, Ice.AsyncResult __result)
    {
        com.juzix.plt.slice.proxy.PltBizUserServicePrx __proxy = (com.juzix.plt.slice.proxy.PltBizUserServicePrx)__result.getProxy();
        PltLoginBizResp __ret = null;
        try
        {
            __ret = __proxy.end_loginForBiz(__result);
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
    public static PltBizUserServicePrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), PltBizUserServicePrx.class, PltBizUserServicePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltBizUserServicePrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), PltBizUserServicePrx.class, PltBizUserServicePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltBizUserServicePrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), PltBizUserServicePrx.class, PltBizUserServicePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltBizUserServicePrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), PltBizUserServicePrx.class, PltBizUserServicePrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @return A proxy for this type.
     **/
    public static PltBizUserServicePrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, PltBizUserServicePrx.class, PltBizUserServicePrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    public static PltBizUserServicePrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, PltBizUserServicePrx.class, PltBizUserServicePrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::proxy::PltBizUserService"
    };

    /**
     * Provides the Slice type ID of this type.
     * @return The Slice type ID.
     **/
    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, PltBizUserServicePrx v)
    {
        __os.writeProxy(v);
    }

    public static PltBizUserServicePrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            PltBizUserServicePrxHelper result = new PltBizUserServicePrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}