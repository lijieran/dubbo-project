package com.liyang.dubbo.chat.bootstrap;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.liyang.dubbo.chat.api.ChatRoomService;

public class ClientBootstrap {
	
	public static void main(String args[]) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		ChatRoomService service = (ChatRoomService)context.getBean("chatRoomService");
		System.out.println("开始调用服务");
		System.out.println("结果"+service.queryRoomUserCount("10086,10087"));
		
		
		List<String> rooms = new ArrayList<String>();
		rooms.add("10086");
		
		System.out.println("结果"+service.getMaxOnlineUserCount(rooms, "20150402", "yyyyMMdd"));
	}

}
