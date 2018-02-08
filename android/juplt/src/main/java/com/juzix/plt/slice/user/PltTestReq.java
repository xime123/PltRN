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
 * 测试请求实体
 **/
public class PltTestReq implements java.lang.Cloneable, java.io.Serializable
{
    public String name;

    public String
    getName()
    {
        return name;
    }

    public void
    setName(String _name)
    {
        name = _name;
    }

    public PltTestReq()
    {
        name = "";
    }

    public PltTestReq(String name)
    {
        this.name = name;
    }

    public boolean
    equals(java.lang.Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        PltTestReq _r = null;
        if(rhs instanceof PltTestReq)
        {
            _r = (PltTestReq)rhs;
        }

        if(_r != null)
        {
            if(name != _r.name)
            {
                if(name == null || _r.name == null || !name.equals(_r.name))
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
        __h = IceInternal.HashUtil.hashAdd(__h, "::user::PltTestReq");
        __h = IceInternal.HashUtil.hashAdd(__h, name);
        return __h;
    }

    public PltTestReq
    clone()
    {
        PltTestReq c = null;
        try
        {
            c = (PltTestReq)super.clone();
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
        __os.writeString(name);
    }

    public void
    __read(IceInternal.BasicStream __is)
    {
        name = __is.readString();
    }

    static public void
    __write(IceInternal.BasicStream __os, PltTestReq __v)
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

    static public PltTestReq
    __read(IceInternal.BasicStream __is, PltTestReq __v)
    {
        if(__v == null)
        {
             __v = new PltTestReq();
        }
        __v.__read(__is);
        return __v;
    }
    
    private static final PltTestReq __nullMarshalValue = new PltTestReq();

    public static final long serialVersionUID = -146083998L;
}
