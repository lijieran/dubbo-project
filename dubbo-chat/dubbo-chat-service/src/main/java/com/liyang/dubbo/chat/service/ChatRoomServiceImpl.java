package com.liyang.dubbo.chat.service;

import java.util.List;

import org.apache.log4j.Logger;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import com.alibaba.dubbo.common.utils.StringUtils;
import com.liyang.dubbo.chat.api.ChatRoomService;
import com.liyang.dubbo.common.DateTimeUtils;

public class ChatRoomServiceImpl implements ChatRoomService{
	
	private static Logger logger = Logger.getLogger(ChatRoomServiceImpl.class);
	private JedisPool jedisPool;
	
	private static final String CHAT_ROOM_ONLINE_KEY = "chat::room::online::count";
	private static final String CHAT_ROOM_MAX_COUNT_KEY_PREF = "chat::room::max::count::";
	private static final String DF_YYYYMMDD = "yyyyMMdd";

	public String queryRoomUserCount(String rooms) {
		logger.info("查询在线人数：　"+rooms);
		StringBuffer buffer = new StringBuffer();
		
		if(rooms == null) {
			logger.error("参数有误：rooms不能为空");
			return null;
		}
		
		String [] fields = rooms.split(",");
		
		Jedis jedis = jedisPool.getResource();
		try {
			List<String> vals = jedis.hmget(CHAT_ROOM_ONLINE_KEY, fields);
			
			buffer.append(StringUtils.join(vals, ","));
		} catch (Exception e) {
			logger.error("操作reids查询在线人数出错", e);
		} finally {
			if(jedis!=null) jedis.quit();
		}
		
		
		logger.info("查询在线人数"+rooms+"结果为"+buffer.toString());
		return buffer.toString();
	}

	public List<String> getMaxOnlineUserCount(List<String> rooms, String date,
			String dateFormat) {
		String realdate = DateTimeUtils.format(date, dateFormat, DF_YYYYMMDD);
		String key = CHAT_ROOM_MAX_COUNT_KEY_PREF + realdate;
		logger.info("查询"+realdate+"的最高在线人数值。key="+key);
		Jedis jedis = jedisPool.getResource();
		try {
			
			return jedis.hmget(key, rooms.toArray(new String[rooms.size()]));
		} catch (Exception e) {
			logger.error("", e);
		} finally {
			jedis.quit();
		}
		
		return null;
	}

	public void setJedisPool(JedisPool jedisPool) {
		this.jedisPool = jedisPool;
	}
	
	

}
