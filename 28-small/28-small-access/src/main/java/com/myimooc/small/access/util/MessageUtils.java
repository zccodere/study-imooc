package com.myimooc.small.access.util;

import com.myimooc.small.access.domain.TextMessage;

/**
 * 消息类型及工具类
 *
 * @author zc 2017-08-11
 */
public class MessageUtils {

    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";

    public static TextMessage initText(String toUserName, String fromUserName, String content) {
        TextMessage text = new TextMessage();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(MessageUtils.MESSAGE_TEXT);
        text.setCreateTime(System.currentTimeMillis());
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
                "回复？调出此菜单。";
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
}
