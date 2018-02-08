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
// Generated from file `plt_proxy_service.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.juzix.plt.slice.proxy;

/**
 * 代理响应参数
 **/
public class PltInvokeResp implements java.lang.Cloneable, java.io.Serializable
{
    /**
     * 业务代码
     **/
    public String cd;

    /**
     * 业务代码
     **/
    public String
    getCd()
    {
        return cd;
    }

    /**
     * 业务代码
     **/
    public void
    setCd(String _cd)
    {
        cd = _cd;
    }

    /**
     * 错误码
     **/
    public int errorCode;

    /**
     * 错误码
     **/
    public int
    getErrorCode()
    {
        return errorCode;
    }

    /**
     * 错误码
     **/
    public void
    setErrorCode(int _errorCode)
    {
        errorCode = _errorCode;
    }

    /**
     * 错误信息
     **/
    public String errorMsg;

    /**
     * 错误信息
     **/
    public String
    getErrorMsg()
    {
        return errorMsg;
    }

    /**
     * 错误信息
     **/
    public void
    setErrorMsg(String _errorMsg)
    {
        errorMsg = _errorMsg;
    }

    /**
     * 业务请求参数
     **/
    public String data;

    /**
     * 业务请求参数
     **/
    public String
    getData()
    {
        return data;
    }

    /**
     * 业务请求参数
     **/
    public void
    setData(String _data)
    {
        data = _data;
    }

    public PltInvokeResp()
    {
        cd = "";
        errorMsg = "";
        data = "";
    }

    public PltInvokeResp(String cd, int errorCode, String errorMsg, String data)
    {
        this.cd = cd;
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        PltInvokeResp _r = null;
        if(rhs instanceof PltInvokeResp)
        {
            _r = (PltInvokeResp)rhs;
        }

        if(_r != null)
        {
            if(cd != _r.cd)
            {
                if(cd == null || _r.cd == null || !cd.equals(_r.cd))
                {
                    return false;
                }
            }
            if(errorCode != _r.errorCode)
            {
                return false;
            }
            if(errorMsg != _r.errorMsg)
            {
                if(errorMsg == null || _r.errorMsg == null || !errorMsg.equals(_r.errorMsg))
                {
                    return false;
                }
            }
            if(data != _r.data)
            {
                if(data == null || _r.data == null || !data.equals(_r.data))
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
        __h = IceInternal.HashUtil.hashAdd(__h, "::proxy::PltInvokeResp");
        __h = IceInternal.HashUtil.hashAdd(__h, cd);
        __h = IceInternal.HashUtil.hashAdd(__h, errorCode);
        __h = IceInternal.HashUtil.hashAdd(__h, errorMsg);
        __h = IceInternal.HashUtil.hashAdd(__h, data);
        return __h;
    }

    public PltInvokeResp
    clone()
    {
        PltInvokeResp c = null;
        try
        {
            c = (PltInvokeResp)super.clone();
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
        __os.writeString(cd);
        __os.writeInt(errorCode);
        __os.writeString(errorMsg);
        __os.writeString(data);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        cd = __is.readString();
        errorCode = __is.readInt();
        errorMsg = __is.readString();
        data = __is.readString();
    }

    static public void
    __write(IceInternal.BasicStream __os, PltInvokeResp __v)
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

    static public PltInvokeResp
    __read(IceInternal.BasicStream __is, PltInvokeResp __v)
    {
        if(__v == null)
        {
             __v = new PltInvokeResp();
        }
        __v.__read(__is);
        return __v;
    }
    
    private static final PltInvokeResp __nullMarshalValue = new PltInvokeResp();

    public static final long serialVersionUID = 247292872L;
}
