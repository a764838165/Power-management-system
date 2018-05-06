package com.pony.data.service;

import java.util.List;
import java.util.Map;

public interface JobService {
	public boolean addJobMessage(List<Object> params);
	
	public List<Map<String, Object>> listMessage(List<Object> params);
	
	public List<Map<String, Object>> listMessagePerson();
}
