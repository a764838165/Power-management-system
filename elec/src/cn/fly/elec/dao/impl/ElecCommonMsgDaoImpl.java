package cn.fly.elec.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.stereotype.Repository;

import cn.fly.elec.dao.IElecCommonMsgDao;
import cn.fly.elec.domain.ElecCommonMsg;

@Repository(IElecCommonMsgDao.SERVICE_NAME)
public class ElecCommonMsgDaoImpl extends CommomImpl<ElecCommonMsg> implements IElecCommonMsgDao {
	/**  
	* @Name: findElecCommonMsgListByCurrentDate
	* @Description: 通过当前日期查询待办事宜列表
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* @Parameters:当前日期
	* @Return: List<Object[]> 返回待办事宜结果集列表
	*/
	public List<Object[]> findElecCommonMsgListByCurrentDate(String currentDate) {
		final String sql = " select o.StationRun,o.DevRun "+
					 " from Elec_commonMsg o" +
					 " where o.CreateDate = '"+currentDate+"'";
		List<Object[]> list=(List<Object[]>) this.getHibernateTemplate().execute(new HibernateCallback() {
			
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				//标量查询
				Query query = session.createSQLQuery(sql)
							  .addScalar("StationRun",Hibernate.STRING)
							  .addScalar("DevRun",Hibernate.STRING);
				
				return query.list();
			}
		});
		return list;
	}

	
}
