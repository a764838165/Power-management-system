package com.pony.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtils {

	// ��ʾ�������ݿ���û���
	private final String USERNAME = "root";
	// �������ݿ������
	private final String PASSWORD = "";
	// �������ݿ��������Ϣ
	private final String DRIVER = "com.mysql.jdbc.Driver";
	// ����������ݿ�ĵ�ַ
	private final String URL = "jdbc:mysql://localhost:3306/shoppingdb?characterEncoding=utf8";
	// �������ݿ������
	private Connection connection;
	// ����sql����ִ�ж���
	private PreparedStatement pstmt;
	// �����ѯ���صĽ������
	private ResultSet resultSet;

	public JdbcUtils() {
		try {
			Class.forName(DRIVER);
			System.out.println("ע�������ɹ�!!");
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	// ���������ݿ������
	public Connection getConnection() {
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return connection;
	}

	/**
	 * ��ɶ����ݿ�ı�����ɾ�����޸ĵĲ���
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public boolean updateByPreparedStatement(String sql, List<Object> params) throws SQLException {
		
		
		
		boolean flag = false;
		int result = -1;// ��ʾ���û�ִ�����ɾ�����޸ĵ�ʱ����Ӱ�����ݿ������
		pstmt = connection.prepareStatement(sql);
		int index = 1;
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		result = pstmt.executeUpdate();
		flag = result > 0 ? true : false;
		return flag;
	}

	/**
	 * ��ѯ���ص�����¼
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public Map<String, Object> findSimpleResult(String sql, List<Object> params) throws SQLException {
		Map<String, Object> map = new HashMap<String, Object>();
		int index = 1;
		pstmt = connection.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();// ���ز�ѯ���
		ResultSetMetaData metaData = resultSet.getMetaData();
		int col_len = metaData.getColumnCount();// ����е�����
		while (resultSet.next()) {
			for (int i = 0; i < col_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
		}
		return map;
	}

	/**
	 * ��ѯ���ض��м�¼
	 * 
	 * @param sql
	 * @param params
	 * @return
	 * @throws SQLException
	 */
	public List<Map<String, Object>> findMoreResult(String sql, List<Object> params) throws SQLException {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		int index = 1;
		pstmt = connection.prepareStatement(sql);
		if (params != null && !params.isEmpty()) {
			for (int i = 0; i < params.size(); i++) {
				pstmt.setObject(index++, params.get(i));
			}
		}
		resultSet = pstmt.executeQuery();
		ResultSetMetaData metaData = resultSet.getMetaData();
		int cols_len = metaData.getColumnCount();
		while (resultSet.next()) {
			Map<String, Object> map = new HashMap<String, Object>();
			for (int i = 0; i < cols_len; i++) {
				String cols_name = metaData.getColumnName(i + 1);
				Object cols_value = resultSet.getObject(cols_name);
				if (cols_value == null) {
					cols_value = "";
				}
				map.put(cols_name, cols_value);
			}
			list.add(map);
		}
		return list;
	}
	
	// ʵ������������Ĺ���
	private Statement stmt;
	
	public boolean deleteByBatch(String[] sql) throws SQLException{
		boolean flag = false;
		stmt = connection.createStatement();
		if(sql!=null){
			for(int i=0;i<sql.length;i++){
				stmt.addBatch(sql[i]);
			}
		}
		int[] count = stmt.executeBatch();
		if(count!=null){
			flag = true;
		}
		return flag;
	}
	

	/**
	 * ͨ��������Ʒ������ݿ�
	 * 
	 * @param <T>
	 * @param sql
	 * @param params
	 * @param cls
	 * @return
	 * @throws Exception
	 */

	public void releaseConn() {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		JdbcUtils jdbcUtils = new JdbcUtils();
//		jdbcUtils.getConnection();

//		// ���ݵĲ���
//
//		String sql = "insert into ponytable(name,age,address) values(?,?,?)";
//		List<Object> params = new ArrayList<Object>();
//		params.add("����");
//		params.add("20");
//		params.add("������");
//		try {
//			boolean flag = jdbcUtils.updateByPreparedStatement(sql, params);
//			System.out.println(flag);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		
		
		// �����޸�
//		UPDATE ponytable SET name='����' where age>30;
//		String sql = "insert into ponytable(name,age,address) values(?,?,?)";
		
//		String sql = "UPDATE ponytable SET name='yn' where id=?";
//		List<Object> params = new ArrayList<Object>();
//		params.add("24");
//		try {
//			boolean flag = jdbcUtils.updateByPreparedStatement(sql, params);
//			System.out.println(flag);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}

		
		
		// //��ѯ������¼
		// String sql = "select * from user where id = ? ";
		// List<Object> params = new ArrayList<Object>();
		// params.add(1);
		// try {
		// Map<String, Object> list = jdbcUtils.findSimpleResult(sql, params);
		// System.out.println(list);
		// } catch (Exception e) {
		// // TODO: handle exception
		// } finally {
		// jdbcUtils.releaseConn();
		// }

		// ��ѯ������¼
//		String sql = "select * from ponytable ";
//		try {
//			List<Map<String, Object>> list = jdbcUtils.findMoreResult(sql, null);
//			System.out.println(list);
//		} catch (Exception e) {
//			// TODO: handle exception
//		} finally {
//			jdbcUtils.releaseConn();
//		}

		// // ɾ��һ����¼
		// String sql = "delete from user where id = ?";
		// List<Object> params = new ArrayList<Object>();
		// params.add(2);
		// try {
		// boolean flag = jdbcUtils.updateByPreparedStatement(sql, params);
		// System.out.println(flag);
		// } catch (SQLException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

}
