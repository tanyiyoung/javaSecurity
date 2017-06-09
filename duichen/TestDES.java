package com.ty.security.des;


import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

/*
 *DES:data encryption standard(数据加密标准);
 *
 * */

public class TestDES {

	public static String before = "duichenjiami DES";
	public static void main(String[] args) {
		jdkDES();  //jdk des encrypto :7a256f620b34a869f9733a310fc5bd1a5f1e079a33cd13a4
					//jdk des decrypto :duichenjiami DES
		bcDES();   //bc des encrypto :334e6d0df95520950a6f281818369ad31e0716eee61a3244
					//bc des decrypto :duichenjiami DES
	}
	
	
	public static void jdkDES(){
		try {
			
			//生成Key;
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
			keyGenerator.init(56);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//KEY转换;
			try {
				DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
				SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
				Key convertSecretKey = factory.generateSecret(desKeySpec);
				
			//加密;
				Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
				cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
				byte[] result = cipher.doFinal(before.getBytes());
				
				System.out.println("jdk des encrypto :" + Hex.encodeHexString(result));
				
			
			//解密;
				cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
				result =  cipher.doFinal(result);
				System.out.println("jdk des decrypto :" + new String(result));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public static void bcDES(){
		
		try {
			Security.addProvider(new BouncyCastleProvider());
			//生成Key;
			KeyGenerator keyGenerator = KeyGenerator.getInstance("DES","BC");
			keyGenerator.init(56);
			SecretKey secretKey = keyGenerator.generateKey();
			byte[] bytesKey = secretKey.getEncoded();
			
			//KEY转换;
			try {
				DESKeySpec desKeySpec = new DESKeySpec(bytesKey);
				SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
				Key convertSecretKey = factory.generateSecret(desKeySpec);
				
			//加密;
				Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
				cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);
				byte[] result = cipher.doFinal(before.getBytes());
				
				System.out.println("bc des encrypto :" + Hex.encodeHexString(result));
				
			
			//解密;
				cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
				result =  cipher.doFinal(result);
				System.out.println("bc des decrypto :" + new String(result));
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
}
