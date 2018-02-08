#include "plt_common.ice"
#include "plt_exception.ice"

[["java:package:com.juzix.plt.slice"]]

module user {

	/**
     * 用户会话信息
     */
	["java:getset"]
	struct PltUserInfo {
	
		/**
		 * 设备id
		 */
		string deviceId;
		
		/**
		 * 用户登录令牌
		 */
		string token;
		
		/**
		 * 用户id
		 */
		string userId;
	};

	//字符串列表
    sequence<PltUserInfo> userInfoList;
    
   	/**
     * 登陆响应
     */
	["java:getset"]
	struct PltLoginResp {
		/**
		 * 错误码
		 */
        int errorCode;
        
        /**
		 * 错误信息
		 */
        string errorMsg;
	
		/**
		 * 后端业务层返回的数据
		 */
		string data;
		
		/**
		 * 用户登录令牌
		 */
		string token;
		
		/**
		 * 用户id
		 */
		string userId;
	};
	
	
    /**
     * 测试请求实体
     */
	["java:getset"]
	struct PltTestReq {
		string name;
	};
	/**
	 * 用户服务
	 */
	interface PltUserService {

		/**
		 * 登陆(客户端)
		 * @param deviceId 设备id
         * @param data 登陆业务数据
         * @return LoginResp 登陆响应信息
		 */
		["amd"] PltLoginResp login(string deviceId, string data) throws ::common::PltException;
		
		/**
		 * 登出(客户端)
         * @param userId 用户id
         * @param token 登陆返回的token
		 */
		["amd"] void logout(string userId, string token) throws ::common::PltException;
		
			
		/**
		 * 查询用户会话信息
		 * @param userId 用户id
		 * @return UserInfo
		 */
		["amd"] PltUserInfo queryUserInfo(string userId) throws ::common::PltException;
		
		/**
		 * 批量查询用户会话信息
		 * @param userIds 用户id列表
		 * @return userInfoList 用户会话信息列表
		 */
		["amd"] userInfoList queryUserInfoBatch(::common::StringList userIds) throws ::common::PltException;

		/**
         * 验证token
         * @param userId 用户id
         * @param token 客户端传token
         * @return true|false
         */
		["amd"] bool validationToken(string userId, string token) throws ::common::PltException;
		
		/**
         * 空闲开始
         * @param userId 用户id
         * @param token 客户端传token
         */
		["amd"] void idleBegin(string userId, string token) throws ::common::PltException;
		
		/**
         * 空闲结束
         * @param userId 用户id
         * @param token 客户端传token
         * @param idleSet 客户端闲置时间设置 单位分钟
         */
		["amd"] void idleEnd(string userId, string token, string idleSet) throws ::common::PltException;
		
	};
};