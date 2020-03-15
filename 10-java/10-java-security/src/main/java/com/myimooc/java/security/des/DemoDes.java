package com.myimooc.java.security.des;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Key;
import java.security.Security;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

/**
 * DES对称加密演示
 *
 * @author zc 2017-04-11
 */
public class DemoDes {

    public static void main(String[] args) throws Exception {
        jdkDes();
        bcDes();
    }

    /**
     * 使用 jdk 实现des加解密
     */
    private static void jdkDes() throws Exception {
        // 生成KEY
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
        doDes(keyGenerator, "jdk");
    }

    /**
     * 使用BouncyCastle实现DES加解密
     */
    private static void bcDes() throws Exception {
        Security.addProvider(new BouncyCastleProvider());
        // 生成KEY
        KeyGenerator keyGenerator = KeyGenerator.getInstance("DES", "BC");
        doDes(keyGenerator, "bc");
    }

    private static void doDes(KeyGenerator keyGenerator, String type) throws Exception {
        keyGenerator.init(56);
        SecretKey secretKey = keyGenerator.generateKey();
        byte[] byteKey = secretKey.getEncoded();

        // KEY转换
        DESKeySpec desKeySpec = new DESKeySpec(byteKey);
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");
        Key convertSecretKey = secretKeyFactory.generateSecret(desKeySpec);

        // 加密
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, convertSecretKey);

        // 待加密字符串
        String src = "imooc security des";
        byte[] result = cipher.doFinal(src.getBytes());

        System.out.println(type + " des encrypt:" + Hex.encodeHexString(result));

        // 解密
        cipher.init(Cipher.DECRYPT_MODE, convertSecretKey);
        result = cipher.doFinal(result);
        System.out.println(type + " des decrypt:" + new String(result));
    }
}
