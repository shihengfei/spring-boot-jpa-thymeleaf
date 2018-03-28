package com.qinmei.spring2boot.service;

import java.io.File;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * 邮件发送业务实现
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月26日下午3:26:38
 */
@Component
public class MailServiceImpl implements MailService{
    @Autowired
    private JavaMailSender mailSender;
    @Value("${mail.fromMail.addr}")
    private String from;
    /**
     * 简单邮件发送
     */
    public void sendSimpleMail(String to, String subject, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(content);

        try {
            mailSender.send(message);
            System.out.println("简单邮件已经发送。");
        } catch (Exception e) {
        	System.out.println("发送简单邮件时发生异常！");
        }
    }
    
    /**
     *  html 邮件发送
     */
    public void sendHtmlMail(String to, String subject, String content) {
        MimeMessage message = mailSender.createMimeMessage();

        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            mailSender.send(message);
            System.out.println("html邮件发送成功");
        } catch (MessagingException e) {
        	System.out.println("发送html邮件时发生异常！");
        }
    }
    
    /**
     * 带附件的邮件
     */
    public void sendAttachmentsMail(String to, String subject, String content, String filePath){
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file); // 添加附件，多条附件可以使用多个 add

            mailSender.send(message);
            System.out.println("带附件的邮件已经发送。");
        } catch (MessagingException e) {
        	System.out.println("发送带附件的邮件时发生异常！");
        }
    }
    
    /**
     * 静态资源 图片  添加多个图片可以使用多条 <img src='cid:" + rscId + "' > 和 helper.addInline(rscId, res) 来实现
     */
    public void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId){
        MimeMessage message = mailSender.createMimeMessage();

        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource res = new FileSystemResource(new File(rscPath));
            helper.addInline(rscId, res);

            mailSender.send(message);
            System.out.println("带图片的邮件已经发送。");
        } catch (MessagingException e) {
        	System.out.println("发送带图片的邮件时发生异常！");
        }
    }
}
