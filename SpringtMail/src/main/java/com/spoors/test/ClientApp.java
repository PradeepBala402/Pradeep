package com.spoors.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spoors.mail.JavaMail;

public class ClientApp {

	public static void main(String[] args) {
		 ApplicationContext ctx=null;
		 ctx=new ClassPathXmlApplicationContext("com/spoors/cfg/applicationContext.xml");
		 JavaMail mail=new JavaMail();
		 mail=(JavaMail) ctx.getBean("jMail");
		 String sender="pradeep.bala98@gmail.com";
		 String receiver="shaik01457@gmail.com";
		 mail.setSendMail(sender, receiver, "hi", "hii gangleader");
		 System.out.println("success");
	}
}
