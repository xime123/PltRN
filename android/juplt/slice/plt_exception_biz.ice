[["java:package:com.juzix.plt.slice"]]

module proxy {
    
  	exception BizException {
        int errorCode;
        string errorMsg;
    };
    
    /**
     * 登陆业务系统响应
     */
	["java:getset"]
	struct PltLoginBizResp {
	
		/**
		 * 后端业务层返回的数据
		 */
		string data;
		
		/**
		 * 用户id
		 */
		string userId;
	};
	
	/**
	 * 用户服务
	 */
	interface PltBizUserService {
		
		/**
		 * 业务系统登陆(客户端)
         * @param data 登陆业务数据
         * @return LoginBizResp 登陆业务系统响应信息
		 */
		["amd"] PltLoginBizResp loginForBiz(string data) throws BizException;
				
	};
};