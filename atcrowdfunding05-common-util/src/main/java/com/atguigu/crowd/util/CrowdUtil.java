package com.atguigu.crowd.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import com.atguigu.crowd.constant.CrowdConstant;

public class CrowdUtil {

	/**
	 * �P�_��e�ШD�O�_��Ajax�ШD
	 * 
	 * @param request �ШD��H
	 * @return true�G��e�ШD�OAjax�ШD false�G��e�ШD���OAjax�ШD
	 */
	public static boolean judgeRequestType(HttpServletRequest request) {

		// 1.����ШD�����Y�A����####13.3.1 �P�_�̾� �Ϥ���Key
		String acceptHeader = request.getHeader("Accept");
		String xRequestHeader = request.getHeader("X-Requested-With");

		// 2.�P�_
		return (acceptHeader != null && acceptHeader.contains("application/json"))

				||

				(xRequestHeader != null && xRequestHeader.equals("XMLHttpRequest"));
	}

	/**
	 * �����r�Ŧ�i��MD5 �[�K
	 * 
	 * @param source �ǤJ������r�Ŧ�
	 * @return �[�K���G
	 */
	public static String md5(String source) {
		// 1.�P�_source �O�_����
		if (source == null || source.length() == 0) {
			// 2.�p�G���O���Ī��r�Ŧ�ߥX���`
			throw new RuntimeException(CrowdConstant.MESSAGE_STRING_INVALIDATE);
		}
		try {
			// 3.���MessageDigest ��H
			String algorithm = "md5";
			MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
			// 4.�������r�Ŧ�������r�`�Ʋ�
			byte[] input = source.getBytes();
			// 5.����[�K
			byte[] output = messageDigest.digest(input);
			// 6.�Ы�BigInteger ��H
			int signum = 1;
			BigInteger bigInteger = new BigInteger(signum, output);
			// 7.����16 �i��NbigInteger �����ഫ���r�Ŧ�
			int radix = 16;
			String encoded = bigInteger.toString(radix).toUpperCase();
			return encoded;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

}