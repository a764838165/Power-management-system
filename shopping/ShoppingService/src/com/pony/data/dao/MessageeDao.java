package com.pony.data.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pony.data.service.MessageService;
import com.pony.jdbc.JdbcUtils;

public class MessageeDao implements MessageService {
	private JdbcUtils jdbcUtils;

	public MessageeDao() {
		jdbcUtils = new JdbcUtils();
	}
	
	
	public boolean updataMessage(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "update  message set mReMessage =? where mid = ?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	
	public boolean deleteMessage(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "delete from message where mid=?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	

	@Override
	public boolean addMessage(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "insert into message (mMessage,mUid,mUserName,mCreateTime) values (?,?,?,?)";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

	@Override
	public List<Map<String, Object>> listMessageUser(List<Object> params) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from message where mUid=? order by mid desc";
		try {
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return list;
	}


	@Override
	public List<Map<String, Object>> listMessage() {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from message order by mid desc";
		try {
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(sql, null);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return list;
	}
}
