package cn.fly.elec.container;

import org.apache.commons.lang.xwork.StringUtils;

public class ServiceProvide {
	public static ServiceProvideCrod spc = new ServiceProvideCrod();
	static{
		ServiceProvideCrod.load("beans.xml");
	}
	
	public static Object getServiceName(String serviceName)
	{
		if (StringUtils.isBlank(serviceName)) {
		      throw new RuntimeException("当前服务名称不存在");
		    }
		    Object object = null;
		    if (ServiceProvideCrod.ac.containsBean(serviceName)) {
		      object = ServiceProvideCrod.ac.getBean(serviceName);
		    }
		    if (object == null) {
		      throw new RuntimeException("当前服务名称【" + serviceName + "】下的服务节点不存在");
		    }
		    return object;
		
		
	}
	
	
}
