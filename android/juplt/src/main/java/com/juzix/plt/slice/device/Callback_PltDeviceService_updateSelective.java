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
// Generated from file `plt_device_service.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.juzix.plt.slice.device;

/**
 * 更新设备会话信息，当属性存在时采用增量更新(客户端)
 **/

public abstract class Callback_PltDeviceService_updateSelective
    extends IceInternal.TwowayCallback implements Ice.TwowayCallbackVoidUE
{
    public final void __completed(Ice.AsyncResult __result)
    {
        PltDeviceServicePrxHelper.__updateSelective_completed(this, __result);
    }
}