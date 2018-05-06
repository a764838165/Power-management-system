package cn.fly.elec.web.action;

import java.util.Date;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;

import cn.fly.elec.container.ServiceProvide;
import cn.fly.elec.domain.ElecCommonMsg;
import cn.fly.elec.domain.ElecText;
import cn.fly.elec.service.IElecCommonMsgServiceDao;
import cn.fly.elec.service.IElecSystemDDlServiceDao;
import cn.fly.elec.service.IElecTextServiceDao;
import cn.fly.elec.util.StringHelp;
import cn.fly.elec.web.from.ElecCommonMsgFrom;
import cn.fly.elec.web.from.ElecSystemDDlFrom;
import cn.fly.elec.web.from.ElecTextFrom;

public class ElecSystemDDlAction extends BaseAction implements ModelDriven<ElecSystemDDlFrom>{
	
	private IElecSystemDDlServiceDao systemDDlServiceDao =(IElecSystemDDlServiceDao) ServiceProvide.getServiceName(IElecSystemDDlServiceDao.SERVICE_NAME);
	
	private ElecSystemDDlFrom systemDDlFrom=new ElecSystemDDlFrom();
	
	public ElecSystemDDlFrom getModel() {
		
		return systemDDlFrom;
	}
	/**  
	* @Name: home
	* @Description: 跳转数据字典页面
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-23 （创建日期）
	* @Parameters: null
	* @Return: page/system/actingIndex.jsp
	*/
	public String home()
	{
		List<ElecSystemDDlFrom> list = systemDDlServiceDao.findKeyWord();
		
		request.setAttribute("systemList", list);
		return "home";
	}
	/**  
	* @Name: edit
	* @Description: 跳转数据字典编辑页面
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-23 （创建日期）
	* @Parameters: null
	* @Return: page/system/actingEdit.jsp
	*/
	public String edit()
	{
		//获取数据类型
				String keyword = systemDDlFrom.getKeyword();
				List<ElecSystemDDlFrom> list = systemDDlServiceDao.findElecSystemDDlListByKeyword(keyword);
				request.setAttribute("systemList", list);
				return "edit";
	}
	/**  
	* @Name: save
	* @Description: 保存数据字典
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-23 （创建日期）
	* @Parameters: null
	* @Return: 重定向page/system/actingEdit.jsp
	*/
	public String save()
	{
			
			systemDDlServiceDao.saveElecSystemDDl(systemDDlFrom);
			return "save";
	}
	
}
