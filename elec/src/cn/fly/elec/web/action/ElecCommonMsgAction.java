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
import cn.fly.elec.service.IElecTextServiceDao;
import cn.fly.elec.util.StringHelp;
import cn.fly.elec.web.from.ElecCommonMsgFrom;
import cn.fly.elec.web.from.ElecTextFrom;

public class ElecCommonMsgAction extends BaseAction implements ModelDriven<ElecCommonMsgFrom>{
	
	private IElecCommonMsgServiceDao elecCommonMsgService=(IElecCommonMsgServiceDao) ServiceProvide.getServiceName(IElecCommonMsgServiceDao.SERVICE_NAME);
	
	private ElecCommonMsgFrom elecCommomMsgFrom=new ElecCommonMsgFrom();
	
	public ElecCommonMsgFrom getModel() {
		
		return elecCommomMsgFrom;
	}
	/**  
	* @Name: home
	* @Description: 跳转待办事宜页面
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-23 （创建日期）
	* @Parameters: null
	* @Return: page/system/actingIndex.jsp
	*/
	public String home()
	{
		List<ElecCommonMsgFrom> list = elecCommonMsgService.findElecCommonMsgList();
		
		request.setAttribute("commonList", list);
		return "home";
	}
	/**  
	* @Name: save
	* @Description:保存待办事宜页面
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-23 （创建日期）
	* @Parameters: null
	* @Return: page/system/actingIndex.jsp
	*/
	public String save()
	{
	
		elecCommonMsgService.saveCommonMsg(elecCommomMsgFrom);
		return "save";
	}
}
