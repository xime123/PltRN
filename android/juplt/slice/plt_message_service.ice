#include "plt_common.ice"
#include "plt_exception.ice"

[["java:package:com.juzix.plt.slice"]]

module message {

	/**
	 * 消息服务
	 */
	interface PltMessageService {

		/**
		 * 推送消息
		 */
		["amd"] void push(string msgType, ::common::StringList receivers, string mode, string label, string msgContent, string cd, string sender, string chainType) throws ::common::PltException;
	};
};