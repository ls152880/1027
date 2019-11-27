package com.lfz.test;

import org.apache.shiro.crypto.hash.SimpleHash;

public class TestMd5 {

	public static void main(String[] args) {
		Object obj = new SimpleHash("MD5", "567", "xm",1024);
		System.out.println(obj);
	}

}
