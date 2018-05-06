package com.pony.data.service;

import java.util.List;
import java.util.Map;

public interface ShopService {
	public boolean addMessage(List<Object> params);
	
	public List<Map<String, Object>> listMessage(List<Object> params);
	
	public List<Map<String, Object>> listMessagePerson();
	
	public List<Map<String, Object>> listMessageUser(List<Map<String, Object>> list);
	
	
}
