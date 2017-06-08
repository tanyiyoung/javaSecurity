package com.ty.security.sha;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;

/*
 * SHA:°²È«HashËã·¨;
 * 
 * */

public class TestSHA {

	private static String before = "jiamiqian sha";
	
	public static void main(String[] args) {
		jdkSHA1();  //jdk SHA1:244791d95fdad77c40f435a3ea390ccb891b2c03
		bcSHA1(); 	//bc SHA1:244791d95fdad77c40f435a3ea390ccb891b2c03
		bcSHA224();//bc SHA224:5c336cee8308750bea9b25908d6780d393863ede5574ccd11c01e91f
		ccSHA1(); //cc SHA1:244791d95fdad77c40f435a3ea390ccb891b2c03
	}
	
	public static void jdkSHA1(){
		try {
			MessageDigest sha = MessageDigest.getInstance("SHA");
			sha.update(before.getBytes());
			System.out.println("jdk SHA1:" + Hex.encodeHexString(sha.digest()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	 
	public static void bcSHA1(){
		Digest digest = new SHA1Digest();
		digest.update(before.getBytes(), 0, before.getBytes().length);
		byte[] sha1Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha1Bytes, 0);
		System.out.println("bc SHA1:" + org.bouncycastle.util.encoders.Hex.toHexString(sha1Bytes));
		
	}
	
	public static void bcSHA224(){
		Digest digest = new SHA224Digest();
		digest.update(before.getBytes(), 0, before.getBytes().length);
		byte[] sha224Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha224Bytes, 0);
		System.out.println("bc SHA224:" + org.bouncycastle.util.encoders.Hex.toHexString(sha224Bytes));
		
	}
	
	public static void ccSHA1(){
		System.out.println("cc SHA1:" + Hex.encodeHexString(DigestUtils.sha1(before.getBytes())));
		System.out.println("cc SHA1:" + DigestUtils.sha1Hex(before.getBytes()));
	}
	
	
}
