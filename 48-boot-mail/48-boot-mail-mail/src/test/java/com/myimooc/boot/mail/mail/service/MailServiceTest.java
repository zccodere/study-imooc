package com.myimooc.boot.mail.mail.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * 邮件服务测试
 *
 * @author zc
 * @date 2018/09/08
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    /**
     * 收件邮箱地址
     */
    private static final String TO = "you mail address";

    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleMail() {
        this.mailService.sendSimpleMail(TO, "这是第一封邮件", "大家好，这是我的第一封邮件");
    }

    @Test
    public void sendHtmlMail() throws Exception {
        StringBuilder content = new StringBuilder(128);
        content.append("<html\n>");
        content.append("<body>\n");
        content.append("<h3> Hello World！这是一封Html邮件</h3>\n");
        content.append("</body>\n");
        content.append("</html>");
        this.mailService.sendHtmlMail(TO, "这是一封html邮件", content.toString());
    }

    @Test
    public void sendAttachmentsMail() throws Exception {
        String filePath = "d:\\48-boot-mail-hello.zip";
        this.mailService.sendAttachmentsMail(TO, "这是一封带附件的邮件", "这是一封带附件的邮件内容", new String[]{filePath});
    }

    @Test
    public void sendInlineResourceMail() {
        String rscPath = "d:\\thumb.jpg";
        String rscId = "img001";
        StringBuilder content = new StringBuilder(128);
        content.append("<html\n>");
        content.append("<body>\n");
        content.append("<h3> 这是有图片的邮件</h3>\n");
        content.append("<img src=\'cid:").append(rscId).append("\'></img>\n");
        content.append("<img src=\'cid:").append(rscId).append("\'></img>\n");
        content.append("</body>\n");
        content.append("</html>");
        this.mailService.sendInlineResourceMail(TO, "这是一封带图片的邮件", content.toString(), rscPath, rscId);
    }

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void sendTemplateMail() throws Exception {
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = this.templateEngine.process("emailTemplate", context);

        this.mailService.sendHtmlMail(TO, "这是一封模版邮件", emailContent);
    }
}
