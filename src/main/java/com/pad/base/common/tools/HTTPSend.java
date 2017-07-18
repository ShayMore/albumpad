package com.pad.base.common.tools;

import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.pad.base.common.systemreturn.ReturnCode;
import com.pad.base.common.systemreturn.ReturnValue;


/**
 * HTTP请求
 * @author YF
 */
@SuppressWarnings({ "deprecation", "resource","rawtypes"})
public class HTTPSend {
	private Logger logger = LogManager.getLogger(this.getClass());
	
	public ReturnValue sendPostRequest(String url,List<NameValuePair> params){
		ReturnValue ret = new ReturnValue();
		try{
			DefaultHttpClient httpclient = new DefaultHttpClient();
			// 建立 POST 请求
			HttpPost httppost = new HttpPost(url);
			// 参数
			HttpEntity formEntity = new UrlEncodedFormEntity(params,HTTP.UTF_8);
			httppost.setEntity(formEntity);
			// 发送请求
			HttpResponse response = httpclient.execute(httppost);
			
			//获取请求返回结果
			HttpEntity httpentity = response.getEntity();
			
			//读取请求返回结果
			if (httpentity != null) {
				
				// 读取字符串
				String rpString = EntityUtils.toString(httpentity);
				logger.info("HttpReturn:"+rpString);
				
				ret.setRetCode(ReturnCode.SUCCESS);
				ret.setRetDesc("请求成功");
				ret.setContent(rpString);
				
				//关闭请求
				httpclient.getConnectionManager().shutdown();
			}else{
				logger.info("请求结果为空");
				ret.setRetCode(ReturnCode.FAIL);
				ret.setRetDesc("请求结果为空");
				ret.setContent("请求结果为空");
			}
		}catch(Exception e){
			logger.info("请求发送异常："+e.toString());
			ret.setRetCode(ReturnCode.ERROR);
			ret.setRetDesc("请求异常");
			ret.setContent("请求异常");
		}
		return ret;
	}
}
