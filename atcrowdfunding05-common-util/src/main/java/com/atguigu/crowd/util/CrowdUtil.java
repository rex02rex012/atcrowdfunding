package com.atguigu.crowd.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import com.atguigu.crowd.constant.CrowdConstant;

public class CrowdUtil {

	/**
	 * 判斷當前請求是否為Ajax請求
	 * 
	 * @param request 請求對象
	 * @return true：當前請求是Ajax請求 false：當前請求不是Ajax請求
	 */
	public static boolean judgeRequestType(HttpServletRequest request) {

		// 1.獲取請求消息頭，對應####13.3.1 判斷依據 圖中的Key
		String acceptHeader = request.getHeader("Accept");
		String xRequestHeader = request.getHeader("X-Requested-With");

		// 2.判斷
		return (acceptHeader != null && acceptHeader.contains("application/json"))

				||

				(xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
	}

	/**
	 * 對明文字符串進行MD5 加密
	 * 
	 * @param source 傳入的明文字符串
	 * @return 加密結果
	 */
	public static String md5(String source) {
		// 1.判斷source 是否有效
		if (source == null || source.length() == 0) {
			// 2.如果不是有效的字符串拋出異常
			throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
		}
		try {
			// 3.獲取MessageDigest 對象
			String algorithm = "md5";
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			// 4.獲取明文字符串對應的字節數組
			byte[] input = source.getBytes();
			// 5.執行加密
			byte[] output = messageDigest.digest(input);
			// 6.創建BigInteger 對象
			int signum = 1;
			BigInteger bigInteger = new BigInteger(signum, output);
			// 7.按照16 進制將bigInteger 的值轉換為字符串
			int radix = 16;
			String encoded = bigInteger.toString(radix).toUpperCase();
			return encoded;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}