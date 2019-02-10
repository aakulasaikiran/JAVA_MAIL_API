package com.nt.mail;

import java.util.Properties;

import javax.mail.Flags;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class DeleteMail {

	public static void main(String[] args) throws Exception{
		Properties properties=new Properties();
		 properties.put("mail.transport.protocol","pop");
		 properties.put("mail.pop.port","110");
		 properties.put("mail.host","localhost");

		 Session session=Session.getInstance(properties);
		 Store store=session.getStore("pop3");

		 store.connect("localhost","modi1","modi1");
		 
		 // Access InBox
		 Folder inbox=store.getFolder("INBOX");
		 inbox.open(Folder.READ_WRITE);
		 
		 System.out.println("Messages count"+inbox.getMessageCount());
		 //Read messages
		 Message message=inbox.getMessage(1);
		 //Mark the message for deleteion
		 message.setFlag(Flags.Flag.DELETED,true);
		 
		 //close inbox with flag true
		 inbox.close(true);
		 System.out.println("Messages count"+inbox.getMessageCount());
		 store.close();
	}
}
