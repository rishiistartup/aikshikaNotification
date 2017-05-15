package com.aikshika.notification.service;

import com.aikshika.notification.domain.Mail;

public interface MailService {
	    public void sendEmail(Mail mail);
		public boolean fetchDetailsAndSendMail() ;
}
