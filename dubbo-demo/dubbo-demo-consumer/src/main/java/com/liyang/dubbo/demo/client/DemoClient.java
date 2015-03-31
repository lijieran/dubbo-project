package com.liyang.dubbo.demo.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liyang.dubbo.demo.api.DemoService;


public class DemoClient{

	public static void main(String args[]) {
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-consumer.xml");
		context.start();
		DemoService demoService = (DemoService)context.getBean("demoService"); 
	    String hello = demoService.sayHello("world"); 
	    System.out.println(hello);
		
	}
	
	
}
