package cn.fly.elec.jutil;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.classic.Session;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.fly.elec.container.ServiceProvide;
import cn.fly.elec.dao.IElecCommonMsgDao;
import cn.fly.elec.dao.IElecSystemDDlDao;
import cn.fly.elec.dao.IElecTextDao;
import cn.fly.elec.dao.IElecUserDao;
import cn.fly.elec.dao.impl.CommomImpl;
import cn.fly.elec.dao.impl.ElecSystemDDlDaoImpl;
import cn.fly.elec.domain.ElecCommonMsg;
import cn.fly.elec.domain.ElecSystemDDl;
import cn.fly.elec.domain.ElecText;
import cn.fly.elec.domain.ElecUser;
import cn.fly.elec.service.IElecCommonMsgServiceDao;
import cn.fly.elec.service.IElecTextServiceDao;
import cn.fly.elec.service.IElecUserServiceDao;
import cn.fly.elec.web.from.ElecTextFrom;

public class TestAll {

	@Test
	public void TestHibernate()
	{
		Configuration cf=new Configuration();
		cf.configure();
		SessionFactory sessionFactory = cf.buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		Transaction transaction = session.getTransaction();
		
		ElecText object = (ElecText) session.get(ElecText.class, "4028808d60960a670160960a79830001");
		System.out.println(object);
		session.close();
		
	}
	@Test
	public void Testsave()
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("beans.xml");
		IElecUserServiceDao ie=(IElecUserServiceDao) ac.getBean(IElecUserServiceDao.SERVICE_NAME);
		ElecUser entity=new ElecUser();
		entity.setAddress("sd");
		//ie.saveElecText(entity);
	}
	@Test
	public void updateElect()
	{
		IElecTextServiceDao dao=(IElecTextServiceDao) ServiceProvide.getServiceName(IElecTextServiceDao.SERVICE_NAME);
		ElecText elecText=new ElecText();
		elecText.setTextID("4028808d60960a670160960a79830001");
		elecText.setTextName("oooo");
		dao.update(elecText);
	}
	@Test
	public void findByIdElect()
	{
		IElecTextDao dao=(IElecTextDao) ServiceProvide.getServiceName(IElecTextDao.SERVICE_NAME);
		ElecText text=dao.findObjectByID("4028808d60960a670160960a79830001");
		System.out.println(text);
		
	}
	@Test
	public void deleteByIds()
	{
		IElecTextDao dao=(IElecTextDao) ServiceProvide.getServiceName(IElecTextDao.SERVICE_NAME);
		
		Serializable[] s={"4028808d60960a670160960a79830001","4028808d6096f8c6016096f8ccd60001"};
		dao.deleteObjectByIDs(s);
		
		
	}
	@Test
	public void findCollection(){
		IElecTextServiceDao elecTextService = (IElecTextServiceDao)ServiceProvide.getServiceName(IElecTextServiceDao.SERVICE_NAME);
		//实例化PO对象，赋值，执行保存
		ElecTextFrom elecTextForm = new ElecTextFrom();
		elecTextForm.setTextName("2");
		elecTextForm.setTextRemark("2");
		List<ElecText> list = elecTextService.findfindCollectionByConditionNoPage(elecTextForm);
		for(int i=0;i<list.size();i++)
		{
			ElecText elecText=list.get(i);
			System.out.println(elecText.getTextName());
		}
	}
	
	@Test
	public void TestsaveC()
	{
		IElecCommonMsgServiceDao ie=(IElecCommonMsgServiceDao) ServiceProvide.getServiceName(IElecCommonMsgServiceDao.SERVICE_NAME);
		ElecCommonMsg msg=new ElecCommonMsg();
		msg.setCreateDate(new Date());
		msg.setDevRun("123");
		msg.setStationRun("good b");
		
	}
	@Test
	public void TestsaveSystemddl()
	{
		IElecSystemDDlDao ie=(IElecSystemDDlDao) ServiceProvide.getServiceName(IElecSystemDDlDao.SERVICE_NAME);
		ElecSystemDDl ddl = new ElecSystemDDl();
		
		
	}
	@Test
	public void TestsaveSystemdd1l()
	{
		
	}
}
