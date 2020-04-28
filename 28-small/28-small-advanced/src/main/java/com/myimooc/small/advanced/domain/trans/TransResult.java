package com.myimooc.small.advanced.domain.trans;

/**
 * 百度翻译API
 *
 * @author zc 2017-08-12
 */
public class TransResult {

    private String from;
    private String to;
    private Data data;
    private String errno;

    @Override
    public String toString() {
        return "TransResult{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", data=" + data +
                ", errno='" + errno + '\'' +
                '}';
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getErrno() {
        return errno;
    }

    public void setErrno(String errno) {
        this.errno = errno;
    }
}
