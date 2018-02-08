#include "plt_common.ice"
#include "plt_exception.ice"

[["java:package:com.juzix.plt.slice"]]

module device {

	/**
     * 设备会话信息
     */
	["java:getset"]
	struct PltDeviceInfo {
		
		/**
		 * deviceId 设备Id
		 */
		string deviceId;
	
		/**
		 * apns token
		 */
		string apns;
		
		/**
		 * ice session 连接状态
		 */
		string connectStatus;
		
		/**
		 * 设备的唯一标示
		 * 当android时：mac
		 * 当ios时：uuid
		 */
		string deviceIdentifier;
		
		/**
		 * 设备类型  ISO|ANDROID
		 */
		string osType;
		
		/**
		 * ice callback proxy
		 */
		string callbackProxy;
		
		/**
		 * 设备关联的用户
		 */
		string userId;
	};
	
	//字符串列表
    sequence<PltDeviceInfo> deviceInfoList;
	

	/**
	 * 设备服务
	 */
	interface PltDeviceService {

		/**
		 * 设备注册
         * @param osType 设备类型。  ISO|ANDROID
         * @param deviceIdentifier 设备的唯一标示。 当android时：mac ，当ios时：uuid
         * @param apns token
         * @return deviceId 设备id
		 */
		["amd"] string register(string osType, string deviceIdentifier, string apns) throws ::common::PltException;

		/**
		 * 更新设备会话信息，当属性存在时采用增量更新(客户端)
		 * @param deviceId 设备id
		 * @param deviceInfo 设备信息
		 */
		["amd"] void updateSelective(string deviceId,PltDeviceInfo deviceInfo) throws ::common::PltException;

		
		/**
		 * 增量删除设备会话信息
		 * @param deviceId 设备id
		 * @param fields 需要删除会话的fields
		 */
		["amd"] void deleteSelective(string deviceId,::common::StringList fields) throws ::common::PltException;
		
		/**
		 * 查询设备会话信息
		 * @param deviceId 设备id
		 * @return PltDeviceInfo
		 */
		["amd"] PltDeviceInfo queryDeviceInfo(string deviceId) throws ::common::PltException;
		
		
		/**
		 * 批量查询设备会话信息
		 * @param deviceIds 设备id列表
		 * @return deviceInfoList 设备信息列表
		 */
		["amd"] deviceInfoList queryDeviceInfoBatch(::common::StringList deviceIds) throws ::common::PltException;
	};
};