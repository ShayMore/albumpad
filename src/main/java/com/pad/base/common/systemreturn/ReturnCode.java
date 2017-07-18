package com.pad.base.common.systemreturn;

/**
 * 返回状态码
 * 
 * @author YF
 */
public class ReturnCode {

	public static final String SUCCESS = "SUCCESS"; // 成功，获得正确结果
	public static final String FAIL = "FAIL"; // 失败，获得错误结果
	public static final String ERROR = "ERROR"; // 异常，程序异常崩溃

	// 具体业务状态码 用户模块
	public static final String U_ACCOUNT_EXIST = "U_ACCOUNT_EXIST"; // 账号已注册
	public static final String U_ACCOUNT_WRONG = "U_ACCOUNT_WRONG"; // 用户不存在
	public static final String U_ACCOUNT_PASSWORD_WRONG = "U_ACCOUNT_PASSWORD_WRONG"; // 账号或密码错误

	// 具体业务状态码 设备模块
	public static final String D001 = "D001"; // 设备已绑定
	public static final String D002 = "D002"; // 设备不存在
	public static final String D003 = "D003"; // 您不是管理员，操作无效！	
	public static final String D004 = "D004"; // 此用户已是家庭成员
	public static final String D005 = "D005"; // 此用户不存在
	public static final String D007 = "D007"; // 已拒绝
	public static final String D008 = "D008"; // 已同意
	public static final String D009 = "D009"; // 您不是管理员不可移除用户
	public static final String D010 = "D010"; // 您不是管理员不可转让权限
	public static final String D011 = "D011"; // 管理员不可解绑

	// 具体业务状态码 终端模块
	public static final String T001 = "T001"; // 设备不存在
	public static final String T002 = "T002"; // 设备不可用
	public static final String T003 = "T003"; // 已同意
	public static final String T004 = "T004"; // 已拒绝
}