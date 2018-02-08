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
 * Provides type-specific helper functions.
 **/
public final class PltMessageServicePrxHelper extends Ice.ObjectPrxHelperBase implements PltMessageServicePrx
{
    private static final String __push_name = "push";

    public void push(String msgType, String[] receivers, String mode, String label, String msgContent, String cd, String sender, String chainType)
        throws com.juzix.plt.slice.common.PltException
    {
        push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, null, false);
    }

    public void push(String msgType, String[] receivers, String mode, String label, String msgContent, String cd, String sender, String chainType, java.util.Map<String, String> __ctx)
        throws com.juzix.plt.slice.common.PltException
    {
        push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, __ctx, true);
    }

    private void push(String msgType, String[] receivers, String mode, String label, String msgContent, String cd, String sender, String chainType, java.util.Map<String, String> __ctx, boolean __explicitCtx)
        throws com.juzix.plt.slice.common.PltException
    {
        __checkTwowayOnly(__push_name);
        end_push(begin_push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, __ctx, __explicitCtx, true, null));
    }

    public Ice.AsyncResult begin_push(String msgType, String[] receivers, String mode, String label, String msgContent, String cd, String sender, String chainType)
    {
        return begin_push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, null, false, false, null);
    }

    public Ice.AsyncResult begin_push(String msgType, String[] receivers, String mode, String label, String msgContent, String cd, String sender, String chainType, java.util.Map<String, String> __ctx)
    {
        return begin_push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, __ctx, true, false, null);
    }

    public Ice.AsyncResult begin_push(String msgType, String[] receivers, String mode, String label, String msgContent, String cd, String sender, String chainType, Ice.Callback __cb)
    {
        return begin_push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_push(String msgType, String[] receivers, String mode, String label, String msgContent, String cd, String sender, String chainType, java.util.Map<String, String> __ctx, Ice.Callback __cb)
    {
        return begin_push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_push(String msgType, String[] receivers, String mode, String label, String msgContent, String cd, String sender, String chainType, Callback_PltMessageService_push __cb)
    {
        return begin_push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, null, false, false, __cb);
    }

    public Ice.AsyncResult begin_push(String msgType, String[] receivers, String mode, String label, String msgContent, String cd, String sender, String chainType, java.util.Map<String, String> __ctx, Callback_PltMessageService_push __cb)
    {
        return begin_push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, __ctx, true, false, __cb);
    }

    public Ice.AsyncResult begin_push(String msgType, 
                                      String[] receivers, 
                                      String mode, 
                                      String label, 
                                      String msgContent, 
                                      String cd, 
                                      String sender, 
                                      String chainType, 
                                      IceInternal.Functional_VoidCallback __responseCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, null, false, false, __responseCb, __userExceptionCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_push(String msgType, 
                                      String[] receivers, 
                                      String mode, 
                                      String label, 
                                      String msgContent, 
                                      String cd, 
                                      String sender, 
                                      String chainType, 
                                      IceInternal.Functional_VoidCallback __responseCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                      IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, null, false, false, __responseCb, __userExceptionCb, __exceptionCb, __sentCb);
    }

    public Ice.AsyncResult begin_push(String msgType, 
                                      String[] receivers, 
                                      String mode, 
                                      String label, 
                                      String msgContent, 
                                      String cd, 
                                      String sender, 
                                      String chainType, 
                                      java.util.Map<String, String> __ctx, 
                                      IceInternal.Functional_VoidCallback __responseCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb)
    {
        return begin_push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, __ctx, true, false, __responseCb, __userExceptionCb, __exceptionCb, null);
    }

    public Ice.AsyncResult begin_push(String msgType, 
                                      String[] receivers, 
                                      String mode, 
                                      String label, 
                                      String msgContent, 
                                      String cd, 
                                      String sender, 
                                      String chainType, 
                                      java.util.Map<String, String> __ctx, 
                                      IceInternal.Functional_VoidCallback __responseCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                      IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                      IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, __ctx, true, false, __responseCb, __userExceptionCb, __exceptionCb, __sentCb);
    }

    private Ice.AsyncResult begin_push(String msgType, 
                                       String[] receivers, 
                                       String mode, 
                                       String label, 
                                       String msgContent, 
                                       String cd, 
                                       String sender, 
                                       String chainType, 
                                       java.util.Map<String, String> __ctx, 
                                       boolean __explicitCtx, 
                                       boolean __synchronous, 
                                       IceInternal.Functional_VoidCallback __responseCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.UserException> __userExceptionCb, 
                                       IceInternal.Functional_GenericCallback1<Ice.Exception> __exceptionCb, 
                                       IceInternal.Functional_BoolCallback __sentCb)
    {
        return begin_push(msgType, receivers, mode, label, msgContent, cd, sender, chainType, __ctx, __explicitCtx, __synchronous, 
                          new IceInternal.Functional_TwowayCallbackVoidUE(__responseCb, __userExceptionCb, __exceptionCb, __sentCb)
                              {
                                  public final void __completed(Ice.AsyncResult __result)
                                  {
                                      PltMessageServicePrxHelper.__push_completed(this, __result);
                                  }
                              });
    }

    private Ice.AsyncResult begin_push(String msgType, 
                                       String[] receivers, 
                                       String mode, 
                                       String label, 
                                       String msgContent, 
                                       String cd, 
                                       String sender, 
                                       String chainType, 
                                       java.util.Map<String, String> __ctx, 
                                       boolean __explicitCtx, 
                                       boolean __synchronous, 
                                       IceInternal.CallbackBase __cb)
    {
        __checkAsyncTwowayOnly(__push_name);
        IceInternal.OutgoingAsync __result = getOutgoingAsync(__push_name, __cb);
        try
        {
            __result.prepare(__push_name, Ice.OperationMode.Normal, __ctx, __explicitCtx, __synchronous);
            IceInternal.BasicStream __os = __result.startWriteParams(Ice.FormatType.DefaultFormat);
            __os.writeString(msgType);
            com.juzix.plt.slice.common.StringListHelper.write(__os, receivers);
            __os.writeString(mode);
            __os.writeString(label);
            __os.writeString(msgContent);
            __os.writeString(cd);
            __os.writeString(sender);
            __os.writeString(chainType);
            __result.endWriteParams();
            __result.invoke();
        }
        catch(Ice.Exception __ex)
        {
            __result.abort(__ex);
        }
        return __result;
    }

    public void end_push(Ice.AsyncResult __iresult)
        throws com.juzix.plt.slice.common.PltException
    {
        IceInternal.OutgoingAsync __result = IceInternal.OutgoingAsync.check(__iresult, this, __push_name);
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

    static public void __push_completed(Ice.TwowayCallbackVoidUE __cb, Ice.AsyncResult __result)
    {
        com.juzix.plt.slice.message.PltMessageServicePrx __proxy = (com.juzix.plt.slice.message.PltMessageServicePrx)__result.getProxy();
        try
        {
            __proxy.end_push(__result);
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
    public static PltMessageServicePrx checkedCast(Ice.ObjectPrx __obj)
    {
        return checkedCastImpl(__obj, ice_staticId(), PltMessageServicePrx.class, PltMessageServicePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltMessageServicePrx checkedCast(Ice.ObjectPrx __obj, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __ctx, ice_staticId(), PltMessageServicePrx.class, PltMessageServicePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltMessageServicePrx checkedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return checkedCastImpl(__obj, __facet, ice_staticId(), PltMessageServicePrx.class, PltMessageServicePrxHelper.class);
    }

    /**
     * Contacts the remote server to verify that a facet of the object implements this type.
     * Raises a local exception if a communication error occurs.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @param __ctx The Context map to send with the invocation.
     * @return A proxy for this type, or null if the object does not support this type.
     **/
    public static PltMessageServicePrx checkedCast(Ice.ObjectPrx __obj, String __facet, java.util.Map<String, String> __ctx)
    {
        return checkedCastImpl(__obj, __facet, __ctx, ice_staticId(), PltMessageServicePrx.class, PltMessageServicePrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @return A proxy for this type.
     **/
    public static PltMessageServicePrx uncheckedCast(Ice.ObjectPrx __obj)
    {
        return uncheckedCastImpl(__obj, PltMessageServicePrx.class, PltMessageServicePrxHelper.class);
    }

    /**
     * Downcasts the given proxy to this type without contacting the remote server.
     * @param __obj The untyped proxy.
     * @param __facet The name of the desired facet.
     * @return A proxy for this type.
     **/
    public static PltMessageServicePrx uncheckedCast(Ice.ObjectPrx __obj, String __facet)
    {
        return uncheckedCastImpl(__obj, __facet, PltMessageServicePrx.class, PltMessageServicePrxHelper.class);
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::message::PltMessageService"
    };

    /**
     * Provides the Slice type ID of this type.
     * @return The Slice type ID.
     **/
    public static String ice_staticId()
    {
        return __ids[1];
    }

    public static void __write(IceInternal.BasicStream __os, PltMessageServicePrx v)
    {
        __os.writeProxy(v);
    }

    public static PltMessageServicePrx __read(IceInternal.BasicStream __is)
    {
        Ice.ObjectPrx proxy = __is.readProxy();
        if(proxy != null)
        {
            PltMessageServicePrxHelper result = new PltMessageServicePrxHelper();
            result.__copyFrom(proxy);
            return result;
        }
        return null;
    }

    public static final long serialVersionUID = 0L;
}
