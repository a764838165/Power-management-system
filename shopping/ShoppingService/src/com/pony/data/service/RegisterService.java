package com.pony.data.service;

import java.util.List;
import java.util.Map;

public interface RegisterService {
	//�ֻ�ע��
	public boolean resgisterPhone(List<Object> params);
	//��½
	public boolean Login(List<Object> params);
	//ע����
	public boolean resgisterCheck(List<Object> params);
	//��ѯ
	public Map<String, Object> queryOne(List<Object> params);
	//��ѯid
	public Map<String, Object> queryId(List<Object> params);
	
	
	public int getItemCount();
	
	public boolean deleteUser(List<Object> params);
	
	public boolean updateName(List<Object> params);
	
	public boolean updatePhone(List<Object> params);
}
