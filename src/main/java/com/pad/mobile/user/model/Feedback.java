package com.pad.mobile.user.model;

/**
 * 意见反馈信息
 * 
 * @author MoYalan
 *
 */
public class Feedback {

	private String equipmentid; // 标识
	private String userid; // 投诉人MID
	private String fcontent; // 反馈内容
	private String type; // 手机类型
	private String ftime; // 反馈时间
	private String fphone; // 反馈人手机号

	public String getEquipmentid() {
		return equipmentid;
	}

	public void setEquipmentid(String equipmentid) {
		this.equipmentid = equipmentid;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getFcontent() {
		return fcontent;
	}

	public void setFcontent(String fcontent) {
		this.fcontent = fcontent;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFtime() {
		return ftime;
	}

	public void setFtime(String ftime) {
		this.ftime = ftime;
	}

	public String getFphone() {
		return fphone;
	}

	public void setFphone(String fphone) {
		this.fphone = fphone;
	}
}
