package com.pad.base.common.systemreturn;

import java.util.List;

/**
 * 系统返回对象
 * @author YangFan
 * @param <T>
 */
public class ReturnValue<T> {

	private String retCode = "";	//状态码（见：ReturnCode）
	private String retDesc = "";	//状态描述
	private String content = "";	//返回内容
	private int totalrecords = 0;	//总记录数量
	private T retVal = null;		
	private List<T> list = null;
	
	public ReturnValue(){};
	
	public ReturnValue(String retCode,String retDesc){
		this.retCode = retCode;
		this.retDesc = retDesc;
	}

	public String getRetCode() {
		return retCode;
	}

	public void setRetCode(String retCode) {
		this.retCode = retCode;
	}

	public String getRetDesc() {
		return retDesc;
	}

	public void setRetDesc(String retDesc) {
		this.retDesc = retDesc;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getTotalrecords() {
		return totalrecords;
	}

	public void setTotalrecords(int totalrecords) {
		this.totalrecords = totalrecords;
	}

	public T getRetVal() {
		return retVal;
	}

	public void setRetVal(T retVal) {
		this.retVal = retVal;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
		this.totalrecords = list.size();
	}
}