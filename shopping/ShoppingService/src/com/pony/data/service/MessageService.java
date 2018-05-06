package com.pony.data.service;

import java.util.List;
import java.util.Map;

public interface MessageService {
	
	public boolean addMessage(List<Object> params);
	public boolean updataMessage(List<Object> params);
	
	public List<Map<String, Object>> listMessage();
	public boolean deleteMessage(List<Object> params);
	public List<Map<String, Object>> listMessageUser(List<Object> params);
}
