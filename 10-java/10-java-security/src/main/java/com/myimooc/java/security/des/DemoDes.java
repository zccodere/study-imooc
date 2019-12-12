package com.myimooc.java.security.des;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * <br>
 * 标题: DES对称加密演示<br>
 * 描述: DES对称加密演示<br>
 * 时间: 2017/04/11<br>
 *
 * @author zc
 */
public class DemoDes {
    /** 待加密字符串 */
    private static String src="imooc security des";

    public static void main(String[] args){
        jdkDES();
        bcDES();
    }

    /** 使用 jdk 实现des加解密 */
    public static void jdkDES(){
        try {
            // 生成KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] byteKey = secretKey.getEncoded();

            // KEY转换
            DESKeySpec desKeySpec = new DESKeySpec(byteKey);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            Key convertSecretKey = secretKeyFactory.generateSecret(desKeySpec);

            // 加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,convertSecretKey);
            byte[] result = cipher.doFinal(src.getBytes());

            System.out.println("jdk des encrypt:"+ Hex.encodeHexString(result));

            // 解密
            cipher.init(Cipher.DECRYPT_MODE,convertSecretKey);
            result = cipher.doFinal(result);
            System.out.println("jdk des decrypt:"+ new String(result));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** 使用BouncyCastle实现DES加解密 */
    public static void bcDES(){
        try {
            Security.addProvider(new BouncyCastleProvider());

            // 生成KEY
            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES","BC");
            keyGenerator.init(56);
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] byteKey = secretKey.getEncoded();

            // KEY转换
            DESKeySpec desKeySpec = new DESKeySpec(byteKey);
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
            Key convertSecretKey = secretKeyFactory.generateSecret(desKeySpec);

            // 加密
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE,convertSecretKey);
            byte[] result = cipher.doFinal(src.getBytes());

            System.out.println("jdk des encrypt:"+ Hex.encodeHexString(result));

            // 解密
            cipher.init(Cipher.DECRYPT_MODE,convertSecretKey);
            result = cipher.doFinal(result);
            System.out.println("jdk des decrypt:"+ new String(result));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
