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
 * 用户服务
 **/
public abstract class _PltUserServiceDisp extends Ice.ObjectImpl implements PltUserService
{
    protected void
    ice_copyStateFrom(Ice.Object __obj)
        throws java.lang.CloneNotSupportedException
    {
        throw new java.lang.CloneNotSupportedException();
    }

    public static final String[] __ids =
    {
        "::Ice::Object",
        "::user::PltUserService"
    };

    public boolean ice_isA(String s)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public boolean ice_isA(String s, Ice.Current __current)
    {
        return java.util.Arrays.binarySearch(__ids, s) >= 0;
    }

    public String[] ice_ids()
    {
        return __ids;
    }

    public String[] ice_ids(Ice.Current __current)
    {
        return __ids;
    }

    public String ice_id()
    {
        return __ids[1];
    }

    public String ice_id(Ice.Current __current)
    {
        return __ids[1];
    }

    public static String ice_staticId()
    {
        return __ids[1];
    }

    /**
     * 空闲开始
     * @param __cb The callback object for the operation.
     * @param userId 用户id
     **/
    public final void idleBegin_async(AMD_PltUserService_idleBegin __cb, String userId, String token)
        throws com.juzix.plt.slice.common.PltException
    {
        idleBegin_async(__cb, userId, token, null);
    }

    /**
     * 空闲结束
     * @param __cb The callback object for the operation.
     * @param userId 用户id
     * @param idleSet 客户端闲置时间设置 单位分钟
     **/
    public final void idleEnd_async(AMD_PltUserService_idleEnd __cb, String userId, String token, String idleSet)
        throws com.juzix.plt.slice.common.PltException
    {
        idleEnd_async(__cb, userId, token, idleSet, null);
    }

    /**
     * 登陆(客户端)
     * @param __cb The callback object for the operation.
     * @param deviceId 设备id
     **/
    public final void login_async(AMD_PltUserService_login __cb, String deviceId, String data)
        throws com.juzix.plt.slice.common.PltException
    {
        login_async(__cb, deviceId, data, null);
    }

    /**
     * 登出(客户端)
     * @param __cb The callback object for the operation.
     * @param userId 用户id
     **/
    public final void logout_async(AMD_PltUserService_logout __cb, String userId, String token)
        throws com.juzix.plt.slice.common.PltException
    {
        logout_async(__cb, userId, token, null);
    }

    /**
     * 查询用户会话信息
     * @param __cb The callback object for the operation.
     * @param userId 用户id
     **/
    public final void queryUserInfo_async(AMD_PltUserService_queryUserInfo __cb, String userId)
        throws com.juzix.plt.slice.common.PltException
    {
        queryUserInfo_async(__cb, userId, null);
    }

    /**
     * 批量查询用户会话信息
     * @param __cb The callback object for the operation.
     * @param userIds 用户id列表
     **/
    public final void queryUserInfoBatch_async(AMD_PltUserService_queryUserInfoBatch __cb, String[] userIds)
        throws com.juzix.plt.slice.common.PltException
    {
        queryUserInfoBatch_async(__cb, userIds, null);
    }

    /**
     * 验证token
     * @param __cb The callback object for the operation.
     * @param userId 用户id
     **/
    public final void validationToken_async(AMD_PltUserService_validationToken __cb, String userId, String token)
        throws com.juzix.plt.slice.common.PltException
    {
        validationToken_async(__cb, userId, token, null);
    }

