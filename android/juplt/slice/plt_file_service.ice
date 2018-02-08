#include "plt_common.ice"
#include "plt_exception.ice"
#include <Ice/BuiltinSequences.ice>

[["java:package:com.juzix.plt.slice"]]

module file {
	
	enum PltEndType{
		Commit,
		Cancel
	};

	/**
     * 创建下载任务应答
     */
	["java:getset"]
	struct PltDownTaskResp {
	
		/**
		 * 文件id
		 */
		string fileId;
		
		/**
		 * 文件总字节数
		 */
		int totalBytes;
	};


	/**
     * 文件下载请求参数
     */
	["java:getset"]
	struct PltFileDownReq {
	
		/**
		 * 文件id
		 */
		string fileId;
		
		/**
		 * 开始字节数
		 */
		int startBytes;
		
		/**
		 * 结束字节数
		 */
		int endBytes;
	};	
	
	
	/**
     * 文件下载响应参数
     */
	["java:getset"]
	struct PltFileDownResp {
	
		/**
		 * 文件id
		 */
		string fileId;
		
		/**
		 * 总字节大小
		 */
		int totalBytes;
		
		/**
		 * 开始字节数
		 */
		int startBytes;
		
		/**
		 * 结束字节数
		 */
		int endBytes;
		
		/**
		 * 内容
		 */
		Ice::ByteSeq content;
	};

	/**
	 * 文件服务
	 */
	interface PltFileService {
	
		/**
		 * 小文件上传
         * @param userId 用户id
         * @param token 登陆令牌
         * @param totalBytes 文件总字节数
         * @param content 文件内容
       	 * @param fileType 文件类型
         * @return fileId 文件id
		 */
		["amd"] string smallFileUpload(string userId, string token, int totalBytes,Ice::ByteSeq content,string fileType) throws ::common::PltException;
		
		/**
		 * 大文件上传创建上传任务
         * @param userId 用户id
         * @param token 登陆令牌
         * @param totalBytes 文件总字节数
         * @param fileType 文件类型
         * @return fileId 文件id
		 */
		["amd"] string createUpTask(string userId, string token, int totalBytes, string fileType) throws ::common::PltException;
		
		/**
		 * 大文件上传
         * @param fileId 文件id
         * @param totalBytes 文件总字节数
         * @param startBytes 开始字节数
         * @param endBytes 结束字节数
         * @param content 文件内容
         * @return fileId 文件id
		 */
		["amd"] string bigFileUpload(string fileId, int totalBytes, int startBytes, int endBytes, Ice::ByteSeq content) throws ::common::PltException;
		
		/**
		 * 大文件上传结束上传任务
         * @param fileId 文件id
         * @param action 结束标志  A:完成  B:取消
         * @return fileId 文件id
		 */
		["amd"] string endUpTask(string fileId, PltEndType action) throws ::common::PltException;
		
		/**
		 * 创建下载任务
         * @param userId 用户id
         * @param token 登陆令牌
         * @param fileId 文件id
         * @return PltDownTaskResp
		 */
		["amd"] PltDownTaskResp createDownTask(string userId, string token, string fileId) throws ::common::PltException;
		
		/**
		 * 文件下载
         * @param userId 用户id
         * @param token 登陆令牌
         * @param fileId 文件id
         * @return PltFileDownResp
		 */
		["amd"] PltFileDownResp fileDown(PltFileDownReq req) throws ::common::PltException;
		
	};
};