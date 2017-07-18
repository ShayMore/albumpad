package com.pad.base.common;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.methods.GetMethod;

//import org.apache.commons.httpclient.HttpException;
//import org.apache.commons.httpclient.methods.GetMethod;
/**
 * 获取网页信息
 * @author YF
 *
 */
public class GetSource {

	/**
	 * @param args
	 */
	public HttpClient client = new HttpClient();

	public String getSource(String url) {

		GetMethod method = new GetMethod(url);

		try {
			client.executeMethod(method);

		} catch (HttpException e) {

			// e.printStackTrace();

		} catch (IOException e) {

			// e.printStackTrace();

		}
		InputStream in = null;
		try {
			in = method.getResponseBodyAsStream();
		} catch (IOException e1) {

			// e1.printStackTrace();
		}
		in = new BufferedInputStream(in);
		Reader r = new InputStreamReader(in);
		int c;
		StringBuffer buffer = new StringBuffer();

		try {
			while ((c = r.read()) != -1)
				buffer.append((char) c);
		} catch (IOException e) {

			// e.printStackTrace();
		}
		try {
			in.close();
		} catch (IOException e) {

			// e.printStackTrace();
		}
		method.releaseConnection();

		return buffer.toString();
	}

}
