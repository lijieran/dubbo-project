package com.liyang.dubbo.chat.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import junit.framework.TestCase;

public class RedisTest extends TestCase{
	
	public  void testRedisPool() {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		JedisPool pool = (JedisPool)context.getBean("jedisPool");
		Jedis jedis = pool.getResource();
		if(jedis.ping().equalsIgnoreCase("pong")) {
			System.out.println("Reids连接成功...");
		}
		
		jedis.hset("chat::room::max::count::20150402", "10086", "5");
		jedis.quit();
	}
	
	
}
