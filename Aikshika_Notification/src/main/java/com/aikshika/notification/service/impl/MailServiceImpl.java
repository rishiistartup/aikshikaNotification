package com.aikshika.notification.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.aikshika.notification.domain.Mail;
import com.aikshika.notification.service.DreamFactoryService;
import com.aikshika.notification.service.MailService;
import com.aikshika.notification.vo.StudentList;
import com.aikshika.notification.vo.StudentMarks;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	JavaMailSender mailSender;

	@Autowired
	VelocityEngine velocityEngine;

	@Autowired
	DreamFactoryService dreamFactoryService;

	public void sendEmail(Mail mail) {
		MimeMessage mimeMessage = mailSender.createMimeMessage();

		try {

			MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

			mimeMessageHelper.setSubject(mail.getMailSubject());
			mimeMessageHelper.setFrom(mail.getMailFrom());
			mimeMessageHelper.setTo(mail.getMailTo());
			mail.setMailContent(geContentFromTemplate(mail.getModel()));
			mimeMessageHelper.setText(mail.getMailContent(), true);

			mailSender.send(mimeMessageHelper.getMimeMessage());
		} catch (javax.mail.MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String geContentFromTemplate(Map<String, Object> model) {
		StringBuffer content = new StringBuffer();
		try {
			content.append(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine,
					"../resources/mailSendingHtmFile.html", model));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}

	public boolean fetchDetailsAndSendMail() {
		StudentList stuList = new StudentList();
		try {
			stuList = dreamFactoryService.fecthMarks();
			StudentMarks marks = stuList.getResource().get(0);
			Mail mail = new Mail();
			mail.setMailTo("rishikantr@gmail.com");
			mail.setMailFrom("test@Aikshika.com");
			mail.setMailSubject("test@Aikshika.com");
			Map<String, Object> modelMap = new HashMap<>();
			modelMap.put("ID", marks.getId());
			modelMap.put("ExamType", marks.getExamType());
			mail.setModel(modelMap);
			sendEmail(mail);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}