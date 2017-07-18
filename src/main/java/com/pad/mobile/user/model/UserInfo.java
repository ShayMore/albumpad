package com.pad.mobile.user.model;


public class UserInfo{
	
	private String userid;			//用户标识
	private String accountnumber;	//登陆账号
	private String password;		//密码
	private String nickname;		//昵称
	private String phone;			//手机号码
	private String sipno;			//sip号码
	private String sippw;			//sip密码
	private String nowcity;			//当前所在城市
	private String registertime;	//注册时间
	private String headportrait;	//头像
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSipno() {
		return sipno;
	}
	public void setSipno(String sipno) {
		this.sipno = sipno;
	}
	public String getSippw() {
		return sippw;
	}
	public void setSippw(String sippw) {
		this.sippw = sippw;
	}
	public String getNowcity() {
		return nowcity;
	}
	public void setNowcity(String nowcity) {
		this.nowcity = nowcity;
	}
	public String getRegistertime() {
		return registertime;
	}
	public void setRegistertime(String registertime) {
		this.registertime = registertime;
	}
	public String getHeadportrait() {
		return headportrait;
	}
	public void setHeadportrait(String headportrait) {
		this.headportrait = headportrait;
	}
}