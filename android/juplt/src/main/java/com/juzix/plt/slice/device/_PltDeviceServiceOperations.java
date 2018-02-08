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
 * 设备服务
 **/
public interface _PltDeviceServiceOperations
{
    /**
     * 设备注册
     * @param __cb The callback object for the operation.
     * @param osType 设备类型。  ISO|ANDROID
     * @param apns token
     * @param __current The Current object for the invocation.
     **/
    void register_async(AMD_PltDeviceService_register __cb, String osType, String deviceIdentifier, String apns, Ice.Current __current)
        throws com.juzix.plt.slice.common.PltException;

    /**
     * 更新设备会话信息，当属性存在时采用增量更新(客户端)
     * @param __cb The callback object for the operation.
     * @param deviceId 设备id
     * @param __current The Current object for the invocation.
     **/
    void updateSelective_async(AMD_PltDeviceService_updateSelective __cb, String deviceId, PltDeviceInfo deviceInfo, Ice.Current __current)
        throws com.juzix.plt.slice.common.PltException;

    /**
     * 增量删除设备会话信息
     * @param __cb The callback object for the operation.
     * @param deviceId 设备id
     * @param __current The Current object for the invocation.
     **/
    void deleteSelective_async(AMD_PltDeviceService_deleteSelective __cb, String deviceId, String[] fields, Ice.Current __current)
        throws com.juzix.plt.slice.common.PltException;

    /**
     * 查询设备会话信息
     * @param __cb The callback object for the operation.
     * @param deviceId 设备id
     * @param __current The Current object for the invocation.
     **/
    void queryDeviceInfo_async(AMD_PltDeviceService_queryDeviceInfo __cb, String deviceId, Ice.Current __current)
        throws com.juzix.plt.slice.common.PltException;

    /**
     * 批量查询设备会话信息
     * @param __cb The callback object for the operation.
     * @param deviceIds 设备id列表
     * @param __current The Current object for the invocation.
     **/
    void queryDeviceInfoBatch_async(AMD_PltDeviceService_queryDeviceInfoBatch __cb, String[] deviceIds, Ice.Current __current)
        throws com.juzix.plt.slice.common.PltException;
}
