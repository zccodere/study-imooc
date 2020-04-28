package com.myimooc.java.security.des;

import org.apache.commons.codec.binary.Hex;

import java.security.Key;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESedeKeySpec;

/**
 * 3DES对称加密演示
 *
 * @author zc 2017-04-11
 */
public class Demo3Des {

    public static void main(String[] args) throws Exception {
        jdk3des();
    }

    /**
     * 使用jdk实现3重DES加解密
     */
    private static void jdk3des() throws Exception {
        // 生成KEY
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DESede");
        keyGenerator.init(new SecureRandom());
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] byteKey = secretKey.getEncoded();

        // KEY转换
        DESedeKeySpec desKeySpec = new DESedeKeySpec(byteKey);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DESede");
        Key convertSecretKey = secretKeyFactory.generateSecret(desKeySpec);

        // 加密
        Cipher cipher = Cipher.getInstance("DESede/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);

        // 待加密字符串
        String src = "imooc security 3des";
        byte[] result = cipher.doFinal(src.getBytes());

        System.out.println("jdk 3des encrypt:" + Hex.encodeHexString(result));

        // 解密
        cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
        result = cipher.doFinal(result);
        System.out.println("jdk 3des decrypt:" + new String(result));
    }
}
