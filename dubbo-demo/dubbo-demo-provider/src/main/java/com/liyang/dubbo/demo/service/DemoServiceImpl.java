package com.liyang.dubbo.demo.service;

import com.liyang.dubbo.demo.api.DemoService;

public class DemoServiceImpl implements DemoService{

	@Override
	public String sayHello(String name) {
		return "hello, " + name;
	}

}
