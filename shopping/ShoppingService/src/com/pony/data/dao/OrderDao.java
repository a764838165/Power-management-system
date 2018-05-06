package com.pony.data.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pony.data.service.OrderService;
import com.pony.jdbc.JdbcUtils;

public class OrderDao implements OrderService {
	private JdbcUtils jdbcUtils;

	public OrderDao() {
		jdbcUtils = new JdbcUtils();
	}
	
	
	public boolean deleteState(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "delete from checkorder where oid=?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	
	public boolean addState(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "insert into checkorder (hid,oid,cstate,uid) values (?,?,?,?)";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	public boolean updateState(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "update  ordermsg set ostate =? where oid = ?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	public boolean addOrder(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "insert into ordermsg (ouser,ohousename,ohoursetype,ohourseaddress,ohourseprice,ousertime,otime,uid,ostate,hid) values  (?,?,?,?,?,?,?,?,?,?)";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	

	public boolean deleteOrder(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "delete from ordermsg where oid=?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	

	@Override
	public Map<String, Object> queryOne(List<Object> params) {
		Map<String, Object> map = null;
		String sql = "select ordermsg.oid from ordermsg where uid=? and hid=?";
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
		String sql = "select uid from ordermsg where uname=? and upswd=?";
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

	public List<Map<String, Object>> listOrder(String proname, int start, int end) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from ordermsg where (1=1) ";
		// limit ?,?
		StringBuffer buffer = new StringBuffer(sql);
		List<Object> params = new ArrayList<Object>();
		if (proname != null) {
			buffer.append(" and oid like ? ");
			params.add("%" + proname + "%");
		}
		buffer.append("limit ?,? ");
		params.add(start);
		params.add(end);
		try {
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(buffer.toString(), params);
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return list;
	}

	

	public List<Map<String, Object>> listOrderMessage(List<Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from ordermsg where uid = ? ";
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
	
	
	
	public List<Map<String, Object>> listOrderMessagePhone(List<Object> params) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from ordermsg where uid = ? and ostate = ?";
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
	

	public int getItemCount() {
		int result = 0;
		Map<String, Object> map = null;
		String sql = " select count(*) mycount from ordermsg ";
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
