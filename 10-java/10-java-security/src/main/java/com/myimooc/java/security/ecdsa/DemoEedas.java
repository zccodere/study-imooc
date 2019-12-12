package com.myimooc.java.security.ecdsa;

import org.apache.commons.codec.binary.Hex;

import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * <br>
 * 标题: ECDSA数字签名算法演示<br>
 * 描述: ECDSA数字签名算法演示<br>
 * 时间: 2017/04/13<br>
 *
 * @author zc
 */
public class DemoEedas {

    /** 待加密字符串 */
    private static String src="imooc security ecdsa";

    public static void main(String[] args)throws Exception{
        jdkECDSA();
    }

    /** 使用 JDK 实现 ECDSA 数字签名  */
    public static void jdkECDSA() throws Exception{

        // 1.初始化密钥
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
        keyPairGenerator.initialize(256);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        ECPublicKey ecPublicKey = (ECPublicKey)keyPair.getPublic();
        ECPrivateKey ecPrivateKey = (ECPrivateKey)keyPair.getPrivate();

        // 2.执行签名
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ecPrivateKey.getEncoded());
        KeyFactory keyFactory =  KeyFactory.getInstance("EC");
        PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
        Signature signature = Signature.getInstance("SHA1withECDSA");
        signature.initSign(privateKey);
        signature.update(src.getBytes());
        byte[] result = signature.sign();
        System.out.println("jdk ecdsa sign:"+ Hex.encodeHexString(result));

        // 3.验证签名
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ecPublicKey.getEncoded());
        keyFactory = KeyFactory.getInstance("EC");
        PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
        signature = Signature.getInstance("SHA1withECDSA");
        signature.initVerify(publicKey);
        signature.update(src.getBytes());
        boolean bool = signature.verify(result);
        System.out.println("jdk ecdsa verify:"+ bool);
    }

}
