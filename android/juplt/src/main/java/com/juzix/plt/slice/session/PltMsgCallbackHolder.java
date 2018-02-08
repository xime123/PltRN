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

public final class PltMsgCallbackHolder extends Ice.ObjectHolderBase<PltMsgCallback>
{
    public
    PltMsgCallbackHolder()
    {
    }

    public
    PltMsgCallbackHolder(PltMsgCallback value)
    {
        this.value = value;
    }

    public void
    patch(Ice.Object v)
    {
        if(v == null || v instanceof PltMsgCallback)
        {
            value = (PltMsgCallback)v;
        }
        else
        {
            IceInternal.Ex.throwUOE(type(), v);
        }
    }

    public String
    type()
    {
        return _PltMsgCallbackDisp.ice_staticId();
    }
}
