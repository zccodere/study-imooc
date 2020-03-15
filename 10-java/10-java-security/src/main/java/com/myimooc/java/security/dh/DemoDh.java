package com.myimooc.java.security.dh;

import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

/**
 * DH非对称加密演示
 *
 * @author zc 2017-04-12
 */
public class DemoDh {

    public static void main(String[] args) throws Exception {
        jdkDh();
    }

    /**
     * 使用jdk实现DH非对称加密
     */
    private static void jdkDh() throws Exception {
        // 1.初始化发送方密钥
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DH");
        keyPairGenerator.initialize(512);
        KeyPair senderKerPair = keyPairGenerator.generateKeyPair();
        // 发送方公钥，发送给接收方（网络、文件...）
        byte[] senderPublicKeyEnc = senderKerPair.getPublic().getEncoded();

        // 2.初始化接收方密钥
        KeyFactory receiverKeyFactory = KeyFactory.getInstance("DH");
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(senderPublicKeyEnc);
        PublicKey receiverPublicKey = receiverKeyFactory.generatePublic(x509EncodedKeySpec);
        DHParameterSpec dhParameterSpec = ((DHPublicKey) receiverPublicKey).getParams();
        KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator.getInstance("DH");
        receiverKeyPairGenerator.initialize(dhParameterSpec);
        KeyPair receiverKeyPair = receiverKeyPairGenerator.generateKeyPair();
        PrivateKey receiverPrivateKey = receiverKeyPair.getPrivate();
        byte[] receiverPublicKeyEnc = receiverKeyPair.getPublic().getEncoded();

        // 3.密钥构建
        KeyAgreement receiverKeyAgreement = KeyAgreement.getInstance("DH");
        receiverKeyAgreement.init(receiverPrivateKey);
        receiverKeyAgreement.doPhase(receiverPublicKey, true);
        SecretKey receiverDesKey = receiverKeyAgreement.generateSecret("DES");

        KeyFactory senderKeyFactory = KeyFactory.getInstance("DH");
        x509EncodedKeySpec = new X509EncodedKeySpec(receiverPublicKeyEnc);
        PublicKey senderPublicKey = senderKeyFactory.generatePublic(x509EncodedKeySpec);
        KeyAgreement senderKeyAgreement = KeyAgreement.getInstance("DH");
        senderKeyAgreement.init(senderKerPair.getPrivate());
        senderKeyAgreement.doPhase(senderPublicKey, true);

        SecretKey senderDesKey = senderKeyAgreement.generateSecret("DES");

        // 4.加密
        Cipher cipher = Cipher.getInstance("DES");
        cipher.init(Cipher.ENCRYPT_MODE, senderDesKey);

        // 待加密字符串
        String src = "imooc security dh";
        byte[] result = cipher.doFinal(src.getBytes());
        System.out.println("jdk dh encrypt:" + Base64.encodeBase64String(result));

        // 5.解密
        cipher.init(Cipher.DECRYPT_MODE, receiverDesKey);
        result = cipher.doFinal(result);
        System.out.println("jdk dh decrypt:" + new String(result));
    }
}
