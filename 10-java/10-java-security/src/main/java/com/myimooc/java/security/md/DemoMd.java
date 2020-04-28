package com.myimooc.java.security.md;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * MD消息摘要加密演示
 *
 * @author zc 2017-04-10
 */
public class DemoMd {

    /**
     * 待加密字符串
     */
    private static String src = "imooc security md";

    public static void main(String[] args) {
        jdkMd5();
        jdkMd2();
        bcMd4();
        bcMd5();
        ccMd5();
        ccMd2();
    }

    /**
     * 通过 jdk 实现MD5加密
     */
    private static void jdkMd5() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] md5Bytes = md.digest(src.getBytes());
            System.out.println("JDK MD5:" + Hex.encodeHexString(md5Bytes));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 jdk 实现MD2加密
     */
    private static void jdkMd2() {
        try {
            MessageDigest md = MessageDigest.getInstance("MD2");
            byte[] md2Bytes = md.digest(src.getBytes());
            System.out.println("JDK MD2:" + Hex.encodeHexString(md2Bytes));

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 bouncy castle 实现MD5加密
     */
    private static void bcMd5() {
        Digest digest = new MD5Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] md5Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(md5Bytes, 0);
        System.out.println("BC MD5:" + org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
    }

    /**
     * 通过 bouncy castle 实现MD4加密
     */
    private static void bcMd4() {
        try {
            Security.addProvider(new BouncyCastleProvider());
            MessageDigest md = MessageDigest.getInstance("MD4");
            byte[] md5Bytes = md.digest(src.getBytes());
            System.out.println("BC MD4:" + org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 commons codec 实现MD5加密
     */
    private static void ccMd5() {
        System.out.println("CC MD5:" + DigestUtils.md5Hex(src.getBytes()));
    }

    /**
     * 通过 commons codec 实现MD5加密
     */
    private static void ccMd2() {
        System.out.println("CC MD2:" + DigestUtils.md2Hex(src.getBytes()));
    }
}
