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
import org.omg.CORBA.portable.ValueOutputStream;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.fly.elec.dao.IElecCommonMsgDao;
import cn.fly.elec.dao.IElecSystemDDlDao;
import cn.fly.elec.dao.IElecTextDao;
import cn.fly.elec.domain.ElecCommonMsg;
import cn.fly.elec.domain.ElecSystemDDl;
import cn.fly.elec.domain.ElecText;
import cn.fly.elec.service.IElecCommonMsgServiceDao;
import cn.fly.elec.service.IElecSystemDDlServiceDao;
import cn.fly.elec.service.IElecTextServiceDao;
import cn.fly.elec.web.from.ElecCommonMsgFrom;
import cn.fly.elec.web.from.ElecMenuFrom;
import cn.fly.elec.web.from.ElecSystemDDlFrom;
import cn.fly.elec.web.from.ElecTextFrom;
@Transactional(readOnly=true)
@Service(IElecSystemDDlServiceDao.SERVICE_NAME)
public class ElecSystemDDlServiceImpl implements IElecSystemDDlServiceDao{
	@Resource(name=IElecSystemDDlDao.SERVICE_NAME)
	private IElecSystemDDlDao dao;
	/**  
	* @Name: saveCommonMsg
	* @Description: 保存ElecCommonMsg对象
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* ElecCommonMsgFrom entity 对象
	* @Return: 无
	*/
	//@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	/**  
	* @Name:findKeyWord
	* @Description: 查询数据类型关键字
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* 
	* @Return: List<ElecSystemDDlFrom>
	*/
	public List<ElecSystemDDlFrom> findKeyWord() {
	
		List<Object> list = dao.findKeyWord();
		List<ElecSystemDDlFrom> fromList =this.elecSystemDDlObjectToVoList(list);
		return fromList;
	}
	/**  
	* elecSystemDDlObjectToVoList
	* @Description: 数组对象转vo对象
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* @param  list<object>
	* @Return: List<ElecSystemDDlFrom>
	*/
	private List<ElecSystemDDlFrom> elecSystemDDlObjectToVoList(
			List<Object> list) {
		List<ElecSystemDDlFrom> fromList = new ArrayList<ElecSystemDDlFrom>();
		ElecSystemDDlFrom from = null;
		for(int i=0; i<list.size() && list!=null;i++)
		{
			Object object = list.get(i);
			from = new ElecSystemDDlFrom();
			from.setKeyword(object.toString());
			fromList.add(from);
		}
		return fromList;
	}
	/**  
	* findElecSystemDDlListByKeyWord
	* @Description: 根据选中的数据类型查询对应的数据项
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* @param  KeyWord
	* @Return: List<ElecSystemDDlFrom> 对应数据项的vo集合
	*/
	private List<ElecSystemDDl> findSystemDDlListByCondition(String keyword) {
		String hqlWhere = " and o.keyword = ?";
		Object [] params = {keyword};
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("o.ddlCode", "asc");
		List<ElecSystemDDl> list = dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		return list;
	}
	/**  
	* @Name: elecSystemDDlPOListToVOList
	* @Description: 数据项的集合列表从PO对象转化成VO对象
	* @Author: lan（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-25 （创建日期）
	* @Parameters: List<ElecSystemDDl> list 存放PO集合
	* @Return: List<ElecSystemDDlForm> 对应数据项的VO集合
	*/
	private List<ElecSystemDDlFrom> elecSystemDDlPOListToVOList(
			List<ElecSystemDDl> list) {
		List<ElecSystemDDlFrom> formList = new ArrayList<ElecSystemDDlFrom>();
		ElecSystemDDlFrom elecSystemDDlForm = null;
		for(int i=0;list!=null && i<list.size();i++){
			ElecSystemDDl elecSystemDDl = list.get(i);
			elecSystemDDlForm = new ElecSystemDDlFrom();
			elecSystemDDlForm.setSeqID(String.valueOf(elecSystemDDl.getSeqID()));
			elecSystemDDlForm.setKeyword(elecSystemDDl.getKeyword());
			elecSystemDDlForm.setDdlCode(String.valueOf(elecSystemDDl.getDdlCode()));
			elecSystemDDlForm.setDdlName(elecSystemDDl.getDdlName());
			formList.add(elecSystemDDlForm);
		}
		return formList;
	}
	/**  
	* @Name: findElecSystemDDlListByKeyword
	* @Description: 通过数据类型查询
	* @Author: lan（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-25 （创建日期）
	* @Parameters: List<ElecSystemDDl> list 存放PO集合
	* @Return: List<ElecSystemDDlForm> 对应数据项的VO集合
	*/
	public List<ElecSystemDDlFrom> findElecSystemDDlListByKeyword(String keyword) {
		List<ElecSystemDDl> list = this.findSystemDDlListByCondition(keyword);
		List<ElecSystemDDlFrom> formList = this.elecSystemDDlPOListToVOList(list);
		return formList;
	}
	/**  
	* @Name: saveElecSystemDDl
	* @Description: 保存数据字典:数据类型、数据项、数据编号
	* @Author: lan（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-25 （创建日期）
	* @Parameters: ElecSystemDDlForm 页面的表单
	* @Return:null
	*/
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveElecSystemDDl(ElecSystemDDlFrom systemDDlFrom) {
		
		String keyword = systemDDlFrom.getKeywordname();
		String typeflag = systemDDlFrom.getTypeflag();
		String [] itemname = systemDDlFrom.getItemname();
		
		//新增类型typeflag = new 
		if(typeflag != null && typeflag.equals("new"))
		{
			this.saveSystemDDlWidthParams(keyword,itemname);
		}else
		{
			List<ElecSystemDDl> list = this.findSystemDDlListByCondition(keyword);
			dao.deleteObjectByCollection(list);
			this.saveSystemDDlWidthParams(keyword, itemname);
		}
		
		
		
	}
	/**  
	* @Name: saveSystemDDlWidthParams
	* @Description: 通过参数保存数据字典
	* @Author: lan（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-25 （创建日期）
	* @Parameters: 
	* @Return:null
	*/
	private void saveSystemDDlWidthParams(String keyword, String[] itemname) {
		
		ElecSystemDDl dDl =null;
		List<ElecSystemDDl> list = new ArrayList<ElecSystemDDl>();
		for(int i=0;itemname!=null&&itemname.length>i;i++)
		{
			dDl = new ElecSystemDDl();
			dDl.setKeyword(keyword);
			dDl.setDdlCode(new Integer(i+1));
			dDl.setDdlName(itemname[i]);
			list.add(dDl);
		}
		dao.saveObjectByCollection(list);
		
	}
	
	

}
