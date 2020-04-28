package com.myimooc.java.security.mac;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * MAC消息摘要加密演示
 *
 * @author zc 2014-04-11
 */
public class DemoMac {

    /**
     * 待加密字符串
     */
    private static String src = "imooc security mac";

    public static void main(String[] args) throws Exception {
        jdkHmacMd5();
        bcHmacMd5();
    }

    /**
     * jdk实现hmac MD5摘要算法
     */
    private static void jdkHmacMd5() throws Exception {
        // 自定义密钥
        byte[] key = Hex.decodeHex(new char[]{'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'});

        // 还原密钥
        SecretKey restoreSecretKey = new SecretKeySpec(key, "HmacMD5");
        // 实例化 MAC
        Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());
        // 初始化 MAC
        mac.init(restoreSecretKey);
        // 执行摘要
        byte[] hmacMd5Bytes = mac.doFinal(src.getBytes());
        System.out.println("jdk hmacMD5:" + Hex.encodeHexString(hmacMd5Bytes));
    }

    /**
     * Bouncy Castle crypto实现hmacMD5加密
     */
    private static void bcHmacMd5() {
        byte[] bytes = {'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a', 'a'};
        HMac hmac = new HMac(new MD5Digest());
        hmac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode(bytes)));
        hmac.update(src.getBytes(), 0, src.getBytes().length);
        // 执行摘要
        byte[] hmacMd5Bytes = new byte[hmac.getMacSize()];
        hmac.doFinal(hmacMd5Bytes, 0);
        System.out.println("bc hmacMD5:" + org.bouncycastle.util.encoders.Hex.toHexString(hmacMd5Bytes));
    }
}
