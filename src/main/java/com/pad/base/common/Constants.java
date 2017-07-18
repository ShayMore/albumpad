package com.pad.base.common;

/**
 * 公共常量
 * @author myl
 */
public final class Constants {

	// 项目
	public static String WEBAPP_HOME = "";
	public static String WEBSERVICE_IP = "";
	public static String PROJECT_NAME = "";
	public static String CONTEXT_PATH = "";
	
	//web服务器域名
	public static String WEB_SERVICE_DOMAIN_NAME = "http://47.88.2.169:15114";

	//文件
	public static String FILE_DISK_PATH = "/sego/photolink/resources/";//文件磁盘路径
	public static String FILE_NETWORK_PATH = WEB_SERVICE_DOMAIN_NAME + "/photolink/resources/";//资源文件网络路径
	public static String DEFAULT_USERID = "001";
	public static String DEFAULT_PIC = "photo/sego001.png";
	
	public static String PHOTO_FOLDER_NAME = "photo/";//图片文件夹名称
	public static String VIDEO_FOLDER_NAME = "video/";//视频文件夹名称
	
	// 终端请求地址
	public static String TERMINAL_REQUEST_PATH = "http://47.88.2.169:15108/rest/operate/";

	// SIP请求地址
	public static String SIP_REQUEST_PATH = "http://47.88.2.169:15111/rest/operate/";

	// 字符编码
	public static final String CHARACTER_ENCODING = "UTF-8";

}
