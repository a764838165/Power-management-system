package com.pony.data.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pony.data.service.ReviewService;
import com.pony.jdbc.JdbcUtils;

public class ReviewDao implements ReviewService {
	private JdbcUtils jdbcUtils;

	public ReviewDao() {
		jdbcUtils = new JdbcUtils();
	}
	
	public boolean updateMessage(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "update  review set rReplyContent =? where rid = ?";
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
			String sql = "insert into review (rUserId,rUserName,rShopId,rReviewContent,rReplyContent,rCreatime) values  (?,?,?,?,?,?)";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	
	public List<Map<String, Object>> listNoticesMessage(List<Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from review  where  rShopId = ? ";
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
	
	public List<Map<String, Object>> listReviewMessage(List<Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from review where  rShopId = ?";
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
		String sql = "select * from review";
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

	@Override
	public boolean deleteMessage(List<Object> params) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public List<Map<String, Object>> listMessageTeacher(List<Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from review  where  nid = ? ";
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
}
