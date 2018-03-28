package com.qinmei.spring2boot;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.qinmei.spring2boot.dao.UserRepository;
import com.qinmei.spring2boot.domain.User;
import com.qinmei.spring2boot.service.MailService;

import freemarker.template.Template;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Spring2bootApplicationTests {

	@Autowired
	private UserRepository repository;

	public void contextLoads() {

		User user = new User();
		user.setPassWord("123");
		user.setUserName("shf");

		User user2 = repository.save(user);
		// 断言
		Assert.assertEquals("shf", user2.getUserName());

	}

	@Autowired
	private MailService MailService;

	/**
	 * 测试简单邮件发送
	 * 
	 * @throws Exception
	 */
	public void testSimpleMail() throws Exception {
		MailService.sendSimpleMail("644743045@qq.com", "叫你回家吃饭", " 嘿，在吗？");
	}

	/**
	 * 测试 html 邮件发送
	 * 
	 * @throws Exception
	 */
	public void testHtmlMail() throws Exception {
		String content = "<html>\n" + "<body>\n" + "    <h3>hello world ! "
				+ "这是一封Html邮件!</h3>\n" + "</body>\n" + "</html>";
		MailService.sendHtmlMail("644743045@qq.com", "html 邮件", content);
	}

	/**
	 * 测试附件邮件
	 */
	public void sendAttachmentsMail() {
		String filePath = "D:\\结课电子证书56873370.jpg";
		MailService.sendAttachmentsMail("644743045@qq.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
	}

	/**
	 * 测试图片邮件 添加多个图片可以使用多条 <img src='cid:" + rscId + "' > 和 helper.addInline(rscId,
	 * res) 来实现
	 */
	public void sendInlineResourceMail() {
		String rscId = "neo006";
		String content = "<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
		String imgPath = "D:\\结课电子证书56873370.jpg";

		MailService.sendInlineResourceMail("644743045@qq.com", "主题：这是有图片的邮件", content, imgPath, rscId);
	}

	@Autowired
	private FreeMarkerConfigurer freeMarkerConfigurer; // 自动注入

	// 注入MailSender
	@Autowired
	private JavaMailSender mailSender;

	/**
	 * freemaker 模板邮件发送
	 */
	@Test
	public void sendTemplateMail() {
		MimeMessage message = null;
		try {
			message = mailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom("shihengfei_it@163.com");
			helper.setTo("644743045@qq.com");
			helper.setSubject("我的join");

			Map<String, Object> model = new HashMap();
			model.put("username", "史恒飞");

			// 修改 application.properties 文件中的读取路径
			// FreeMarkerConfigurer configurer = new FreeMarkerConfigurer();
			// configurer.setTemplateLoaderPath("classpath:templates");
			// 读取 html 模板
			Template template = freeMarkerConfigurer.getConfiguration().getTemplate("ftl/emailTemplate.ftl");
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
			helper.setText(html, true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		mailSender.send(message);
	}
}
