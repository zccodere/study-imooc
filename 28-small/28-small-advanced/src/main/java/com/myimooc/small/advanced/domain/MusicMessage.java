package com.myimooc.small.advanced.domain;

/**
 * 音乐消息
 *
 * @author ZhangCheng on 2017-08-12
 */
public class MusicMessage extends BaseMessage {
    private Music music;

    public Music getMusic() {
        return music;
    }

    public void setMusic(Music music) {
        this.music = music;
    }
}
