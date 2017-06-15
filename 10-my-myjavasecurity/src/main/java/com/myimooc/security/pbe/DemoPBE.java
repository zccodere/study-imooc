package com.myimooc.security.pbe;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * /**
 * /**
 * PBE对称加密演示
 * Created by ZC on 2017/4/11.
 */
public class DemoPBE {
    /** 待加密字符串 */
    private static String src="imooc security pbe";

    private static final String TOKEN = "imooc";

    public static void main(String[] args){
        jdkPBE();
    }

    /** 使用JDK实现PBE算法加解密 */
    public static void jdkPBE(){
        try{
            // 初始化盐
            SecureRandom random = new SecureRandom();
            byte[] salt = random.generateSeed(8);

            // 口令与密钥
            String password = TOKEN;
            PBEKeySpec pbeKeySpec = new PBEKeySpec(password.toCharArray());
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBEWITHMD5andDES");
            Key key = factory.generateSecret(pbeKeySpec);

            // 加密
            PBEParameterSpec pbeParameterSpec = new PBEParameterSpec(salt,100);
            Cipher cipher = Cipher.getInstance("PBEWITHMD5andDES");
            cipher.init(Cipher.ENCRYPT_MODE,key,pbeParameterSpec);
            byte[] result = cipher.doFinal(src.getBytes());
            System.out.println("jdk pbe encrypt:"+ Base64.encodeBase64String(result));

            // 解密
            cipher.init(Cipher.DECRYPT_MODE,key,pbeParameterSpec);
            result = cipher.doFinal(result);
            System.out.println("jdk pbe decrypt:"+ Base64.encodeBase64String(result));

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
