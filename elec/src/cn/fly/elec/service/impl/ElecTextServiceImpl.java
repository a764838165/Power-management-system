package cn.fly.elec.service.impl;

import java.util.ArrayList;
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

import cn.fly.elec.dao.IElecTextDao;
import cn.fly.elec.domain.ElecText;
import cn.fly.elec.service.IElecTextServiceDao;
import cn.fly.elec.web.from.ElecTextFrom;
@Transactional(readOnly=true)
@Service(IElecTextServiceDao.SERVICE_NAME)
public class ElecTextServiceImpl implements IElecTextServiceDao{
	@Resource(name=IElecTextDao.SERVICE_NAME)
	private IElecTextDao dao;
	/**  
	* @Name: saveElecText
	* @Description: 保存ElecText对象
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* @Parameters:ElecText entity 对象
	* @Return: 无
	*/
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveElecText(ElecText entity) {
		dao.save(entity);
	}
	/**  
	* @Name: update
	* @Description: 修改对象的方法
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-23 （创建日期）
	* @Parameters: T entity 对象
	* @Return: 无
	*/
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void update(ElecText entity) {
		dao.update(entity);
	}
	/**  
	* @Name: findCollectionByConditionNoPage
	* @Description: 使用查询条件查询列表的集合（不分页）
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-23 （创建日期）
	* @Parameters: String hqlWhere hql语句的where条件
	*              Object[] params where条件的查询参数
	*              LinkedHashMap<String, String> orderby 排序条件
	* @Return: List<T> 结果集列表集合
	*/
	public List<ElecText> findfindCollectionByConditionNoPage(
			ElecTextFrom elecTextFrom) {
		/**
		 * 组织HQL语句的Where条件
		 *      select * from elec_text o where 1=1     放置DAO层
				and o.textName like '%张%'              放置Service层
				and o.textRemark like '%李%'
				order by o.textDate desc , o.textName asc 
		 */
		String hqlWhere="";
		List<String> list=new ArrayList<String>();
		if(StringUtils.isNotBlank(elecTextFrom.getTextName()) && elecTextFrom!=null)
		{
			hqlWhere+=" and o.textName like ? ";
			list.add("%"+elecTextFrom.getTextName()+"%");
		}
		if(StringUtils.isNotBlank(elecTextFrom.getTextRemark()) && elecTextFrom!=null)
		{
			hqlWhere+=" and o.textRemark like ? ";
			list.add("%"+elecTextFrom.getTextRemark()+"%");
		}
		Object [] params=list.toArray();
		LinkedHashMap<String, String> orderBy=new LinkedHashMap<String, String>();
		orderBy.put("o.textDate", "desc");
		orderBy.put("o.textName", "asc");
		//查询列表
				List<ElecText> lists = dao.findCollectionByConditionNoPage(hqlWhere,params,orderBy);
		
		return lists;
	}

}
