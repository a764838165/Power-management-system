package cn.fly.elec.service;

import java.util.List;

import cn.fly.elec.domain.ElecCommonMsg;
import cn.fly.elec.domain.ElecText;
import cn.fly.elec.web.from.ElecCommonMsgFrom;
import cn.fly.elec.web.from.ElecMenuFrom;
import cn.fly.elec.web.from.ElecSystemDDlFrom;
import cn.fly.elec.web.from.ElecTextFrom;

public interface IElecSystemDDlServiceDao {
	public final static  String SERVICE_NAME= "cn.fly.elec.service.impl.ElecSystemDDlServiceImpl";

	List<ElecSystemDDlFrom> findKeyWord();

	List<ElecSystemDDlFrom> findElecSystemDDlListByKeyword(String keyword);

	void saveElecSystemDDl(ElecSystemDDlFrom systemDDlFrom);
	
	

}
