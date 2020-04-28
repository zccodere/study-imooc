package com.myimooc.boot.mail.mail.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 * 邮件服务
 *
 * @author zc
 * @date 2018/09/08
 */
@Service
public class MailService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 发送人
     */
    @Value("${spring.mail.username}")
    private String from;
    /**
     * 注入JavaMailSender
     */
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 发送文本邮件
     *
     * @param to      收件邮箱地址
     * @param subject 主题
     * @param content 内容
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        message.setFrom(from);
        this.mailSender.send(message);
    }

    /**
     * 发送html邮件
     *
     * @param to      收件邮箱地址
     * @param subject 主题
     * @param content 内容
     * @throws Exception 异常
     */
    public void sendHtmlMail(String to, String subject, String content) throws Exception {
        MimeMessage message = this.mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        helper.setFrom(from);
        this.mailSender.send(message);
    }

    /**
     * 发送附件邮件
     *
     * @param to        收件邮箱地址
     * @param subject   主题
     * @param content   内容
     * @param filePaths 文件路径
     * @throws Exception 异常
     */
    public void sendAttachmentsMail(String to, String subject, String content, String[] filePaths) throws Exception {
        MimeMessage message = this.mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(content, true);

        FileSystemResource file;
        for (String filePath : filePaths) {
            file = new FileSystemResource(new File(filePath));
            String fileName = file.getFilename();
            helper.addAttachment(fileName, file);
        }

        helper.setFrom(from);
        this.mailSender.send(message);
    }

    /**
     * 发送图片邮件
     *
     * @param to      收件邮箱地址
     * @param subject 主题
     * @param content 内容
     * @param rscPath 图片路径
     * @param rscId   图片ID
     */
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId) {
        logger.info("发送图片邮件开始：{}，{}，{}，{}，{}", to, subject, content, rscPath, rscId);
        MimeMessage message = this.mailSender.createMimeMessage();
        MimeMessageHelper helper;
        try {
            helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, file);

            helper.setFrom(from);
            this.mailSender.send(message);
            logger.info("发送图片邮件成功！");
        } catch (MessagingException ex) {
            logger.error("发送图片邮件异常：", ex);
        }
    }
}
