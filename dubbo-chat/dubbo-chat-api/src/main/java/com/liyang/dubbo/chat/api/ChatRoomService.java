package com.liyang.dubbo.chat.api;

import java.util.List;

public interface ChatRoomService {
	
	public String queryRoomUserCount(String rooms);
	
	
	public List<String> getMaxOnlineUserCount(List<String> rooms, String data, String dataFormat);

}
