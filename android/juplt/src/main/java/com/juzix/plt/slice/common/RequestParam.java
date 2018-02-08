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
// Generated from file `plt_common.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.juzix.plt.slice.common;

public enum RequestParam implements java.io.Serializable
{
    
    osType(0),
    
    apns(1),
    
    deviceId(2),
    
    fields(3);

    public int
    value()
    {
        return __value;
    }

    public static RequestParam
    valueOf(int __v)
    {
        switch(__v)
        {
        case 0:
            return osType;
        case 1:
            return apns;
        case 2:
            return deviceId;
        case 3:
            return fields;
        }
        return null;
    }

    private
    RequestParam(int __v)
    {
        __value = __v;
    }

    public void
    __write(IceInternal.BasicStream __os)
    {
        __os.writeEnum(value(), 3);
    }

    public static void
    __write(IceInternal.BasicStream __os, RequestParam __v)
    {
        if(__v == null)
        {
            __os.writeEnum(com.juzix.plt.slice.common.RequestParam.osType.value(), 3);
        }
        else
        {
            __os.writeEnum(__v.value(), 3);
        }
    }

    public static RequestParam
    __read(IceInternal.BasicStream __is)
    {
        int __v = __is.readEnum(3);
        return __validate(__v);
    }

    private static RequestParam
    __validate(int __v)
    {
        final RequestParam __e = valueOf(__v);
        if(__e == null)
        {
            throw new Ice.MarshalException("enumerator value " + __v + " is out of range");
        }
        return __e;
    }

    private final int __value;
}