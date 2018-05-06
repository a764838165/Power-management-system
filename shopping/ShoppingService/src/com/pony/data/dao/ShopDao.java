package com.pony.data.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pony.data.service.ShopService;
import com.pony.jdbc.JdbcUtils;

public class ShopDao implements ShopService {
	private JdbcUtils jdbcUtils;

	public ShopDao() {
		jdbcUtils = new JdbcUtils();
	}
	public List<Map<String, Object>> listMessageMsgCollect(List<Object> paramsAction) {
		List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
		Map<String, Object> mapResult;
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from collect where cUserId = ? ";
		// String sql =
		// "select * from weibo where wUserId = ? order by wId desc";
		try {

			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(sql, paramsAction);

			for (int i = 0; i < list.size(); i++) {
				// mapResult = list.get(i);
				List<Object> params = new ArrayList<Object>();
				params.clear();
				params.add(list.get(i).get("cShopId") + "");
				mapResult = queryShop(params);
				listResult.add(mapResult);
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return listResult;
	}
	
	public boolean deleteCollect(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "delete from collect where cShopId=? and cUserId = ?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	public boolean addCollect(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "insert into collect (cUserId,cUserName,cShopId) values  (?,?,?)";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	public boolean deleteCategory(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "delete from category where cgId=?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	public List<Map<String, Object>> listCateMesasgeMsg() {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from category ";
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
	public boolean addCategory(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "insert into category (cgName) values  (?)";
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
			String sql = "update  shop set sPayUsererId =?,sPayUserName =?,sState =? where sId = ?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	
	public boolean deleteShop(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "delete from shop where sId=?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

	public List<Map<String, Object>> listSearchShop(String proname) {
		// TODO Auto-generated method stub
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from shop where (1=1) ";
		// limit ?,?
		StringBuffer buffer = new StringBuffer(sql);
		List<Object> params = new ArrayList<Object>();
		if (proname != null) {
			buffer.append(" and sName like ? ");
			params.add("%" + proname + "%");
		}
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

	public boolean deleteImage(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "update  shop set sImage =? where sId = ?";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}

	public boolean updateShop(List<Object> params) {
		boolean flag = false;
		try {
			String sql = "update  shop set uname =? where sId = ?";
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
			String sql = "insert into shop (sName,sMoney,sPhone,sMessage,sCreatime,userId) values  (?,?,?,?,?,?)";
			jdbcUtils.getConnection();
			flag = jdbcUtils.updateByPreparedStatement(sql, params);
		} catch (Exception e) {
		} finally {
			jdbcUtils.releaseConn();
		}
		return flag;
	}
	
	
	public List<Map<String, Object>> listReviewUser(List<Object> params) {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from review  where  rShopId = ?";
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
	
	

	public List<Map<String, Object>> listReviewMessageMsg(List<Object> params) {
		List<Map<String, Object>> listShop = new ArrayList<Map<String, Object>>();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from review  where rUserId = ?";
		try {
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(sql, params);

			for (int i = 0; i < list.size(); i++) {
				List<Object> paramsShop = new ArrayList<Object>();
				paramsShop.add(list.get(i).get("rShopId"));
				listShop.add(queryShop(paramsShop));
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return listShop;
	}
	
	
	public Map<String, Object> queryShop(List<Object> params) {
		Map<String, Object> map = null;
		String sql = "select * from shop where sId=?";
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
	
	

	public List<Map<String, Object>> listMyMessageMsg(List<Object> params) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from shop  where userId = ?";
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
	public List<Map<String, Object>> listMessageSearchMsg(List<Object> params) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from shop  where sState = 1 and sCategory = ? order by sId desc";
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
	public List<Map<String, Object>> listMessageMsgPc() {
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from shop  where sState = 1 order by sId desc";
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
	
	
	
	public List<Map<String, Object>> listMessageMsg(String userId) {

		List<Map<String, Object>> listResult = new ArrayList<Map<String, Object>>();
		Map<String, Object> mapResult;
		
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from shop  where sState = 1 order by sId desc";
		try {
			jdbcUtils.getConnection();
			list = jdbcUtils.findMoreResult(sql, null);
			
			for (int i = 0; i < list.size(); i++) {
				mapResult = list.get(i);
				Map<String, Object> mapMsg = list.get(i);
				
				List<Object> paramsCheck = new ArrayList<Object>();
				paramsCheck.clear();
				paramsCheck.add(userId);
				paramsCheck.add(list.get(i).get("sId") + "");

				boolean flagFocus = collectState(paramsCheck);
				mapResult.put("colectState", flagFocus);

				listResult.add(mapResult);
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			jdbcUtils.releaseConn();
		}
		return list;
	}
	
	
	public boolean collectState(List<Object> params) {
		boolean flag = false;
		String sql = "select * from collect where cUserId=? and cShopId=?";
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
	public List<Map<String, Object>> listMessage(List<Object> params) {

		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		String sql = "select * from shop  order by sId desc";
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
		String sql = "select * from personTojobTable  order by jid desc";
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
	public List<Map<String, Object>> listMessageUser(List<Map<String, Object>> list) {
		List<Map<String, Object>> list_rssult = new ArrayList<Map<String, Object>>();
		List<Object> params_for = new ArrayList<Object>();
		String sql = "select * from user where uid=? ";
		try {
			jdbcUtils.getConnection();
			for (int i = 0; i < list.size(); i++) {
				params_for.clear();
				params_for.add((String) list.get(i).get("uid"));
				Map<String, Object> map = jdbcUtils.findSimpleResult(sql, params_for);
				list_rssult.add(map);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			jdbcUtils.releaseConn();
		}
		return list_rssult;
	}

}
