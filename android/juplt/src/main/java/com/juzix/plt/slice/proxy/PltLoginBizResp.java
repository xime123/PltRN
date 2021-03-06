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
 * 登陆业务系统响应
 **/
public class PltLoginBizResp implements java.lang.Cloneable, java.io.Serializable
{
    /**
     * 后端业务层返回的数据
     **/
    public String data;

    /**
     * 后端业务层返回的数据
     **/
    public String
    getData()
    {
        return data;
    }

    /**
     * 后端业务层返回的数据
     **/
    public void
    setData(String _data)
    {
        data = _data;
    }

    /**
     * 用户id
     **/
    public String userId;

    /**
     * 用户id
     **/
    public String
    getUserId()
    {
        return userId;
    }

    /**
     * 用户id
     **/
    public void
    setUserId(String _userId)
    {
        userId = _userId;
    }

    public PltLoginBizResp()
    {
        data = "";
        userId = "";
    }

    public PltLoginBizResp(String data, String userId)
    {
        this.data = data;
        this.userId = userId;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        PltLoginBizResp _r = null;
        if(rhs instanceof PltLoginBizResp)
        {
            _r = (PltLoginBizResp)rhs;
        }

        if(_r != null)
        {
            if(data != _r.data)
            {
                if(data == null || _r.data == null || !data.equals(_r.data))
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
        __h = IceInternal.HashUtil.hashAdd(__h, "::proxy::PltLoginBizResp");
        __h = IceInternal.HashUtil.hashAdd(__h, data);
        __h = IceInternal.HashUtil.hashAdd(__h, userId);
        return __h;
    }

    public PltLoginBizResp
    clone()
    {
        PltLoginBizResp c = null;
        try
        {
            c = (PltLoginBizResp)super.clone();
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
        __os.writeString(data);
        __os.writeString(userId);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        data = __is.readString();
        userId = __is.readString();
    }

    static public void
    __write(IceInternal.BasicStream __os, PltLoginBizResp __v)
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

    static public PltLoginBizResp
    __read(IceInternal.BasicStream __is, PltLoginBizResp __v)
    {
        if(__v == null)
        {
             __v = new PltLoginBizResp();
        }
        __v.__read(__is);
        return __v;
    }
    
    private static final PltLoginBizResp __nullMarshalValue = new PltLoginBizResp();

    public static final long serialVersionUID = -761777851L;
}
