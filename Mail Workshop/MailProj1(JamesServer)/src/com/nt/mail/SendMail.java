package com.nt.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class SendMail {
  public static void main(String[] args) throws Exception{
		Properties props=new Properties();
		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.host","localhost");
		props.put("mail.smtp.port","25");
		//get Session obj
		Session ses=Session.getInstance(props);
		//Create Email Message
		MimeMessage message=new MimeMessage(ses);
		message.setFrom(new InternetAddress("kalam1"));
		message.setRecipient(RecipientType.TO,new InternetAddress("modi1"));
		message.setSubject("open it to know it");
		message.setSentDate(new Date());
		
		message.setText("Mr.Modi Do not declare holiday on the day of my death, Instead make people to work an extra day");
		//send message
		Transport.send(message);
		System.out.println("Mail has been delivered");
  }
}
