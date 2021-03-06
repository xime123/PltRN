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
// Generated from file `plt_user_service.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package com.juzix.plt.slice.user;

/**
 * 登陆响应
 **/
public class PltLoginResp implements java.lang.Cloneable, java.io.Serializable
{
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
     * 用户登录令牌
     **/
    public String token;

    /**
     * 用户登录令牌
     **/
    public String
    getToken()
    {
        return token;
    }

    /**
     * 用户登录令牌
     **/
    public void
    setToken(String _token)
    {
        token = _token;
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

    public PltLoginResp()
    {
        errorMsg = "";
        data = "";
        token = "";
        userId = "";
    }

    public PltLoginResp(int errorCode, String errorMsg, String data, String token, String userId)
    {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.data = data;
        this.token = token;
        this.userId = userId;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        PltLoginResp _r = null;
        if(rhs instanceof PltLoginResp)
        {
            _r = (PltLoginResp)rhs;
        }

        if(_r != null)
        {
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
            if(token != _r.token)
            {
                if(token == null || _r.token == null || !token.equals(_r.token))
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
        __h = IceInternal.HashUtil.hashAdd(__h, "::user::PltLoginResp");
        __h = IceInternal.HashUtil.hashAdd(__h, errorCode);
        __h = IceInternal.HashUtil.hashAdd(__h, errorMsg);
        __h = IceInternal.HashUtil.hashAdd(__h, data);
        __h = IceInternal.HashUtil.hashAdd(__h, token);
        __h = IceInternal.HashUtil.hashAdd(__h, userId);
        return __h;
    }

    public PltLoginResp
    clone()
    {
        PltLoginResp c = null;
        try
        {
            c = (PltLoginResp)super.clone();
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
        __os.writeInt(errorCode);
        __os.writeString(errorMsg);
        __os.writeString(data);
        __os.writeString(token);
        __os.writeString(userId);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        errorCode = __is.readInt();
        errorMsg = __is.readString();
        data = __is.readString();
        token = __is.readString();
        userId = __is.readString();
    }

    static public void
    __write(IceInternal.BasicStream __os, PltLoginResp __v)
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

    static public PltLoginResp
    __read(IceInternal.BasicStream __is, PltLoginResp __v)
    {
        if(__v == null)
        {
             __v = new PltLoginResp();
        }
        __v.__read(__is);
        return __v;
    }
    
    private static final PltLoginResp __nullMarshalValue = new PltLoginResp();

    public static final long serialVersionUID = 444851521L;
}
