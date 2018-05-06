package cn.fly.elec.web.action;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ModelDriven;

import cn.fly.elec.container.ServiceProvide;
import cn.fly.elec.domain.ElecText;
import cn.fly.elec.service.IElecTextServiceDao;
import cn.fly.elec.util.StringHelp;
import cn.fly.elec.web.from.ElecTextFrom;

public class ElecTextAction extends BaseAction implements ModelDriven<ElecTextFrom>{
	
	private ElecTextFrom electFrom=new ElecTextFrom();
	public String save()
	{
		ElecText elecText=new ElecText();
		elecText.setTextName(electFrom.getTextName());
		elecText.setTextDate(StringHelp.stringConverDate(this.electFrom.getTextDate()));
		elecText.setTextRemark(electFrom.getTextRemark());
		IElecTextServiceDao dao=(IElecTextServiceDao) ServiceProvide.getServiceName(IElecTextServiceDao.SERVICE_NAME);
		dao.saveElecText(elecText);
		return "save";
	}
	public ElecTextFrom getModel() {
		
		return electFrom;
	}
}
