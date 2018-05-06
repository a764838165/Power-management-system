package com.pony.data.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pony.data.service.RegisterService;
import com.pony.jdbc.JdbcUtils;

public class RegisterDao implements RegisterService {
	private JdbcUtils jdbcUtils;

	public RegisterDao() {
		jdbcUtils = new JdbcUtils();
	}
	
	
	public boolean updateState(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "update  user set adminState =? where uid = ?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	
	
	public boolean updateName(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "update  user set uname =? where uid = ?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	
	
	public boolean updatePhone(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "update  user set uphone =? where uid = ?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	public boolean deleteUser(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "delete from user where uid=?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	

	public boolean resgisterPhone(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "insert into user (uname,uphone,upswd,utime) values  (?,?,?,?)";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

	@Override
	public boolean resgisterCheck(List<Object> params) {
		boolean flag = false;
		String sql = "select * from user where uname=? and upswd=?";
		try {
			jdbcUtils.getConnection();
			Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);
			flag = !map.isEmpty() ? true : false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

	@Override
	public boolean Login(List<Object> params) {
		boolean flag = false;
		String sql = "select * from user where uphone=? and upswd=?";
		try {
			jdbcUtils.getConnection();
			Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params);
			flag = !map.isEmpty() ? true : false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	
	public Map<String, Object> queryUsers(List<Object> params) {
		Map<String, Object> map = null;
		String sql = "select * from user where uid=?";
		try {
			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return map;
	}
	

	@Override
	public Map<String, Object> queryOne(List<Object> params) {
		Map<String, Object> map = null;
		String sql = "select * from user where uphone=? and upswd=?";
		try {
			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return map;
	}

	@Override
	public Map<String, Object> queryId(List<Object> params) {
		Map<String, Object> map = null;
		String sql = "select uid from user where uname=? and upswd=?";
		try {
			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, params);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return map;
	}

	
	
	public List<Map<String, Object>> listUserAdmin() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from user  where adminState != 2 ";
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
	
	
	public List<Map<String, Object>> listUser(List<Object> params) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from user  where adminState = 2";
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

	public int getItemCount() {
		int result = 0;
		Map<String, Object> map = null;
		String sql = " select count(*) mycount from user ";
		try {
			jdbcUtils.getConnection();
			map = jdbcUtils.findSimpleResult(sql, null);
			result = Integer.parseInt(map.get("mycount").toString());
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		// TODO Auto-generated method stub
		return result;
	}


}
