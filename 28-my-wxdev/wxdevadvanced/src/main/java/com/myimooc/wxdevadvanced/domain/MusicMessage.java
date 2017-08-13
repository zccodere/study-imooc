package com.myimooc.wxdevadvanced.domain;

/**
 * 音乐消息
 * @author ZhangCheng on 2017-08-12
 *
 */
public class MusicMessage extends BaseMessage{
	private Music Music;

	public Music getMusic() {
		return Music;
	}

	public void setMusic(Music music) {
		Music = music;
	}
}
