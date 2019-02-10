package com.nt.mail;

//Mail.java
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class  SendMail
 {

public SendMail() {
// mail properties outgoing server (gmail.com)
	Properties props = new Properties();
	props.put("mail.smtp.host", "smtp.gmail.com");
	props.put("mail.smtp.port", "465");
	props.put("mail.smtp.auth", "true");
	props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

	try {
	// create Session obj
	Authenticator auth = new SMTPAuthenticator();

	Session session = Session.getInstance(props,auth);

	//prepare mail msg
	MimeMessage msg = new MimeMessage(session);
	//set header values
	msg.setSubject("open to it know it1");
	msg.setFrom(new InternetAddress("nataraz@gmail.com"));
	msg.addRecipient(Message.RecipientType.TO, new InternetAddress("nitraja2015@gmail.com"));
	//msg text
	msg.setText("mail from HCL Technlogies1");

	Transport.send(msg);
	}//try
	 catch (Exception ex) {
       ex.printStackTrace();
	  }//catch
}//constructor

private class SMTPAuthenticator extends javax.mail.Authenticator {
	 public PasswordAuthentication getPasswordAuthentication() {
	   return new PasswordAuthentication("nitraja2015@gmail.com","2015rajanit");
   }//method
}//inner class


public static void main(String[] args){
     SendMail mail=new SendMail();
      System.out.println("mail has been delivered");
 }//main
}// Mail class