    public static Ice.DispatchStatus ___login(PltUserService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String deviceId;
        String data;
        deviceId = __is.readString();
        data = __is.readString();
        __inS.endReadParams();
        _AMD_PltUserService_login __cb = new _AMD_PltUserService_login(__inS);
        try
        {
            __obj.login_async(__cb, deviceId, data, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        catch(java.lang.Error ex)
        {
            __cb.__error(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus ___logout(PltUserService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String userId;
        String token;
        userId = __is.readString();
        token = __is.readString();
        __inS.endReadParams();
        _AMD_PltUserService_logout __cb = new _AMD_PltUserService_logout(__inS);
        try
        {
            __obj.logout_async(__cb, userId, token, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        catch(java.lang.Error ex)
        {
            __cb.__error(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus ___queryUserInfo(PltUserService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String userId;
        userId = __is.readString();
        __inS.endReadParams();
        _AMD_PltUserService_queryUserInfo __cb = new _AMD_PltUserService_queryUserInfo(__inS);
        try
        {
            __obj.queryUserInfo_async(__cb, userId, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        catch(java.lang.Error ex)
        {
            __cb.__error(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus ___queryUserInfoBatch(PltUserService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String[] userIds;
        userIds = com.juzix.plt.slice.common.StringListHelper.read(__is);
        __inS.endReadParams();
        _AMD_PltUserService_queryUserInfoBatch __cb = new _AMD_PltUserService_queryUserInfoBatch(__inS);
        try
        {
            __obj.queryUserInfoBatch_async(__cb, userIds, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        catch(java.lang.Error ex)
        {
            __cb.__error(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus ___validationToken(PltUserService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String userId;
        String token;
        userId = __is.readString();
        token = __is.readString();
        __inS.endReadParams();
        _AMD_PltUserService_validationToken __cb = new _AMD_PltUserService_validationToken(__inS);
        try
        {
            __obj.validationToken_async(__cb, userId, token, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        catch(java.lang.Error ex)
        {
            __cb.__error(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus ___idleBegin(PltUserService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String userId;
        String token;
        userId = __is.readString();
        token = __is.readString();
        __inS.endReadParams();
        _AMD_PltUserService_idleBegin __cb = new _AMD_PltUserService_idleBegin(__inS);
        try
        {
            __obj.idleBegin_async(__cb, userId, token, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        catch(java.lang.Error ex)
        {
            __cb.__error(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    public static Ice.DispatchStatus ___idleEnd(PltUserService __obj, IceInternal.Incoming __inS, Ice.Current __current)
    {
        __checkMode(Ice.OperationMode.Normal, __current.mode);
        IceInternal.BasicStream __is = __inS.startReadParams();
        String userId;
        String token;
        String idleSet;
        userId = __is.readString();
        token = __is.readString();
        idleSet = __is.readString();
        __inS.endReadParams();
        _AMD_PltUserService_idleEnd __cb = new _AMD_PltUserService_idleEnd(__inS);
        try
        {
            __obj.idleEnd_async(__cb, userId, token, idleSet, __current);
        }
        catch(java.lang.Exception ex)
        {
            __cb.ice_exception(ex);
        }
        catch(java.lang.Error ex)
        {
            __cb.__error(ex);
        }
        return Ice.DispatchStatus.DispatchAsync;
    }

    private final static String[] __all =
    {
        "ice_id",
        "ice_ids",
        "ice_isA",
        "ice_ping",
        "idleBegin",
        "idleEnd",
        "login",
        "logout",
        "queryUserInfo",
        "queryUserInfoBatch",
        "validationToken"
    };

    public Ice.DispatchStatus __dispatch(IceInternal.Incoming in, Ice.Current __current)
    {
        int pos = java.util.Arrays.binarySearch(__all, __current.operation);
        if(pos < 0)
        {
            throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
        }

        switch(pos)
        {
            case 0:
            {
                return ___ice_id(this, in, __current);
            }
            case 1:
            {
                return ___ice_ids(this, in, __current);
            }
            case 2:
            {
                return ___ice_isA(this, in, __current);
            }
            case 3:
            {
                return ___ice_ping(this, in, __current);
            }
            case 4:
            {
                return ___idleBegin(this, in, __current);
            }
            case 5:
            {
                return ___idleEnd(this, in, __current);
            }
            case 6:
            {
                return ___login(this, in, __current);
            }
            case 7:
            {
                return ___logout(this, in, __current);
            }
            case 8:
            {
                return ___queryUserInfo(this, in, __current);
            }
            case 9:
            {
                return ___queryUserInfoBatch(this, in, __current);
            }
            case 10:
            {
                return ___validationToken(this, in, __current);
            }
        }

        assert(false);
        throw new Ice.OperationNotExistException(__current.id, __current.facet, __current.operation);
    }

    protected void __writeImpl(IceInternal.BasicStream __os)
    {
        __os.startWriteSlice(ice_staticId(), -1, true);
        __os.endWriteSlice();
    }

    protected void __readImpl(IceInternal.BasicStream __is)
    {
        __is.startReadSlice();
        __is.endReadSlice();
    }

    public static final long serialVersionUID = 0L;
}
