
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD2Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;

public class TestMD {

	private static String before = "jiamiqian md";
	
	public static void main(String[] args) {
		jdkMD5();           // JDK MD5:4d123caf7d2497d3320045615ecc1b54
		jdkMD2();			// JDK MD2:35b09f166aacb7c1d51ca7bbcd0ee775
		bcMD2();			// bc MD2:35b09f166aacb7c1d51ca7bbcd0ee775
		bcMD4();			//bc MD4:adbf8f9134f1d9d54681828f5b86ad6e
		bcMD5();			//bc MD5:4d123caf7d2497d3320045615ecc1b54
		ccMD5();			//cc MD5:4d123caf7d2497d3320045615ecc1b54
		ccMD2();			//cc MD2:35b09f166aacb7c1d51ca7bbcd0ee775
	
	}
	
	public static void jdkMD5(){
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] md5Bytes = md5.digest(before.getBytes());
			System.out.println("JDK MD5:" + Hex.encodeHexString(md5Bytes));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void jdkMD2(){
		try {
			MessageDigest md2 = MessageDigest.getInstance("MD2");
			byte[] md2Bytes = md2.digest(before.getBytes());
			System.out.println("JDK MD2:" + Hex.encodeHexString(md2Bytes));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void bcMD2(){
		Digest digest = new MD2Digest();
		digest.update(before.getBytes(), 0,  before.getBytes().length);
		byte[] md2Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md2Bytes, 0);
		System.out.println("bc MD2:" + org.bouncycastle.util.encoders.Hex.toHexString(md2Bytes));
	}
	
	
	public static void bcMD4(){
		Digest digest = new MD4Digest();
		digest.update(before.getBytes(), 0,  before.getBytes().length);
		byte[] md4Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md4Bytes, 0);
		System.out.println("bc MD4:" + org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes));
	}
	
	public static void bcMD5(){

		Digest digest = new MD5Digest();
		digest.update(before.getBytes(), 0,  before.getBytes().length);
		byte[] md5Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md5Bytes, 0);
		System.out.println("bc MD5:" + org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
	}
	
	public static void ccMD5(){
		System.out.println("cc MD5:" + DigestUtils.md5Hex(before.getBytes()));
	}
	
	public static void ccMD2(){
		System.out.println("cc MD2:" + DigestUtils.md2Hex(before.getBytes()));
	}
	
}
