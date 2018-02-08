[["java:package:com.juzix.plt.slice"]]

module common {
    enum RespCode {
    	// 通用错误(0-1999)
    	Success=0,                		           //成功（客户端）
   		SystemDefaultError=1000,			       //系统错误（客户端）
        DataAgentServiceError=1001,                //调用DataAgen服务异常
        JuLoggerServiceError=1002,                 //调用JuLogger服务异常
        RedisServiceError=1003,		               //调用REDIS服务 

        // 设备异常(2000-2099)
        DeviceServiceError=2000,          //调用设备服务异常
        DeviceIdIsBlank=2001,               //设备id为空
        OsTypeIsBlank=2002,               //osType为空
        DeviceIdentifierIsBlank=2003,   //deviceIdentifier为空
        
        //session异常(2100-20199)
        PltSessionError=2100,     // PltSession异常
        

        // 消息异常(3000-3999)
        MessageServiceError=3000,         // 调用消息服务异常

		// 用户异常(4000-4999)
        UserServiceError=4000, 			  //用户会话服务异常

		// 文件服务异常(5000-5999)
        FileServiceError=5000,           //文件服务异常
        
        // 代理异常(6000-6999)
        ProxyServiceError=6000,          //业务代理服务异常
       	AuthenticationFailure=6001,      //业务代理服务转发时鉴权失败（客户端）
        BizServiceError=6002,            //目标服务异常
    };
};
