package com.pony.data.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pony.data.service.JobService;
import com.pony.jdbc.JdbcUtils;

public class JobDao implements JobService {
	private JdbcUtils jdbcUtils;

	public JobDao() {
		jdbcUtils = new JdbcUtils();
	}

	@Override
	public boolean addJobMessage(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "insert into jobTable (jName,jTime,jAddress,jMoney,jMessage,jUserId,jCompany,jCreatetime) values  (?,?,?,?,?,?,?,?)";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

	
	@Override
	public List<Map<String, Object>> listMessage(List<Object> params) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from jobTable where jUserId=? order by jid desc";
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
	public List<Map<String, Object>> listMessagePerson() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from jobTable  order by jid desc";
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
