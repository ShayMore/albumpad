package com.pad.mobile.user.model;

/**
 * App版本信息
 * @author YF
 *
 */
public class AppVersionInfo{
	private String id;			//版本标识
	private String versionName;	//版本名称
	private String versionCode;	//版本代码
	private String download;	//下载地址
	private String type;		//App类型(android / ios)
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public String getVersionCode() {
		return versionCode;
	}
	public void setVersionCode(String versionCode) {
		this.versionCode = versionCode;
	}
	public String getDownload() {
		return download;
	}
	public void setDownload(String download) {
		this.download = download;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}