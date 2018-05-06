package cn.fly.elec.web.action;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;

import cn.fly.elec.container.ServiceProvide;
import cn.fly.elec.domain.ElecText;
import cn.fly.elec.service.IElecSystemDDlServiceDao;
import cn.fly.elec.service.IElecTextServiceDao;
import cn.fly.elec.service.IElecUserServiceDao;
import cn.fly.elec.util.StringHelp;
import cn.fly.elec.web.from.ElecSystemDDlFrom;
import cn.fly.elec.web.from.ElecTextFrom;
import cn.fly.elec.web.from.ElecUserFrom;

public class ElecUserAction extends BaseAction implements ModelDriven<ElecUserFrom>{
	IElecUserServiceDao elecuserdao = (IElecUserServiceDao) ServiceProvide.getServiceName(IElecUserServiceDao.SERVICE_NAME);
	IElecSystemDDlServiceDao elecSystemddl =(IElecSystemDDlServiceDao) ServiceProvide.getServiceName(IElecSystemDDlServiceDao.SERVICE_NAME);
	
	private ElecUserFrom elecUserFrom=new ElecUserFrom();
	
	public ElecUserFrom getModel() {
		
		return elecUserFrom;
	}
	/**  
	* @Name: home
	* @Description: 跳转到用户管理主页
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-23 （创建日期）
	* @Parameters: 无
	* @Return: String home 跳转到userIndex.jsp
	*/
	public String home()
	{
		List<ElecUserFrom> elecUserFromList = elecuserdao.findElecUserList(elecUserFrom);
		request.setAttribute("userList",elecUserFromList);
		return "home";
	}
	/**  
	* @Name: add
	* @Description: 跳转到添加用户页面
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-23 （创建日期）
	* @Parameters: 无
	* @Return: String home 跳转到userAdd.jsp
	*/
	public String add()
	{
		//使用数据类型查询对应的数据项以及内容
		List<ElecSystemDDlFrom> sexList = elecSystemddl.findElecSystemDDlListByKeyword("性别");
		List<ElecSystemDDlFrom> isdutyList = elecSystemddl.findElecSystemDDlListByKeyword("是否在职");
		List<ElecSystemDDlFrom> jctList = elecSystemddl.findElecSystemDDlListByKeyword("所属单位");
		request.setAttribute("sexList", sexList);
		request.setAttribute("jctList", jctList);
		request.setAttribute("isdutyList", isdutyList);
		
		return "add";
	}
	/**  
	* @Name: add
	* @Description: 跳转到添加用户页面
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-23 （创建日期）
	* @Parameters: 无
	* @Return: String home 跳转到userAdd.jsp
	*/
	public String edit()
	{
		return "edit";
	}
	/**  
	* @Name: save
	* @Description: 保存用户信息
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-29 （创建日期）
	* @Parameters: 无
	* @Return: String 重定向到userIndex。jsp
	*/
	public String save()
	{
		elecuserdao.saveElecUser(elecUserFrom);
		System.out.println("save  00");
		return "save";
	}
}
