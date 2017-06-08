
/*
 * 找不到sun.misc.BASE64Encoder的解决办法:Windows -> Preferences -> Java -> Compiler -> Errors/Warnings -> 
 * Deprecated and trstricted API -> Forbidden reference (access rules): -> change to warning
 * */
import sun.misc.BASE64Encoder;

import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.util.encoders.Base64Encoder;

import sun.misc.BASE64Decoder;

public class TestBase64 {

	private static String before = "jiamiqian base64";
	
	public static void main(String[] args) {
		//jdkBase64();    //amlhbWlxaWFuIGJhc2U2NA==
		//commonsCodecBase64(); //amlhbWlxaWFuIGJhc2U2NA==
		bouncyCastleBase64(); //encode:amlhbWlxaWFuIGJhc2U2NA==
	}
	
	public static void jdkBase64(){
		BASE64Encoder encoder = new BASE64Encoder();
		String encode = encoder.encode(before.getBytes());
		System.out.println("encode:" + encode);
		
		BASE64Decoder decoder = new BASE64Decoder();
		
		try {
			System.out.println("decode:" + new String(decoder.decodeBuffer(encode)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void commonsCodecBase64(){
		byte[] encodeBytes = Base64.encodeBase64(before.getBytes());
		System.out.println("encode:" + new String(encodeBytes));
		
		byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
		System.out.println("decode:" + new String(decodeBytes));
		
	}
	
	public static void bouncyCastleBase64(){

		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(before.getBytes());
		System.out.println("encode:" + new String(encodeBytes));
		
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		System.out.println("decode:" + new String(decodeBytes));
	}
}
