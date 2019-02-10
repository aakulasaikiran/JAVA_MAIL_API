package com.nt.mail;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Store;

public class RecieveMail {

	public static void main(String[] args)throws Exception {
		Properties properties=new Properties();
		 properties.put("mail.transport.protocol","pop");
		 properties.put("mail.pop.port","110");
		 properties.put("mail.host","localhost");

		 Session session=Session.getInstance(properties);
		 Store store=session.getStore("pop3");

		 store.connect("localhost","modi1","modi1");
		// Access InBox
		Folder inbox=store.getFolder("INBOX");
		inbox.open(Folder.READ_ONLY);
		//read email messages
		System.out.println("Messages count"+inbox.getMessageCount());
		Message messages[]=inbox.getMessages();
		//Display messages
		for(Message msg:messages){
			msg.writeTo(System.out);
			System.out.println("------------------------------");
		}
		
		store.close();
		inbox.close(false);
	}
}
