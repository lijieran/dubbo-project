package com.liyang.dubbo.demo.service;

import org.apache.log4j.Logger;

import com.liyang.dubbo.demo.api.DemoService;

public class DemoServiceImpl implements DemoService{
	
	private static Logger logger = Logger.getLogger(DemoServiceImpl.class);

	@Override
	public String sayHello(String name) {
		
		System.out.println("处理服务");
		logger.error("处理服务");;
		return "hello, " + name;
	}

}
