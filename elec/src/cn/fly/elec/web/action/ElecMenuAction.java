package cn.fly.elec.web.action;

import java.util.List;

import cn.fly.elec.container.ServiceProvide;
import cn.fly.elec.dao.IElecCommonMsgDao;
import cn.fly.elec.service.IElecCommonMsgServiceDao;
import cn.fly.elec.service.IElecTextServiceDao;
import cn.fly.elec.web.from.ElecCommonMsgFrom;
import cn.fly.elec.web.from.ElecMenuFrom;

import com.opensymphony.xwork2.ModelDriven;

public class ElecMenuAction extends BaseAction implements ModelDriven<ElecMenuFrom>{
	
	private IElecCommonMsgServiceDao dao = (IElecCommonMsgServiceDao) ServiceProvide.getServiceName(IElecCommonMsgServiceDao.SERVICE_NAME);
	ElecMenuFrom from=new ElecMenuFrom();
	public ElecMenuFrom getModel() {
		// TODO Auto-generated method stub
		return this.from;
	}

	public String home(){
		return "home";
	}
	
	public String title(){
		return "title";
	}
	
	public String left(){
		return "left";
	}
	
	public String change1(){
		return "change1";
	}
	
	public String loading(){
		return "loading";
	}
	
	public String alermJX(){
		return "alermJX";
	}public String alermYS(){
		return "alermYS";
	}
	
	
	/**  
	* @Name: alermSB
	* @Description: 查询当天的设备运行情况 
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-23 （创建日期）
	* @Parameters: 无
	* @Return: String alermSB 跳转到alermSB.jsp
	*/
	public String alermSB(){
		List<ElecCommonMsgFrom>	list = dao.findElecCommonMsgListByCurrentDate();
		request.setAttribute("commonList", list);
		return "alermSB";
	}
	
	public String alermXZ(){
		return "alermXZ";
	}
	/**  
	* @Name: alermZD
	* @Description: 查询当天的站点运行情况 
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-23（创建日期）
	* @Parameters: 无
	* @Return: String alermZD 跳转到alermZD.jsp
	*/
	public String alermZD(){
		
	List<ElecCommonMsgFrom>	list = dao.findElecCommonMsgListByCurrentDate();
	request.setAttribute("commonList", list);
	return "alermZD";
	}
	
	
}
