package com.myimooc.small.advanced.domain;

/**
 * 音乐消息
 *
 * @author zc 2017-08-12
 */
public class MusicMessage extends BaseMessage {

    private Music music;

    @Override
    public String toString() {
        return super.toString() + "MusicMessage{" +
                "music=" + music +
                '}';
    }

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
