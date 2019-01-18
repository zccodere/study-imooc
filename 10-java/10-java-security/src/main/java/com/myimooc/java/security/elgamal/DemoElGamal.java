package com.myimooc.java.security.elgamal;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.Cipher;
import javax.crypto.spec.DHParameterSpec;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * <br>
 * 标题: ELGamal非对称加密演示<br>
 * 描述: ELGamal非对称加密演示<br>
 * 时间: 2017/04/13<br>
 *
 * @author zc
 */
public class DemoElGamal {

    /** 待加密字符串 */
    private static String src="imooc security elgamal";

    public static void main(String[] args)throws Exception{
        bcELGamal();
    }

    /** 使用 BouncyCastle 实现 ELGamal 加解密 */
    public static void bcELGamal()throws Exception{
        // 公钥加密，私钥解密
        Security.addProvider(new BouncyCastleProvider());

        // 1.初始化密钥
        AlgorithmParameterGenerator algorithmParameterGenerator = AlgorithmParameterGenerator.getInstance("ELGamal");
        algorithmParameterGenerator.init(256);
        AlgorithmParameters algorithmParameters = algorithmParameterGenerator.generateParameters();
        DHParameterSpec dhParameterSpec = (DHParameterSpec) algorithmParameters.getParameterSpec(DHParameterSpec.class);
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ELGamal");
        keyPairGenerator.initialize(dhParameterSpec,new SecureRandom());
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();
        System.out.println("Public Key:"+ Base64.encodeBase64String(publicKey.getEncoded()));
        System.out.println("Private Key:"+ Base64.encodeBase64String(privateKey.getEncoded()));

    }

}
