package com.lfz.util;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * MD5���ܹ�����
 */
public class MD5 {

	// ���� ʹ��MD5
	private static String hashAlgorithmName = "MD5";
	// ���ܴ���
	private static int hashIterations = 1024;

	public static Object getMD5(String pwd, String salt) {
		Object obj = new SimpleHash(hashAlgorithmName, pwd, salt, hashIterations);
		return obj;
	}
}
