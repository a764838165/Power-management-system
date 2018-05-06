package cn.fly.elec.service;

import java.util.List;

import cn.fly.elec.domain.ElecText;
import cn.fly.elec.domain.ElecUser;
import cn.fly.elec.web.from.ElecMenuFrom;
import cn.fly.elec.web.from.ElecTextFrom;
import cn.fly.elec.web.from.ElecUserFrom;

public interface IElecUserServiceDao {
	public final static  String SERVICE_NAME= "cn.fly.elec.service.impl.ElecUserServiceImpl";
	public List<ElecUserFrom> findElecUserList(ElecUserFrom elecUserFrom);
	public void saveElecUser(ElecUserFrom elecUserFrom);
}
