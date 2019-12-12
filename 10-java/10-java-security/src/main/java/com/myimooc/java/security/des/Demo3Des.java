package com.myimooc.java.security.des;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.DESedeKeySpec;
import java.security.Key;
import java.security.SecureRandom;

/**
 * <br>
 * 标题: 3DES对称加密演示<br>
 * 描述: 3DES对称加密演示<br>
 * 时间: 2017/04/11<br>
 *
 * @author zc
 */
public class Demo3Des {

    /** 待加密字符串 */
    private static String src="imooc security 3des";

    public static void main(String[] args){
        jdk3des();
    }

    /** 使用jdk实现3重DES加解密 */
    private static void jdk3des(){
        try {
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
            cipher.init(Cipher.ENCRYPT_MODE,convertSecretKey);
            byte[] result = cipher.doFinal(src.getBytes());

            System.out.println("jdk 3des encrypt:"+ Hex.encodeHexString(result));

            // 解密
            cipher.init(Cipher.DECRYPT_MODE,convertSecretKey);
            result = cipher.doFinal(result);
            System.out.println("jdk 3des decrypt:"+ new String(result));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
