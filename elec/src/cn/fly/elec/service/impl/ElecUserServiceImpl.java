package cn.fly.elec.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.naming.LinkLoopException;

import org.apache.commons.collections.map.LinkedMap;
import org.apache.commons.lang.xwork.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cn.fly.elec.dao.IElecSystemDDlDao;
import cn.fly.elec.dao.IElecTextDao;
import cn.fly.elec.dao.IElecUserDao;
import cn.fly.elec.domain.ElecText;
import cn.fly.elec.domain.ElecUser;
import cn.fly.elec.service.IElecTextServiceDao;
import cn.fly.elec.service.IElecUserServiceDao;
import cn.fly.elec.util.StringHelp;
import cn.fly.elec.web.from.ElecTextFrom;
import cn.fly.elec.web.from.ElecUserFrom;
@Transactional(readOnly=true)
@Service(IElecUserServiceDao.SERVICE_NAME)
public class ElecUserServiceImpl implements IElecUserServiceDao{
	@Resource(name=IElecUserDao.SERVICE_NAME)
	private IElecUserDao dao;
	
	@Resource(name=IElecSystemDDlDao.SERVICE_NAME)
	private IElecSystemDDlDao elecSystemdao;
	/**  
	* @Name: saveElecText
	* @Description: 保存ElecText对象
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-22 （创建日期）
	* @Parameters:ElecText entity 对象
	* @Return: 无
	*/
	
