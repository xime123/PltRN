#include "plt_common.ice"
#include "plt_exception.ice"
#include <Glacier2/Session.ice>

[["java:package:com.juzix.plt.slice"]]

module session {
	
	/**
	 * 客户端的消息回调对象
	 */
	interface PltMsgCallback {
	
		/**
		 * 消息回调(客户端)
		 * @param cd 业务代码
		 * @param msgType 消息类型。 D:设备消息。U:用户消息
		 * @param mode 消息模式。1：消息即入库、又通知。2：仅通知
		 * @param label 消息标题
		 * @param msgContent 消息体jsonObject格式。具体业务定义。当md=2存在
		 */
	    void push(string cd, string msgType, string mode, string label, string msgContent) throws ::common::PltException;
	};


	/**
	 * 会话服务
	 */
	interface PltSession extends Glacier2::Session {

		/**
		 * 添加消息回调对象(客户端)
		 @param deviceId 设备id
		 * @param proxy 消息回调对象
		 */
		["amd"] void addMsgCallback(string deviceId,PltMsgCallback* proxy) throws ::common::PltException;
	};
};