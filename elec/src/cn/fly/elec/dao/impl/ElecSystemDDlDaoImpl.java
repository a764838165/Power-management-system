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
import cn.fly.elec.dao.IElecSystemDDlDao;
import cn.fly.elec.domain.ElecCommonMsg;
import cn.fly.elec.domain.ElecSystemDDl;

@Repository(IElecSystemDDlDao.SERVICE_NAME)
public class ElecSystemDDlDaoImpl extends CommomImpl<ElecSystemDDl> implements IElecSystemDDlDao {

	/**  
	* @Name:findKeyWord
	* @Description: 查询数据类型关键字
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* 
	* @Return: List<ElecSystemDDl>
	*/
	//返回的是一个值，不是数组bean对象
	public List<Object> findKeyWord() {
		String hql = "select distinct o.keyword from ElecSystemDDl o ";
		List<Object> list = this.getHibernateTemplate().find(hql);
		return list;
	}
	/**  
	* @Name:findDDlName
	* @Description: 用数据类型和数据项编号获取数据项的名臣
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-29 （创建日期）
	* 
	* @Return:String
	*/
	public String findDDlName(String ddlCode, String keyword) {
		String hql = "from ElecSystemDDl where keyword = '" + keyword + "'" +
	             " and ddlCode=" + ddlCode;
	List<ElecSystemDDl> list = this.getHibernateTemplate().find(hql);
	String ddlName = "";
	if(list!=null && list.size()>0){
		ElecSystemDDl elecSystemDDl = list.get(0);
		ddlName = elecSystemDDl.getDdlName();
	}
	return ddlName;
	}
	
}
