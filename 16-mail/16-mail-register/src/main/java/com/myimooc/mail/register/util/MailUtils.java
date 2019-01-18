package com.myimooc.mail.register.util;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

/**
 * <br>
 * 标题: 邮件发送工具类<br>
 * 描述: 邮件发送工具类<br>
 * 时间: 2017/06/07<br>
 *
 * @author zc
 */
public class MailUtils {
    
    /**
     * 发送邮件的方法
     * @param to 收件人邮箱地址
     * @param code 邮件的激活码
     */
    public static void sendMail(String to,String code) throws Exception{
        // 1.创建连接对象，连接到邮箱服务器
        Properties props = new Properties();
        
        Session session = Session.getInstance(props, new Authenticator() {

            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("service@zccoder.com", "123");
            }
        });
        
        // 2.创建邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人
        message.setFrom(new InternetAddress("service@zccoder.com"));
        // 设置收件人
        message.setRecipient(RecipientType.TO, new InternetAddress(to));
        // 设置邮件主题
        message.setSubject("来自zccoder的账号激活邮件");
        // 设置邮件的正文
        message.setContent("<h1>来自zccoder的账号激活邮件，激活请点击一下链接：</h1><h3><a href='http://localhost:8080/regist/active?code="+code+"'>http://localhost:8080/regist/active?code="+code+"</h3>", "text/html;charset=UTF-8");
        
        // 3.发送一封激活邮件
        Transport.send(message);
    }

}
