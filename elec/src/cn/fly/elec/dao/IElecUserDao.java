package cn.fly.elec.dao;

import cn.fly.elec.domain.ElecText;
import cn.fly.elec.domain.ElecUser;

public interface IElecUserDao extends ICommomDao<ElecUser>{
	public final static  String SERVICE_NAME= "cn.fly.elec.dao.impl.ElecUserImpl";
}