	/**  
	* @Name: findElecUserList
	* @Description: 查询用户列表信息，判断用户姓名是否为空，不为空侧按照姓名组织条件
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-28（创建日期）
	* @Parameters:ElecUserFrom entity 对象
	* @Return: List<ElecUserFrom>
	*/
	public List<ElecUserFrom> findElecUserList(ElecUserFrom elecUserFrom) {
		
		String hqlWhere = "";
		List<String> paramsList =new ArrayList<String>();
		if(elecUserFrom!=null && elecUserFrom.getUserName()!=null && !elecUserFrom.getUserName().equals(""))
		{
			hqlWhere += " and o.userName like ? ";
			paramsList.add("%"+elecUserFrom.getUserName()+"%");
		}
		Object[] params = paramsList.toArray();
		//组织排序
		LinkedHashMap<String, String> orderby =new LinkedHashMap<String, String>();
		orderby.put("o.onDutyDate", "desc");
		List<ElecUser> list =dao.findCollectionByConditionNoPage(hqlWhere, params, orderby);
		List<ElecUserFrom> fromList =this.elecUserPoListToVoList(list);
		return fromList;
	}
	/**  
	* @Name: elecUserPoListToVoList
	* @Description: ElecUser  Po转Vo对象
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-28（创建日期）
	* @Parameters:List<ElecUser> list 对象集合
	* @Return: List<ElecUserFrom>
	*/
	private List<ElecUserFrom> elecUserPoListToVoList(List<ElecUser> list) {
		ElecUserFrom from =null;
		List<ElecUserFrom> fromList =new ArrayList<ElecUserFrom>();
		for(int i=0; i<list.size()&&list!=null;i++)
		{
			ElecUser user=list.get(i);
			from = new ElecUserFrom();
			from.setUserID(user.getUserID());
			from.setLogonName(user.getLogonName());
			from.setUserName(user.getUserName());
			from.setSexID(user.getSexID()!=null && !user.getSexID().equals("")?elecSystemdao.findDDlName(user.getSexID(),"性别"):"");
			from.setIsDuty(user.getIsDuty()!=null && !user.getIsDuty().equals("")?elecSystemdao.findDDlName(user.getIsDuty(),"是否在职"):"");
			from.setContactTel(user.getContactTel());
			fromList.add(from);
		}
		
		return fromList;
	}
	/**  
	* @Name: saveElecUser
	* @Description: 保存用户信息
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-28（创建日期）
	* @Parameters:List<ElecUser> 值对象
	* @Return: null
	*/
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED,readOnly=false)
	public void saveElecUser(ElecUserFrom elecUserFrom) {
	
		ElecUser user = this.VoToPo(elecUserFrom);
		dao.save(user);
	
	}
	/**  
	* @Name: VoToPo
	* @Description: ElecUser  vo to po
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-28（创建日期）
	* @Parameters:ElecUserFrom elecUserFrom
	* @Return: null
	*/
	private ElecUser VoToPo(ElecUserFrom elecUserForm) {
		ElecUser elecUser = new ElecUser();
		if(elecUserForm!=null){
			if(elecUserForm.getUserID()!=null && !elecUserForm.getUserID().equals("")){
				elecUser.setUserID(elecUserForm.getUserID());
				if(elecUserForm.getOffDutyDate()!=null && !elecUserForm.getOffDutyDate().equals("")){
					elecUser.setOffDutyDate(StringHelp.stringConverDate(elecUserForm.getOffDutyDate()));
				}
			}
			elecUser.setJctID(elecUserForm.getJctID());
			elecUser.setUserName(elecUserForm.getUserName());
			elecUser.setLogonName(elecUserForm.getLogonName());
			elecUser.setLogonPwd(elecUserForm.getLogonPwd());
			elecUser.setSexID(elecUserForm.getSexID());
			if(elecUserForm.getBirthday()!=null && !elecUserForm.getBirthday().equals("")){
				elecUser.setBirthday(StringHelp.stringConverDate(elecUserForm.getBirthday()));
			}
			elecUser.setAddress(elecUserForm.getAddress());
			elecUser.setContactTel(elecUserForm.getContactTel());
			elecUser.setEmail(elecUserForm.getEmail());
			elecUser.setMobile(elecUserForm.getMobile());
			elecUser.setIsDuty(elecUserForm.getIsDuty());
			if(elecUserForm.getOnDutyDate()!=null && !elecUserForm.getOnDutyDate().equals("")){
				elecUser.setOnDutyDate(StringHelp.stringConverDate(elecUserForm.getOnDutyDate()));
			}
			elecUser.setRemark(elecUserForm.getRemark());
		}
		return elecUser;
	}
	/**  
	* @Name: elecUserPOToVO
	* @Description: 获取用户的详细信息，从PO对象转换成VO对象
	* @Author: 兰超平（作者）
	* @Version: V1.00 （版本号）
	* @Create Date: 2017-12-29（创建日期）
	* @Parameters: ElecUser elecUser PO对象存放用户详细信息
	* @Return: ElecUserForm VO对象存放用户的详细信息
	*/
	private ElecUserFrom elecUserPOToVO(ElecUser elecUser,ElecUserFrom elecUserForm) {
		//ElecUserForm elecUserForm = new ElecUserForm();
		if(elecUser!=null){
			elecUserForm.setUserID(elecUser.getUserID());
			elecUserForm.setJctID(elecUser.getJctID());
			elecUserForm.setUserName(elecUser.getUserName());
			elecUserForm.setLogonName(elecUser.getLogonName());
			elecUserForm.setLogonPwd(elecUser.getLogonPwd());
			elecUserForm.setSexID(elecUser.getSexID());
			elecUserForm.setBirthday(String.valueOf(elecUser.getBirthday()!=null && !elecUser.getBirthday().equals("")?elecUser.getBirthday():""));
			elecUserForm.setAddress(elecUser.getAddress());
			elecUserForm.setContactTel(elecUser.getContactTel());
			elecUserForm.setEmail(elecUser.getEmail());
			elecUserForm.setMobile(elecUser.getMobile());
			elecUserForm.setIsDuty(elecUser.getIsDuty());
			elecUserForm.setOnDutyDate(String.valueOf(elecUser.getOnDutyDate()!=null && !elecUser.getOnDutyDate().equals("")?elecUser.getOnDutyDate():""));
			elecUserForm.setOffDutyDate(String.valueOf(elecUser.getOffDutyDate()!=null && !elecUser.getOffDutyDate().equals("")?elecUser.getOffDutyDate():""));
			elecUserForm.setRemark(elecUser.getRemark());
		}
		return elecUserForm;
	}
	
	
}
