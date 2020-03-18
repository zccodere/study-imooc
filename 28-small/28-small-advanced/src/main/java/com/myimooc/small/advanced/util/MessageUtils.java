package com.myimooc.small.advanced.util;

import com.myimooc.small.advanced.domain.Image;
import com.myimooc.small.advanced.domain.ImageMessage;
import com.myimooc.small.advanced.domain.Music;
import com.myimooc.small.advanced.domain.MusicMessage;
import com.myimooc.small.advanced.domain.News;
import com.myimooc.small.advanced.domain.NewsMessage;
import com.myimooc.small.advanced.domain.TextMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * 消息类型及工具类
 *
 * @author zc 2017-08-11
 */
public class MessageUtils {

    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_NEWS = "news";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_MUSIC = "music";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";
    public static final String MESSAGE_SCANCODE = "scancode_push";

    public static TextMessage initText(String toUserName, String fromUserName, String content) {
        TextMessage text = new TextMessage();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(MessageUtils.MESSAGE_TEXT);
        text.setCreateTime(System.currentTimeMillis() + "");
        text.setContent(content);
        return text;
    }

    /**
     * 主菜单
     */
    public static String menuText() {
        return "欢迎您的关注，请按照菜单提升进行操作：\n\n" +
                "1、课程介绍\n\n" +
                "2、慕课网介绍\n\n" +
                "3、词组翻译\n\n" +
                "回复？显示主菜单。";
    }

    public static String firstMenu() {
        return "本套课程介绍微信公众号开发，主要涉及公众号介绍、编辑模式介绍、开发模式介绍等。";
    }

    public static String secondMenu() {
        return "慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、"
                + "问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公"
                + "开视频课程学习国内领先的互联网IT技术。"
                + "慕课网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，"
                + "包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。"
                + "以纯干货、短视频的形式为平台特点，为在校学生、职场白领提供了一个迅速提升技能、共同分享进步的学习平台。";
    }

    public static String threeMenu() {
        StringBuffer sb = new StringBuffer();
        sb.append("词组翻译使用指南\n");
        sb.append("使用示例：\n");
        sb.append("翻译足球：\n");
        sb.append("翻译中国足球\n");
        sb.append("翻译football\n\n");
        sb.append("回复？显示主菜单。");
        return sb.toString();
    }

    /**
     * 图文消息的组装
     */
    public static NewsMessage initNewsMessage(String toUserNmae, String fromUserName) {
        List<News> newsList = new ArrayList<News>();
        NewsMessage newsMessage = new NewsMessage();

        News news = new News();
        news.setTitle("慕课网介绍");
        news.setDescription("慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、"
                + "问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，也可以通过免费的在线公"
                + "开视频课程学习国内领先的互联网IT技术。"
                + "慕课网课程涵盖前端开发、PHP、Html5、Android、iOS、Swift等IT前沿技术语言，"
                + "包括基础课程、实用案例、高级分享三大类型，适合不同阶段的学习人群。"
                + "以纯干货、短视频的形式为平台特点，为在校学生、职场白领提供了一个迅速提升技能、共同分享进步的学习平台。");
        news.setPicUrl("http://imooc.jpg");
        news.setUrl("www.imooc.com");
        newsList.add(news);

        newsMessage.setToUserName(fromUserName);
        newsMessage.setFromUserName(toUserNmae);
        newsMessage.setCreateTime(System.currentTimeMillis() + "");
        newsMessage.setMsgType(MESSAGE_NEWS);
        newsMessage.setArticles(newsList);
        newsMessage.setArticleCount(newsList.size());
        return newsMessage;
    }

    /**
     * 图片消息组装
     */
    public static ImageMessage initImageMessage(String toUserName, String fromUserName) {
        Image image = new Image();
        image.setMediaId("JTH8vBl0zDRlrrn2bBnMleySuHjVbMhyAo0U2x7kQyd1ciydhhsVPONbnRrKGp8m");
        ImageMessage imageMessage = new ImageMessage();
        imageMessage.setFromUserName(toUserName);
        imageMessage.setToUserName(fromUserName);
        imageMessage.setMsgType(MESSAGE_IMAGE);
        imageMessage.setCreateTime(System.currentTimeMillis() + "");
        imageMessage.setImage(image);
        return imageMessage;
    }

    /**
     * 组装音乐消息
     */
    public static MusicMessage initMusicMessage(String toUserName, String fromUserName) {
        Music music = new Music();
        music.setThumbMediaId("WsHCQr1ftJQwmGUGhCP8gZ13a77XVg5Ah_uHPHVEAQuRE5FEjn-DsZJzFZqZFeFk");
        music.setTitle("see you again");
        music.setDescription("速7片尾曲");
        music.setMusicUrl("http://zapper.tunnel.mobi/Weixin/resource/See You Again.mp3");
        music.setHqMusicUrl("http://zapper.tunnel.mobi/Weixin/resource/See You Again.mp3");

        MusicMessage musicMessage = new MusicMessage();
        musicMessage.setFromUserName(toUserName);
        musicMessage.setToUserName(fromUserName);
        musicMessage.setMsgType(MESSAGE_MUSIC);
        musicMessage.setCreateTime(System.currentTimeMillis() + "");
        musicMessage.setMusic(music);
        return musicMessage;
    }
}
