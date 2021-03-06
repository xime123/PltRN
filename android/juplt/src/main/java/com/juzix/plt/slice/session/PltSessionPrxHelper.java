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
 * Provides type-specific helper functions.
 **/
public final class PltSessionPrxHelper extends Ice.ObjectPrxHelperBase implements PltSessionPrx
{
    private static final String __destroy_name = "destroyConnect";

    public void destroy()
    {
        destroy(null, false);
    }

    public void destroy(java.util.Map<String, String> __ctx)
    {
        destroy(__ctx, true);
    }

    private void destroy(java.util.Map<String, String> __ctx, boolean __explicitCtx)
    {
        end_destroy(begin_destroy(__ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_destroy()
    {
        return begin_destroy(null, false, false, null);
    }

    public Ice.AsyncResult begin_destroy(java.util.Map<String, String> __ctx)
    {
        return begin_destroy(__ctx, true, false, null);
    }

    public Ice.AsyncResult begin_destroy(Ice.Callback __cb)
    {
        return begin_destroy(null, false, false, __cb);
    }

    public Ice.AsyncResult begin_destroy(java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_destroy(__ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_destroy(Glacier2.Callback_Session_destroy __cb)
    {
        return begin_destroy(null, false, false, __cb);
    }

    public Ice.AsyncResult begin_destroy(java.util.Map<String, String> __ctx, Glacier2.Callback_Session_destroy __cb)
    {
        return begin_destroy(__ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_destroy(IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_destroy(null, false, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_destroy(IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                         IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_destroy(null, false, false, __responseCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_destroy(java.util.Map<String, String> __ctx, 
                                         IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_destroy(__ctx, true, false, __responseCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_destroy(java.util.Map<String, String> __ctx, 
                                         IceInternal.Functional_VoidCallback __responseCb, 
                                         IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                         IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_destroy(__ctx, true, false, __responseCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_destroy(java.util.Map<String, String> __ctx, 
                                          boolean __explicitCtx, 
                                          boolean __synchronous, 
                                          IceInternal.Functional_VoidCallback __responseCb, 
                                          IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                          IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_destroy(__ctx, 
                             __explicitCtx, 
                             __synchronous, 
                             new IceInternal.Functional_OnewayCallback(__responseCb, __exceptionCb, __sentCb));
    }

    private Ice.AsyncResult begin_destroy(java.util.Map<String, String> __ctx, 
                                          boolean __explicitCtx, 
                                          boolean __synchronous, 
                                          IceInternal.CallbackBase __cb)
    {
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__destroy_name, __cb);
        try
        {
            __result.prepare(__destroy_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            __result.writeEmptyParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public void end_destroy(Ice.AsyncResult __iresult)
    {
        __end(__iresult, __destroy_name);
    }

    private static final String __addMsgCallback_name = "addMsgCallback";

    public void addMsgCallback(String deviceId, PltMsgCallbackPrx proxy)
        throws com.juzix.plt.slice.common.PltException
    {
        addMsgCallback(deviceId, proxy, null, false);
    }

    public void addMsgCallback(String deviceId, PltMsgCallbackPrx proxy, java.util.Map<String, String> __ctx)
        throws com.juzix.plt.slice.common.PltException
    {
        addMsgCallback(deviceId, proxy, __ctx, true);
    }

    private void addMsgCallback(String deviceId, PltMsgCallbackPrx proxy, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws com.juzix.plt.slice.common.PltException
    {
        __checkTwowayOnly(__addMsgCallback_name);
        end_addMsgCallback(begin_addMsgCallback(deviceId, proxy, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_addMsgCallback(String deviceId, PltMsgCallbackPrx proxy)
    {
        return begin_addMsgCallback(deviceId, proxy, null, false, false, null);
    }

    public Ice.AsyncResult begin_addMsgCallback(String deviceId, PltMsgCallbackPrx proxy, java.util.Map<String, String> __ctx)
    {
        return begin_addMsgCallback(deviceId, proxy, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_addMsgCallback(String deviceId, PltMsgCallbackPrx proxy, Ice.Callback __cb)
    {
        return begin_addMsgCallback(deviceId, proxy, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_addMsgCallback(String deviceId, PltMsgCallbackPrx proxy, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_addMsgCallback(deviceId, proxy, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_addMsgCallback(String deviceId, PltMsgCallbackPrx proxy, Callback_PltSession_addMsgCallback __cb)
    {
        return begin_addMsgCallback(deviceId, proxy, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_addMsgCallback(String deviceId, PltMsgCallbackPrx proxy, java.util.Map<String, String> __ctx, Callback_PltSession_addMsgCallback __cb)
    {
        return begin_addMsgCallback(deviceId, proxy, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_addMsgCallback(String deviceId, 
                                                PltMsgCallbackPrx proxy, 
                                                IceInternal.Functional_VoidCallback __responseCb, 
                                                IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_addMsgCallback(deviceId, proxy, null, false, false, __responseCb, __userExceptionCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_addMsgCallback(String deviceId, 
                                                PltMsgCallbackPrx proxy, 
                                                IceInternal.Functional_VoidCallback __responseCb, 
                                                IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_addMsgCallback(deviceId, proxy, null, false, false, __responseCb, __userExceptionCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_addMsgCallback(String deviceId, 
                                                PltMsgCallbackPrx proxy, 
                                                java.util.Map<String, String> __ctx, 
                                                IceInternal.Functional_VoidCallback __responseCb, 
                                                IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_addMsgCallback(deviceId, proxy, __ctx, true, false, __responseCb, __userExceptionCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_addMsgCallback(String deviceId, 
                                                PltMsgCallbackPrx proxy, 
                                                java.util.Map<String, String> __ctx, 
                                                IceInternal.Functional_VoidCallback __responseCb, 
                                                IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_addMsgCallback(deviceId, proxy, __ctx, true, false, __responseCb, __userExceptionCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_addMsgCallback(String deviceId, 
                                                 PltMsgCallbackPrx proxy, 
                                                 java.util.Map<String, String> __ctx, 
                                                 boolean __explicitCtx, 
                                                 boolean __synchronous, 
                                                 IceInternal.Functional_VoidCallback __responseCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                                 IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                                 IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_addMsgCallback(deviceId, proxy, __ctx, __explicitCtx, __synchronous, 
                                    new IceInternal.Functional_TwowayCallbackVoidUE(__responseCb, __userExceptionCb, __exceptionCb, __sentCb)
                                        {
                                            public final void __completed(Ice.AsyncResult __result)
                                            {
                                                PltSessionPrxHelper.__addMsgCallback_completed(this, __result);
                                            }
                                        });
    }

    private Ice.AsyncResult begin_addMsgCallback(String deviceId, 
                                                 PltMsgCallbackPrx proxy, 
                                                 java.util.Map<String, String> __ctx, 
                                                 boolean __explicitCtx, 
                                                 boolean __synchronous, 
                                                 IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__addMsgCallback_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__addMsgCallback_name, __cb);
        try
        {
            __result.prepare(__addMsgCallback_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeString(deviceId);
            PltMsgCallbackPrxHelper.__write(__os, proxy);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public void end_addMsgCallback(Ice.AsyncResult __iresult)
        throws com.juzix.plt.slice.common.PltException
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __addMsgCallback_name);
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
            __result.readEmptyParams();
        }
        finally
        {
            if(__result != null)
            {
                __result.cacheMessageBuffers();
            }
        }
    }

    static public void __addMsgCallback_completed(Ice.TwowayCallbackVoidUE __cb, Ice.AsyncResult __result)
    {
        com.juzix.plt.slice.session.PltSessionPrx __proxy = (com.juzix.plt.slice.session.PltSessionPrx)__result.getProxy();
        try
        {
            __proxy.end_addMsgCallback(__result);
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
        __cb.response();
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltSessionPrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), PltSessionPrx.class, PltSessionPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltSessionPrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), PltSessionPrx.class, PltSessionPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltSessionPrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), PltSessionPrx.class, PltSessionPrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltSessionPrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), PltSessionPrx.class, PltSessionPrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @return A proxy for this type.
     **/
    public static PltSessionPrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, PltSessionPrx.class, PltSessionPrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    public static PltSessionPrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, PltSessionPrx.class, PltSessionPrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Glacier2::Session",
        "::Ice::Object",
        "::session::PltSession"
    };

    /**
     * Provides the Slice type ID of this type.
     * @return The Slice type ID.
     **/
    public static String ice_staticId()
    {
        return __ids[2];
    }

    public static void __write(IceInternal.BasicStream __os, PltSessionPrx v)
    {
        __os.writeProxy(v);
    }

    public static PltSessionPrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            PltSessionPrxHelper result = new PltSessionPrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
