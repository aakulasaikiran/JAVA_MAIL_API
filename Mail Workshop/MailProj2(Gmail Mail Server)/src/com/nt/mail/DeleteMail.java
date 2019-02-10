package com.nt.mail;

import java.util.*;
import javax.mail.*;



public class DeleteMail {
     String host="pop.gmail.com";
	String emailfrom="nitraja2015";
	String password="2015rajanit";
	String port="995";

  DeleteMail()
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

		folder.open(Folder.READ_WRITE);
		Message[] msg = folder.getMessages();
		System.out.println("Msg count"+folder.getMessageCount());

		msg[0].setFlag(Flags.Flag.DELETED,true); //mark the msg for deletion
		System.out.println("Msg count"+folder.getMessageCount());
		folder.close(true); //close inbox with flag true
		System.out.println("Msg count"+folder.getMessageCount());
		store.close();
		}//try
		catch(Exception e)
		{e.printStackTrace();}
  }//constructor



	  private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication(emailfrom, password);
	}//method
} //private class

public static void main(String args[]) 
	{
	new DeleteMail();
	}
}