package com.java.ting.application.utils;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Map;

/**
 * 发送邮件
 */
public class EmailUtil {
    @Autowired
    private JavaMailSender mailSender;
    //    @Autowired
//    private TemplateEngine templateEngine;
    @Value(value = "${spring.mail.username}")
    private String name;
    @Value(value = "${spring.mail.password}")
    private String password;
    @Value(value = "${spring.mail.host}")
    private String host;

    /**
     * 简单邮件
     */
    public void sendSimpleMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(name);// 发件人
        message.setTo("1847558440@qq.com");// 接收人
        message.setSubject("主题：简单邮件");// 标题
        message.setText("田浩然");// 内容
        mailSender.send(message);
    }

    /**
     * 复杂邮件-附件
     */
    public void sendAttachmentsMail() throws Exception {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(name);
        helper.setTo("1486630136@qq.com");
        helper.setSubject("主题：有附件");
        helper.setText("有附件的邮件");

        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));// 文件
        helper.addAttachment("附件-1.jpg", file); //
        helper.addAttachment("附件-2.jpg", file); //

        mailSender.send(mimeMessage);
    }

    /**
     * 静态资源
     */
    public void sendInlineMail() throws Exception {

        MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(name);
        helper.setTo("1486630136@qq.com");
        helper.setSubject("主题：嵌入静态资源");
        helper.setText("<html><body><img src=\"cid:weixin\" ></body></html>", true);

        FileSystemResource file = new FileSystemResource(new File("weixin.jpg"));
        helper.addInline("weixin", file);

        mailSender.send(mimeMessage);
    }

    /**
     * 模板邮件
     */
    public void sendTemplateMail() throws Exception {
        TemplateEngine templateEngine = new TemplateEngine();
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(name);
        helper.setTo("1486630136@qq.com");
        helper.setSubject("主题：模板邮件");
        Map<String, Object> model = new HashedMap();
        model.put("username", "148");
        //context 对象用于注入要在模板上渲染的信息
        Context context = new Context();
        context.setVariables(model);
        String emailText = templateEngine.process("email", context);
        helper.setText(emailText, true);

        mailSender.send(mimeMessage);
    }

    public static void main(String[] args) {
    }
}
