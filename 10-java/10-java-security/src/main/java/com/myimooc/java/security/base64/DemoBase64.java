package com.myimooc.java.security.base64;

import org.apache.commons.codec.binary.Base64;

/**
 * Base64加密演示
 *
 * @author zc 2017-04-13
 */
public class DemoBase64 {

    /**
     * 待加密字符串
     */
    private static String src = "imooc security base64";

    public static void main(String[] args) {
        jdkBase64();
        commonsCodesBase64();
        bouncyCastleBase64();
    }

    /**
     * 通过JDK实现Base64加密
     */
    private static void jdkBase64() {
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        String encode = new String(encoder.encode(src.getBytes()));
        System.out.println("encode:" + encode);

        java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        System.out.println("decode:" + new String(decoder.decode(encode)));
    }

    /**
     * 通过commons codec实现Base64加密
     */
    private static void commonsCodesBase64() {
        byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
        System.out.println("encode:" + new String(encodeBytes));

        byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
        System.out.println("decode:" + new String(decodeBytes));
    }

    /**
     * 通过Bouncy Castle实现Base64加密
     */
    private static void bouncyCastleBase64() {
        byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
        System.out.println("encode:" + new String(encodeBytes));

        byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
        System.out.println("decode:" + new String(decodeBytes));
    }

}
