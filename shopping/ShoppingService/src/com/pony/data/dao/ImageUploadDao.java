package com.pony.data.dao;

import java.util.List;

import com.pony.data.service.ImageUploadService;
import com.pony.jdbc.JdbcUtils;

public class ImageUploadDao implements ImageUploadService {
	private JdbcUtils jdbcUtils;

	public ImageUploadDao() {
		jdbcUtils = new JdbcUtils();
	}

	
	
	public boolean resgisterUser(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "insert into user (uname,uphone,upswd,utime,utype,adminState,uimage) values  (?,?,?,?,?,?,?)";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	
	@Override
	public boolean insertImage(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "insert into shop (sName,sMoney,sPhone,sMessage,sImage,sCreatime,userId,sState,sCategory) values  (?,?,?,?,?,?,?,?,?)";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

	public boolean updateImage(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "update  shop  set sName  = ?, sMoney  = ?, sPhone  = ?, sMessage  = ?, sImage  = ? where sId = ?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

}
