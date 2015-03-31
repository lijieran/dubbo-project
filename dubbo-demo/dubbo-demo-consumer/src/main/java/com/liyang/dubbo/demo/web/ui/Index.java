package com.liyang.dubbo.demo.web.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.liyang.dubbo.demo.api.DemoService;



public class Index implements Controller{
	
	private DemoService demoService;

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {		
		request.setAttribute("message", demoService.sayHello("jaychou"));
		return new ModelAndView("index");
	}

	public void setDemoService(DemoService demoService) {
		this.demoService = demoService;
	}

	
}
