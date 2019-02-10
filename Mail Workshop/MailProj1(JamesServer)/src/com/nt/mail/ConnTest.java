package com.nt.mail;

import java.util.Properties;

import javax.mail.Session;

public class ConnTest {

	public static void main(String[] args)throws Exception {
		//prepare Mail Properties
		Properties props=new Properties();
		props.put("mail.transport.protocol","smtp");
		props.put("mail.smtp.host","localhost");
		props.put("mail.smtp.port","25");
		//get Session obj
		Session ses=Session.getInstance(props);
		if(ses==null)
			System.out.println("Conencted not established");
		else
			System.out.println("Conencted  established");
		}
}
