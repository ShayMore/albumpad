package com.pad.mobile.user.model;

/**
 * 视频留言实体
 * @author MoYalan
 *
 */
public class VideoMsg {
	
	private String vmid;				//留言标识
	private String sender;				//发送者 （设备标识）
	private String deviceremark;		//设备备注
	private String content;				//文字内容
	private String receiver;			//接收者 （用户标识）
	private String networkaddress;		//视频地址
	private String thumbnails;			//缩略图
	private String opttime;				//发送时间

	public String getVmid() {
		return vmid;
	}
	public void setVmid(String vmid) {
		this.vmid = vmid;
	}
	public String getDeviceremark() {
		return deviceremark;
	}
	public void setDeviceremark(String deviceremark) {
		this.deviceremark = deviceremark;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getNetworkaddress() {
		return networkaddress;
	}
	public void setNetworkaddress(String networkaddress) {
		this.networkaddress = networkaddress;
	}
	public String getThumbnails() {
		return thumbnails;
	}
	public void setThumbnails(String thumbnails) {
		this.thumbnails = thumbnails;
	}
	public String getOpttime() {
		return opttime;
	}
	public void setOpttime(String opttime) {
		this.opttime = opttime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
}
