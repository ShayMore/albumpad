package com.pad.base.common.systemreturn;

/**
 * 返回描述码
 * 
 * @author myl
 */
public class ReturnDesc {

	// 相册模块
	public static final String NEW_SUCCESS = "NEW_SUCCESS"; 		// 新建成功（新建相册）
	public static final String NEW_FAIL = "NEW_FAIL"; 				// 新建失败（新建相册）
	public static final String EDIT_SUCCESS = "EDIT_SUCCESS"; 		// 编辑成功（编辑相册）
	public static final String EDIT_FAIL = "EDIT_FAIL"; 			// 编辑失败（编辑相册）
	public static final String DEL_SUCCESS = "DEL_SUCCESS"; 		// 删除成功（删除相册/删除照片）
	public static final String DEL_FAIL = "DEL_FAIL"; 				// 删除失败（删除相册/删除照片）
	public static final String UPLOAD_SUCCESS = "UPLOAD_SUCCESS"; 		// 上传成功（上传照片）
	public static final String UPLOAD_FAIL = "UPLOAD_FAIL"; 			// 上传失败（上传照片）
	public static final String PIC_DELETED = "PIC_DELETED"; 		// 照片已删除（查询文章中的照片）
	public static final String ADD_BEHAVIOR_SUCCESS = "ADD_BEHAVIOR_SUCCESS"; 		// 点赞成功（添加点赞）
	public static final String ADD_BEHAVIOR_FAIL = "ADD_BEHAVIOR_FAIL"; 			// 点赞失败（添加点赞）
	public static final String ADD_COMMENT_SUCCESS = "ADD_COMMENT_SUCCESS"; 	// 评论成功（添加评论）
	public static final String ADD_COMMENT_FAIL = "ADD_COMMENT_FAIL"; 			// 评论失败（添加评论）

	// 设备模块
	public static final String REQUEST_SUCCESS = "REQUEST_SUCCESS"; // 请求发送成功（用户请求绑定设备）
	public static final String REQUEST_FAIL = "REQUEST_FAIL"; 		// 请求发送失败（用户请求绑定设备）
	public static final String DEVICENO_EMPTY = "DEVICENO_EMPTY"; 		// 设备号为空（用户请求绑定设备）
	public static final String INVITE_SUCCESS = "INVITE_SUCCESS"; 	// 邀请发送成功（管理邀请用户绑定设备）
	public static final String INVITE_FAIL = "INVITE_FAIL"; 		// 邀请发送失败（管理邀请用户绑定设备）
	public static final String OPERATE_SUCCESS = "OPERATE_SUCCESS"; 		// 操作成功（响应邀请/申请）
	public static final String OPERATE_FAIL = "OPERATE_FAIL"; 				// 操作失败（响应邀请/申请）
	public static final String MODIFY_SUCCESS = "MODIFY_SUCCESS"; 		// 修改成功（修改设备备注/修改昵称/修改密码/修改头像）
	public static final String MODIFY_FAIL = "MODIFY_FAIL"; 			// 修改失败（修改设备备注/修改昵称/修改密码/修改头像）
	public static final String REMOVE_SUCCESS = "REMOVE_SUCCESS"; 		// 移除成功（移除家庭成员）
	public static final String REMOVE_FAIL = "REMOVE_FAIL"; 			// 移除失败（移除家庭成员）
	public static final String TRANSFER_SUCCESS = "TRANSFER_SUCCESS"; 		// 转让成功（转让管理员权限）
	public static final String TRANSFER_FAIL = "TRANSFER_FAIL"; 			// 转让失败（转让管理员权限）
	public static final String SEND_VIDEO_SUCCESS = "SEND_VIDEO_SUCCESS"; 		// 发送成功（发送视频）
	public static final String SEND_VIDEO_FAIL = "SEND_VIDEO_FAIL"; 			// 发送失败（发送视频）
	public static final String UNBIND_SUCCESS = "UNBIND_SUCCESS"; 		// 解绑成功（设备解绑）
	public static final String UNBIND_FAIL = "UNBIND_FAIL"; 			// 解绑失败（设备解绑）
	
	// 用户模块
	public static final String GETCODE_SUCCESS = "GETCODE_SUCCESS"; 	// 验证码发送成功（获取验证码：注册/忘记密码）
	public static final String GETCODE_FAIL = "GETCODE_FAIL"; 			// 验证码获取失败（获取验证码：注册/忘记密码）
	public static final String REGISTER_SUCCESS = "REGISTER_SUCCESS"; 		// 注册成功（注册）
	public static final String REGISTER_FAIL = "REGISTER_FAIL"; 			// 注册失败（注册）
	public static final String LOGIN_SUCCESS = "LOGIN_SUCCESS"; 	// 登录成功（登录）
    public static final String LOGIN_FAIL = "LOGIN_FAIL"; 	        // 登录失败（登录）
    public static final String RESET_SUCCESS = "RESET_SUCCESS"; 	// 重置成功（忘记密码）
	public static final String RESET_FAIL = "RESET_FAIL"; 			// 重置失败（忘记密码）
	public static final String WRONG_PASSWORD = "WRONG_PASSWORD"; 	// 原密码错误（修改密码）
	public static final String FEEDBACK_SUCCESS = "FEEDBACK_SUCCESS"; 		// 意见反馈成功（意见反馈）
	public static final String FEEDBACK_FAIL = "FEEDBACK_FAIL"; 			// 意见反馈失败（意见反馈）

}