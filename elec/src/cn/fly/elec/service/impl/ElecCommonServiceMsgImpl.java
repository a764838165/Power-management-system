package cn.fly.elec.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.fly.elec.dao.IElecCommonMsgDao;
import cn.fly.elec.dao.IElecTextDao;
import cn.fly.elec.domain.ElecCommonMsg;
import cn.fly.elec.domain.ElecText;
import cn.fly.elec.service.IElecCommonMsgServiceDao;
import cn.fly.elec.service.IElecTextServiceDao;
import cn.fly.elec.web.from.ElecCommonMsgFrom;
import cn.fly.elec.web.from.ElecMenuFrom;
import cn.fly.elec.web.from.ElecTextFrom;
@Transactional(readOnly=true)
@Service(IElecCommonMsgServiceDao.SERVICE_NAME)
public class ElecCommonServiceMsgImpl implements IElecCommonMsgServiceDao{
	@Resource(name=IElecCommonMsgDao.SERVICE_NAME)
	private IElecCommonMsgDao dao;
	/**  
	* @Name: saveCommonMsg
	* @Description: 保存ElecCommonMsg对象
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* ElecCommonMsgFrom entity 对象
	* @Return: 无
	*/
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveCommonMsg(ElecCommonMsgFrom entity) {
		ElecCommonMsg msg = this.elecCommonMsgVoToPo(entity);
		dao.save(msg);
	}
	/**  
	* @Name: elecCommonMsgVoToPo
	* @Description: vo对象转po对象
	* * @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* ElecCommonMsgFrom entity 对象
	* @Return: 无
	*/
	private ElecCommonMsg elecCommonMsgVoToPo(ElecCommonMsgFrom elecCommomMsgFrom) {
		ElecCommonMsg msg = new ElecCommonMsg();
		if(elecCommomMsgFrom!=null)
		{
			msg.setCreateDate(new Date());
			msg.setDevRun(elecCommomMsgFrom.getDevRun());
			msg.setStationRun(elecCommomMsgFrom.getStationRun());
		}
			
			return msg;
	}
	/**  
	* @Name: findElecCommonMsgList
	* @Description: 查询所有待办事宜对象
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* @Parameters:null
	* @Return: List<ElecCommonMsgFrom> 返回待办事宜结果集列表
	*/
	public List<ElecCommonMsgFrom> findElecCommonMsgList() {
		String hqlWhere="";
		Object [] params=null;
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		
		orderby.put(" o.createDate", "desc");
		List<ElecCommonMsg> list = dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		
		List<ElecCommonMsgFrom> elecCommonFrom =this.elecCommonMsgPoListToVoList(list);
		
		
		return elecCommonFrom;
	}
	/**  
	* @Name: elecCommonMsgPoListToVoList
	* @Description: 待办事宜对象po结果集转vo结果集
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* @Parameters:null
	* @Return: List<ElecCommonMsgFrom> 返回待办事宜结果集列表
	*/
	private List<ElecCommonMsgFrom> elecCommonMsgPoListToVoList(
			List<ElecCommonMsg> list) {
		ElecCommonMsgFrom from;
		List<ElecCommonMsgFrom> elecCommonMsgList = new ArrayList<ElecCommonMsgFrom>();
		for(int i=0; i<list.size() && list!=null;i++){
			 from = new ElecCommonMsgFrom();
			ElecCommonMsg msg=	list.get(i);
			from.setComId(msg.getComId());
			from.setCreateDate(String.valueOf(msg.getCreateDate()!=null ? msg.getCreateDate():""));
			from.setStationRun(msg.getStationRun());
			from.setDevRun(msg.getDevRun());
			elecCommonMsgList.add(from)
;		}
		
		return elecCommonMsgList;
	}
	/**  
	* @Name: findElecCommonMsgListByCurrentDate
	* @Description: 通过当前日期查询待办事宜列表
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* @Parameters:null
	* @Return: List<ElecMenuFrom> 返回待办事宜结果集列表
	*/
	public List<ElecCommonMsgFrom> findElecCommonMsgListByCurrentDate() {
		//hibernate只支持日期类型
		java.sql.Date date = new java.sql.Date(new java.util.Date().getTime());
		String currentDate =date.toString();
	
		List<Object[]> list = dao.findElecCommonMsgListByCurrentDate(currentDate);
		List<ElecCommonMsgFrom> elecCommonMsList =this.elecCommonMsgObjectToVo(list);
		
		return elecCommonMsList;
	}
	/**  
	* @Name: elecCommonMsgObjectToVo
	* @Description: 将待办事宜object数组转换为Vo对象
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* @Parameters:object 【】 list
	* @Return: List<ElecMenuFrom> 返回待办事宜Vo结果集列表
	*/
	private List<ElecCommonMsgFrom> elecCommonMsgObjectToVo(List<Object[]> list) {
		ElecCommonMsgFrom from=null;
		List<ElecCommonMsgFrom> elecCommonMsList = new ArrayList<ElecCommonMsgFrom>();
		for(int i=0;i<list.size()&&list!=null;i++)
		{
			from = new ElecCommonMsgFrom();
			Object [] obj=list.get(i);
			from.setDevRun(obj[0].toString());
			from.setStationRun(obj[1].toString());
			elecCommonMsList.add(from);
		}
			return elecCommonMsList;
	}

}
