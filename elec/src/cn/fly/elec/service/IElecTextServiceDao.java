package cn.fly.elec.service;

import java.util.List;

import cn.fly.elec.domain.ElecText;
import cn.fly.elec.web.from.ElecMenuFrom;
import cn.fly.elec.web.from.ElecTextFrom;

public interface IElecTextServiceDao {
	public final static  String SERVICE_NAME= "cn.fly.elec.service.impl.ElecTextServiceImpl";
	public void saveElecText(ElecText entity);
	void update(ElecText entity);
	 public abstract List<ElecText> findfindCollectionByConditionNoPage(ElecTextFrom elecTextFrom);
	
}
