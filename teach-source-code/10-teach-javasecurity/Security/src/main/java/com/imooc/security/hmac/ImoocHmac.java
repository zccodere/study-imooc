package com.imooc.security.hmac;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

public class ImoocHmac {
	
	private static String src = "imooc security hmac";

	public static void main(String[] args) {
		 jdkHmacMD5();
		 bcHmacMD5();
	}
	
	public static void jdkHmacMD5() {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");//初始化KeyGenerator
			SecretKey secretKey = keyGenerator.generateKey();//产生密钥
//			byte[] key = secretKey.getEncoded();//获得密钥
			byte[] key = Hex.decodeHex(new char[] {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'});
			
			SecretKey restoreSecretKey = new SecretKeySpec(key, "HmacMD5");//还原密钥
			Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());//实例化MAC
			mac.init(restoreSecretKey);//初始化Mac
			byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());//执行摘要
			System.out.println("jdk hmacMD5 : " + Hex.encodeHexString(hmacMD5Bytes));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void bcHmacMD5() {
		HMac hmac = new HMac(new MD5Digest());
		hmac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa")));
		hmac.update(src.getBytes(), 0, src.getBytes().length);
		
		byte[] hmacMD5Bytes = new byte[hmac.getMacSize()];//执行摘要
		hmac.doFinal(hmacMD5Bytes, 0);
		
		System.out.println("bc hmacMD5 : " + org.bouncycastle.util.encoders.Hex.toHexString(hmacMD5Bytes));
		
	}

}
