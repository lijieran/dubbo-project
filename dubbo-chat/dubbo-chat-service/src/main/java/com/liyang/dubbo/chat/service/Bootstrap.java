package com.liyang.dubbo.chat.service;

import java.io.IOException;

import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Bootstrap {
	
	private static Logger logger = Logger.getLogger(Bootstrap.class);
	
	public static void main(String args[]) throws IOException {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		logger.info("ChatRoom服务启动...");
		context.start();
		
		//按任意键退出
		//System.in.read();
	}

}
