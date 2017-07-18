package com.pad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import com.pad.base.common.tools.HTTPSend;

public class Test {
	public static void main(String[] args){
		HTTPSend send = new HTTPSend();
		
//		Map<Object,Object> m1= new HashMap<Object,Object>();
//		m1.put("did", "test");
//		m1.put("token", "token1001");
//		m1.put("objective", "device");
//		m1.put("action", "getNewMsg");
		
		Map<Object,Object> m2= new HashMap<Object,Object>();
		m2.put("account", "shaymoo@163.com");
		m2.put("type", "modifyPassword");
//		m1.put("data", m2);
		
		JSONObject json = JSONObject.fromObject(m2);
		
		System.out.println("json:"+json.toString());
		
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("data",json.toString()));
		
		System.out.println("params:"+params.toString());

		send.sendPostRequest("http://127.0.0.1:8080/mobile/user/getCode?" , params);
	}
}
