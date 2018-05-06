package cn.fly.elec.service;

import java.util.List;

import cn.fly.elec.domain.ElecCommonMsg;
import cn.fly.elec.domain.ElecText;
import cn.fly.elec.web.from.ElecCommonMsgFrom;
import cn.fly.elec.web.from.ElecMenuFrom;
import cn.fly.elec.web.from.ElecTextFrom;

public interface IElecCommonMsgServiceDao {
	public final static  String SERVICE_NAME= "cn.fly.elec.service.impl.ElecCommonServiceMsgImpl";
	
	public void saveCommonMsg(ElecCommonMsgFrom entity);
	public List<ElecCommonMsgFrom> findElecCommonMsgList();
	public List<ElecCommonMsgFrom> findElecCommonMsgListByCurrentDate();
}
