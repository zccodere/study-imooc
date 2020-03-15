package com.myimooc.java.security.elgamal;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.spec.DHParameterSpec;

/**
 * ELGamal非对称加密演示
 *
 * @author zc 2017-04-13
 */
public class DemoElgamal {

    public static void main(String[] args) throws Exception {
        bcElgamal();
    }

    /**
     * 使用 BouncyCastle 实现 ELGamal 加解密
     */
    private static void bcElgamal() throws Exception {
        // 公钥加密，私钥解密
        Security.addProvider(new BouncyCastleProvider());

        // 1.初始化密钥
        AlgorithmParameterGenerator algorithmParameterGenerator = AlgorithmParameterGenerator.getInstance("ELGamal");
        algorithmParameterGenerator.init(256);
        AlgorithmParameters algorithmParameters = algorithmParameterGenerator.generateParameters();
        DHParameterSpec dhParameterSpec = algorithmParameters.getParameterSpec(DHParameterSpec.class);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ELGamal");
        keyPairGenerator.initialize(dhParameterSpec, new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("Public Key:" + Base64.encodeBase64String(publicKey.getEncoded()));
        System.out.println("Private Key:" + Base64.encodeBase64String(privateKey.getEncoded()));
    }
}
