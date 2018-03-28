package com.qinmei.spring2boot.service;

/**
 * 邮件服务接口
 * @author 史恒飞 ，tel:18516417728
 * @version 1.0 ，2018年3月26日下午5:52:07
 */
public interface MailService {

	/** 简单邮件发送 */
	void sendSimpleMail(String to, String subject, String content);
	
	/** html邮件发送 */
	public void sendHtmlMail(String to, String subject, String content);
	
	/** 带附件邮件发送 */
	void sendAttachmentsMail(String to, String subject, String content, String filePath);
	
	/** 带静态资源邮件发送 */
	void sendInlineResourceMail(String to, String subject, String content, String rscPath, String rscId);
}
