#include "plt_common.ice"
#include "plt_exception.ice"

[["java:package:com.juzix.plt.slice"]]

module proxy {
    
	/**
     * 代理请求参数
     */
	["java:getset"]
	struct PltInvokeReq {
	
		/**
		 * 业务代码
		 */
		string cd;
		
		/**
		 * 业务请求参数
		 */
		string data;
		
		/**
		 * 用户ID
		 */
		string userId;
				
		/**
		 * 用户令牌
		 */
		string token;	
		
	};
	
	/**
     * 代理响应参数
     */
	["java:getset"]
	struct PltInvokeResp {
	
		/**
		 * 业务代码
		 */
		string cd;
		
		/**
		 * 错误码
		 */
        int errorCode;
        
        /**
		 * 错误信息
		 */
        string errorMsg;
		
		/**
		 * 业务请求参数
		 */
		string data;		
	};

	/**
	 * 业务代理服务
	 */
	interface PltProxyService {

		/**
		 * 业务代理(客户端)
		 */
		["amd"] PltInvokeResp invoke(PltInvokeReq req) throws ::common::PltException;
	};
};