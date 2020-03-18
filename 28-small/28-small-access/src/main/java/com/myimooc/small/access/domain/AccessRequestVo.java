package com.myimooc.small.access.domain;

/**
 * 服务器验证请求Vo
 *
 * @author zc 2017-08-11
 */
public class AccessRequestVo {

    /**
     * 签名
     */
    private String signature;
    /**
     * 时间戳
     */
    private String timestamp;

    private String nonce;

    private String echostr;

    @Override
    public String toString() {
        return "AccessRequestVo [signature=" + signature + ", timestamp=" + timestamp + ", nonce=" + nonce + ", echostr="
                + echostr + "]";
    }

    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getNonce() {
        return nonce;
    }

    public void setNonce(String nonce) {
        this.nonce = nonce;
    }

    public String getEchostr() {
        return echostr;
    }

    public void setEchostr(String echostr) {
        this.echostr = echostr;
    }
}
