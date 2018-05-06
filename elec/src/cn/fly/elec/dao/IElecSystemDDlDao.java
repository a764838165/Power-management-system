package cn.fly.elec.dao;

import java.util.List;

import cn.fly.elec.domain.ElecCommonMsg;
import cn.fly.elec.domain.ElecSystemDDl;

public interface IElecSystemDDlDao extends ICommomDao<ElecSystemDDl> {
	public final static String SERVICE_NAME = "cn.fly.elec.dao.impl.ElecSystemDDlDaoImpl";

	List<Object> findKeyWord();

	String findDDlName(String ddlCode, String keyword);

}
