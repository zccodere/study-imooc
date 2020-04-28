package com.myimooc.java.security.sha;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.Security;

/**
 * SHA消息摘要加密演示
 *
 * @author zc 2017-04-10
 */
public class DemoSha {

    /**
     * 待加密字符串
     */
    private static String src = "imooc security sha";

    public static void main(String[] args) {
        jdkSha1();
        bcSha1();
        bcSha224();
        bcSha2242();
        ccSha1();
    }

    /**
     * 通过 JDK 实现SHA-1 加密
     */
    private static void jdkSha1() {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA");
            md.update(src.getBytes());
            System.out.println("jdk sha-1:" + Hex.encodeHexString(md.digest()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 bouncy castle 实现SHA-1 加密
     */
    private static void bcSha1() {
        Digest digest = new SHA1Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] sha1Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha1Bytes, 0);
        System.out.println("bc sha-1:" + org.bouncycastle.util.encoders.Hex.toHexString(sha1Bytes));
    }

    /**
     * 通过 bouncy castle 实现SHA-224 加密
     */
    private static void bcSha224() {
        Digest digest = new SHA224Digest();
        digest.update(src.getBytes(), 0, src.getBytes().length);
        byte[] sha224Bytes = new byte[digest.getDigestSize()];
        digest.doFinal(sha224Bytes, 0);
        System.out.println("bc sha-224:" + org.bouncycastle.util.encoders.Hex.toHexString(sha224Bytes));
    }

    /**
     * 通过 provider 实现SHA224加密
     */
    private static void bcSha2242() {
        Security.addProvider(new BouncyCastleProvider());
        try {
            MessageDigest md = MessageDigest.getInstance("SHA224");
            byte[] sha224Bytes = md.digest(src.getBytes());
            System.out.println("sha-224:" + org.bouncycastle.util.encoders.Hex.toHexString(sha224Bytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过 commons.codec 实现SHA-1加密
     */
    private static void ccSha1() {
        System.out.println("cc sha1-1:" + DigestUtils.sha1Hex(src.getBytes()));
        System.out.println("cc sha1-2:" + DigestUtils.sha1Hex(src));
    }
}
