package com.pad.base.common.tools;

import java.util.Random;

/**
 * 生成随机数
 * 
 * @author YF
 */
public class Randnum {

	public static int getRandomNumber(int n) {
		int temp = 0;
		int min = (int) Math.pow(10.0D, n - 1);
		int max = (int) Math.pow(10.0D, n);
		Random rand = new Random();
		do {
			temp = rand.nextInt(max);
		} while (temp < min);
		return temp;
	}

	/** abcdefghijklmnopqrstuvwxyz */
	public static String getRandomAccountnumber(int n) {
		String str = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			int number = random.nextInt(str.length());
			sb.append(str.charAt(number));
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(Randnum.getRandomAccountnumber(6));
	}
}
