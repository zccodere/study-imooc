package com.myimooc.small.advanced.rest;

import com.myimooc.small.advanced.domain.EventMessage;
import com.myimooc.small.advanced.domain.TextMessage;
import com.myimooc.small.advanced.util.MessageUtils;
import com.myimooc.small.advanced.util.WeiXinUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

/**
 * 处理消息请求与响应
 *
 * @author zc 2017-08-11
 */
@RestController
public class MessageRest {

    private static final Logger logger = LoggerFactory.getLogger(MessageRest.class);
    private static final String KEY_1 = "1";
    private static final String KEY_2 = "2";
    private static final String KEY_3 = "3";
    private static final String KEY_FY = "翻译";
    private static final String KEY_MENU_CN = "？";
    private static final String KEY_MENU_EN = "?";

    /**
     * 接收微信服务器发送的POST请求
     */
    @PostMapping("textmessage")
    public Object textMessage(TextMessage msg) throws Exception {

        logger.info("请求参数：{}", msg.toString());

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
                return MessageUtils.initNewsMessage(msg.getToUserName(), msg.getFromUserName());
            }
            // 关键字 3
            if (Objects.equals(KEY_3, msg.getContent())) {
                textMessage = MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), MessageUtils.threeMenu());
                return textMessage;
            }
            // 关键字 翻译
            if (msg.getContent().startsWith(KEY_FY)) {
                String word = msg.getContent().replaceAll("^翻译", "").trim();
                if ("".equals(word)) {
                    textMessage = MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), MessageUtils.threeMenu());
                    return textMessage;
                }
                textMessage = MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), WeiXinUtils.translate(word));
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
            textMessage.setCreateTime(System.currentTimeMillis() + "");
            textMessage.setContent("您发送的消息是：" + msg.getContent());
            return textMessage;
        }
        return null;
    }

    /**
     * 接收微信服务器发送的POST请求
     */
    @PostMapping("eventmessage")
    public Object eventMessage(Map<String, String> param) {

        EventMessage msg = new EventMessage();
        BeanUtils.copyProperties(param, msg);
        // 事件推送
        if (Objects.equals(MessageUtils.MESSAGE_EVENT, msg.getMsgType())) {
            // 关注
            if (Objects.equals(MessageUtils.MESSAGE_SUBSCRIBE, msg.getEvent())) {
                TextMessage text = new TextMessage();
                text = MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), MessageUtils.menuText());
                return text;
            }
            // 菜单 点击类型
            if (Objects.equals(MessageUtils.MESSAGE_CLICK, msg.getEvent())) {
                TextMessage text = new TextMessage();
                text = MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), MessageUtils.menuText());
                return text;
            }
            // 菜单 视图类型
            if (Objects.equals(MessageUtils.MESSAGE_VIEW, msg.getEvent())) {
                String url = param.get("EventKey");
                return MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), url);
            }
            // 菜单 扫码事件
            if (Objects.equals(MessageUtils.MESSAGE_SCANCODE, msg.getEvent())) {
                String key = param.get("EventKey");
                return MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), key);
            }
            // 菜单 地理位置
            if (Objects.equals(MessageUtils.MESSAGE_LOCATION, msg.getEvent())) {
                String label = param.get("Label");
                return MessageUtils.initText(msg.getToUserName(), msg.getFromUserName(), label);
            }
        }
        return "no message";
    }

}
