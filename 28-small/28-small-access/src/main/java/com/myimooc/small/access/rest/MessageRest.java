package com.myimooc.small.access.rest;

import com.myimooc.small.access.domain.EventMessage;
import com.myimooc.small.access.domain.TextMessage;
import com.myimooc.small.access.util.MessageUtils;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

/**
 * 处理消息请求与响应
 *
 * @author zc 2017-08-11
 */
@RestController
public class MessageRest {

    private static final String KEY_1 = "1";
    private static final String KEY_2 = "2";
    private static final String KEY_MENU_CN = "？";
    private static final String KEY_MENU_EN = "?";

    /**
     * 接收微信服务器发送的POST请求
     */
    @PostMapping("textmessage")
    public Object textMessage(TextMessage msg) {
        // 文本消息
        if (Objects.equals(MessageUtils.MESSAGE_TEXT, msg.getMsgType())) {
            TextMessage textMessage = new TextMessage();
            // 关键字 1
            if (Objects.equals(KEY_1, msg.getContent())) {
                textMessage = MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), MessageUtils.firstMenu());
                return textMessage;
            }
            // 关键字 2
            if (Objects.equals(KEY_2, msg.getContent())) {
                textMessage = MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), MessageUtils.secondMenu());
                return textMessage;
            }
            // 关键字 ？? 调出菜单
            if (Objects.equals(KEY_MENU_CN, msg.getContent()) || Objects.equals(KEY_MENU_EN, msg.getContent())) {
                textMessage = MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), MessageUtils.menuText());
                return textMessage;
            }

            // 非关键字
            textMessage.setFromUserName(msg.getToUserName());
            textMessage.setToUserName(msg.getFromUserName());
            textMessage.setMsgType(MessageUtils.MESSAGE_TEXT);
            textMessage.setCreateTime(System.currentTimeMillis());
            textMessage.setContent("您发送的消息是：" + msg.getContent());
            return textMessage;
        }
        return null;
    }

    /**
     * 接收微信服务器发送的POST请求
     */
    @PostMapping("eventmessage")
    public Object eventMessage(EventMessage msg) {
        // 事件推送
        if (Objects.equals(MessageUtils.MESSAGE_EVENT, msg.getMsgType())) {
            // 关注
            if (Objects.equals(MessageUtils.MESSAGE_SUBSCRIBE, msg.getEvent())) {
                return MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), MessageUtils.menuText());
            }
        }
        return null;
    }
}
