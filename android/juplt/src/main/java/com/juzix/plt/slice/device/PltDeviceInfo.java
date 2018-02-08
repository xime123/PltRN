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
 * 设备会话信息
 **/
public class PltDeviceInfo implements java.lang.Cloneable, java.io.Serializable
{
    /**
     * deviceId 设备Id
     **/
    public String deviceId;

    /**
     * deviceId 设备Id
     **/
    public String
    getDeviceId()
    {
        return deviceId;
    }

    /**
     * deviceId 设备Id
     **/
    public void
    setDeviceId(String _deviceId)
    {
        deviceId = _deviceId;
    }

    /**
     * apns token
     **/
    public String apns;

    /**
     * apns token
     **/
    public String
    getApns()
    {
        return apns;
    }

    /**
     * apns token
     **/
    public void
    setApns(String _apns)
    {
        apns = _apns;
    }

    /**
     * ice session 连接状态
     **/
    public String connectStatus;

    /**
     * ice session 连接状态
     **/
    public String
    getConnectStatus()
    {
        return connectStatus;
    }

    /**
     * ice session 连接状态
     **/
    public void
    setConnectStatus(String _connectStatus)
    {
        connectStatus = _connectStatus;
    }

    /**
     * 设备的唯一标示
     * 当android时：mac
     * 当ios时：uuid
     **/
    public String deviceIdentifier;

    /**
     * 设备的唯一标示
     * 当android时：mac
     * 当ios时：uuid
     **/
    public String
    getDeviceIdentifier()
    {
        return deviceIdentifier;
    }

    /**
     * 设备的唯一标示
     * 当android时：mac
     * 当ios时：uuid
     **/
    public void
    setDeviceIdentifier(String _deviceIdentifier)
    {
        deviceIdentifier = _deviceIdentifier;
    }

    /**
     * 设备类型  ISO|ANDROID
     **/
    public String osType;

    /**
     * 设备类型  ISO|ANDROID
     **/
    public String
    getOsType()
    {
        return osType;
    }

    /**
     * 设备类型  ISO|ANDROID
     **/
    public void
    setOsType(String _osType)
    {
        osType = _osType;
    }

    /**
     * ice callback proxy
     **/
    public String callbackProxy;

    /**
     * ice callback proxy
     **/
    public String
    getCallbackProxy()
    {
        return callbackProxy;
    }

    /**
     * ice callback proxy
     **/
    public void
    setCallbackProxy(String _callbackProxy)
    {
        callbackProxy = _callbackProxy;
    }

    /**
     * 设备关联的用户
     **/
    public String userId;

    /**
     * 设备关联的用户
     **/
    public String
    getUserId()
    {
        return userId;
    }

    /**
     * 设备关联的用户
     **/
    public void
    setUserId(String _userId)
    {
        userId = _userId;
    }

    public PltDeviceInfo()
    {
        deviceId = "";
        apns = "";
        connectStatus = "";
        deviceIdentifier = "";
        osType = "";
        callbackProxy = "";
        userId = "";
    }

    public PltDeviceInfo(String deviceId, String apns, String connectStatus, String deviceIdentifier, String osType, String callbackProxy, String userId)
    {
        this.deviceId = deviceId;
        this.apns = apns;
        this.connectStatus = connectStatus;
        this.deviceIdentifier = deviceIdentifier;
        this.osType = osType;
        this.callbackProxy = callbackProxy;
        this.userId = userId;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        PltDeviceInfo _r = null;
        if(rhs instanceof PltDeviceInfo)
        {
            _r = (PltDeviceInfo)rhs;
        }

        if(_r != null)
        {
            if(deviceId != _r.deviceId)
            {
                if(deviceId == null || _r.deviceId == null || !deviceId.equals(_r.deviceId))
                {
                    return false;
                }
            }
            if(apns != _r.apns)
            {
                if(apns == null || _r.apns == null || !apns.equals(_r.apns))
                {
                    return false;
                }
            }
            if(connectStatus != _r.connectStatus)
            {
                if(connectStatus == null || _r.connectStatus == null || !connectStatus.equals(_r.connectStatus))
                {
                    return false;
                }
            }
            if(deviceIdentifier != _r.deviceIdentifier)
            {
                if(deviceIdentifier == null || _r.deviceIdentifier == null || !deviceIdentifier.equals(_r.deviceIdentifier))
                {
                    return false;
                }
            }
            if(osType != _r.osType)
            {
                if(osType == null || _r.osType == null || !osType.equals(_r.osType))
                {
                    return false;
                }
            }
            if(callbackProxy != _r.callbackProxy)
            {
                if(callbackProxy == null || _r.callbackProxy == null || !callbackProxy.equals(_r.callbackProxy))
                {
                    return false;
                }
            }
            if(userId != _r.userId)
            {
                if(userId == null || _r.userId == null || !userId.equals(_r.userId))
                {
                    return false;
                }
            }

            return true;
        }

        return false;
    }

    public int
    hashCode()
    {
        int __h = 5381;
        __h = IceInternal.HashUtil.hashAdd(__h, "::device::PltDeviceInfo");
        __h = IceInternal.HashUtil.hashAdd(__h, deviceId);
        __h = IceInternal.HashUtil.hashAdd(__h, apns);
        __h = IceInternal.HashUtil.hashAdd(__h, connectStatus);
        __h = IceInternal.HashUtil.hashAdd(__h, deviceIdentifier);
        __h = IceInternal.HashUtil.hashAdd(__h, osType);
        __h = IceInternal.HashUtil.hashAdd(__h, callbackProxy);
        __h = IceInternal.HashUtil.hashAdd(__h, userId);
        return __h;
    }

    public PltDeviceInfo
    clone()
    {
        PltDeviceInfo c = null;
        try
        {
            c = (PltDeviceInfo)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeString(deviceId);
        __os.writeString(apns);
        __os.writeString(connectStatus);
        __os.writeString(deviceIdentifier);
        __os.writeString(osType);
        __os.writeString(callbackProxy);
        __os.writeString(userId);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        deviceId = __is.readString();
        apns = __is.readString();
        connectStatus = __is.readString();
        deviceIdentifier = __is.readString();
        osType = __is.readString();
        callbackProxy = __is.readString();
        userId = __is.readString();
    }

    static public void
    __write(IceInternal.BasicStream __os, PltDeviceInfo __v)
    {
        if(__v == null)
        {
            __nullMarshalValue.__write(__os);
        }
        else
        {
            __v.__write(__os);
        }
    }

    static public PltDeviceInfo
    __read(IceInternal.BasicStream __is, PltDeviceInfo __v)
    {
        if(__v == null)
        {
             __v = new PltDeviceInfo();
        }
        __v.__read(__is);
        return __v;
    }
    
    private static final PltDeviceInfo __nullMarshalValue = new PltDeviceInfo();

    public static final long serialVersionUID = -1591493121L;
}
