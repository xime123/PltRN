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
 * 设备注册
 **/

public interface AMD_PltDeviceService_register extends Ice.AMDCallback
{
    /**
     * ice_response indicates that
     * the operation completed successfully.
     * @param __ret (return value) deviceId 设备id
     **/
    void ice_response(String __ret);
}