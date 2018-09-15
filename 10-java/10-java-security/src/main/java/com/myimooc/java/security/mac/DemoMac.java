package com.myimooc.java.security.mac;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;

/**
 * <br>
 * 标题: MAC消息摘要加密演示<br>
 * 描述: MAC消息摘要加密演示<br>
 * 时间: 2017/04/11<br>
 *
 * @author zc
 */
public class DemoMac {

    /** 待加密字符串 */
    private static String src="imooc security mac";

    public static void main(String[] args){
        jdkHmacDM5();
        bcHmacMD5();
    }

    /** jdk实现hmac MD5摘要算法 */
    public static void jdkHmacDM5(){
        try {
            // 初始化 KeyGenerator
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
            // 产生密钥
            SecretKey secretKey = keyGenerator.generateKey();
            // 获得密钥
            byte[] key1 = secretKey.getEncoded();

            // 自定义密钥
            byte[] key = Hex.decodeHex(new char[]{'a','a','a','a','a','a','a','a','a','a'});

            // 还原密钥
            SecretKey restoreSecretKey = new SecretKeySpec(key,"HmacMD5");
            // 实例化 MAC
            Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
            // 初始化 MAC
            mac.init(restoreSecretKey);
            // 执行摘要
            byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());
            System.out.println("jdk hmacMD5:"+ Hex.encodeHexString(hmacMD5Bytes));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** bouncycastle.crypto实现hmacMD5加密 */
    public static void bcHmacMD5(){
        HMac hmac = new HMac(new MD5Digest());
        hmac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa")));
        hmac.update(src.getBytes(),0,src.getBytes().length);
        // 执行摘要
        byte[] hmacMD5Bytes = new byte[hmac.getMacSize()];
        hmac.doFinal(hmacMD5Bytes,0);

        System.out.println("bc hmacMD5:"+ org.bouncycastle.util.encoders.Hex.toHexString(hmacMD5Bytes));
    }

}
