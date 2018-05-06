package cn.fly.elec.container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceProvideCrod {

	protected static ApplicationContext ac;
	public static void load(String fileName)
	{
		ac=new ClassPathXmlApplicationContext(fileName);
	}
}
