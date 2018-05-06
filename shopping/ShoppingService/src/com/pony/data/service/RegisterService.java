package com.pony.data.service;

import java.util.List;
import java.util.Map;

public interface RegisterService {
	//ÊÖ»ú×¢²á
	public boolean resgisterPhone(List<Object> params);
	//µÇÂ½
	public boolean Login(List<Object> params);
	//×¢²á¼ì²é
	public boolean resgisterCheck(List<Object> params);
	//²éÑ¯
	public Map<String, Object> queryOne(List<Object> params);
	//²éÑ¯id
	public Map<String, Object> queryId(List<Object> params);
	
	
	public int getItemCount();
	
	public boolean deleteUser(List<Object> params);
	
	public boolean updateName(List<Object> params);
	
	public boolean updatePhone(List<Object> params);
}
