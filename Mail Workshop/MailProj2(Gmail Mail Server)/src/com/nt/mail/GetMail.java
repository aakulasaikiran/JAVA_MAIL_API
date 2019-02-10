package com.nt.mail;

import java.util.*;
import javax.mail.*;

public class GetMail {

     String host="pop.gmail.com";
	String emailfrom="nitraja2015@gmail.com";
	String password="2015rajanit";
	String port="995";

  GetMail()
	  {
    	Properties props = new Properties();

		props.put("mail.pop3.host", host);
		props.put("mail.pop3.port", port);
		props.put("mail.pop3.auth", "true");
		props.put("mail.pop3.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

	try {
		Authenticator auth = new SMTPAuthenticator();
		Session session = Session.getInstance(props, auth);
	 
		 Store store = session.getStore("pop3s");

		  store.connect(host,emailfrom,password);

		  Folder folder = store.getFolder("inbox");
	
		folder.open(Folder.READ_ONLY);
		Message[] msg = folder.getMessages();

		System.out.println((msg.length)+" message found");
		for (int i =1; i <= msg.length; i++) {
			Message mess=folder.getMessage(i);
			mess.writeTo(System.out);
			System.out.println("---------------------------");
		}//for
  }//try
  catch(Exception e)
	{e.printStackTrace();}
  }//constructor

  private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(emailfrom, password);
	}
} //private class

public static void main(String args[]) 
	{
	new GetMail();
	}//main
}//class