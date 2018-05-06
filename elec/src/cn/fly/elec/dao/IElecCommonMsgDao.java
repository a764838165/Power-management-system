package cn.fly.elec.dao;

import java.util.List;

import cn.fly.elec.domain.ElecCommonMsg;

public interface IElecCommonMsgDao extends ICommomDao<ElecCommonMsg> {
	public final static String SERVICE_NAME = "cn.fly.elec.dao.impl.ElecCommonMsgDaoImpl";

	public List<Object[]> findElecCommonMsgListByCurrentDate(String currentDate);
}
