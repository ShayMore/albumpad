package com.pad.mobile.user.model;

/**
 * 手机信息
 * @author YF
 */
public class PhoneInfo{
	
	private String pid;			//手机标识
	private String model;		//手机型号
	private String brand;		//手机品牌
	private String version;		//系统版本
	private String isonline;	//是否在线（1在线/0离线）
	private String logintime;	//登陆时间
	private String type;		//手机类型（android/ios）
	private String whether;		//是否正在使用（1是/0否）
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	public String getIsonline() {
		return isonline;
	}
	public void setIsonline(String isonline) {
		this.isonline = isonline;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getWhether() {
		return whether;
	}
	public void setWhether(String whether) {
		this.whether = whether;
	}
}