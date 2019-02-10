package com.nt.mail;
/*
   Java Application to send an E-mail with attachment

*/
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class SendAttachment
{
	public static void main(String []args) throws Exception
    {
		//Creating Properties Objct
		Properties properties=new Properties();
		//adding protocol,mailserver address & the port number of the mailserver
		properties.put("mail.transport.protocol","smtp");
		properties.put("mail.smtp.host","localhost");
		properties.put("mail.smtp.port","25");

		//Creating the Session Object
		Session session=Session.getInstance(properties);

		//Creating and configuring the Message object
		Message message=new MimeMessage(session);

		message.setFrom(new InternetAddress("kalam1"));
       	message.setRecipient(RecipientType.TO,new InternetAddress("modi1"));
		message.setSentDate(new Date());
		message.setSubject("MAIL WITH ATTACHMENT");
		
		// mail body obj
		Multipart mailbody=new MimeMultipart();

		// mail body part1 obj (text content)
		MimeBodyPart part1=new MimeBodyPart();
		part1.setText("hello see my resume");
		mailbody.addBodyPart(part1);


         //mail body part2(attachment)
		FileDataSource fds=new FileDataSource("src/resume.txt");// represents attachment file
		MimeBodyPart part2=new MimeBodyPart();
		part2.setDataHandler(new DataHandler(fds));
		part2.setFileName(fds.getName());
		mailbody.addBodyPart(part2);

		message.setContent(mailbody);

		//Sending the mail.   
		Transport.send(message);
		System.out.println("Mail has been delivered");
    }//main
}//class
//>javac SendAttachment.java
//>java SendAttachment one.txt