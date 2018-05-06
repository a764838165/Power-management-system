package cn.fly.elec.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class GenericSuperClass {

	public static Class getClass(Class tClass)
	{
		ParameterizedType pt = (ParameterizedType) tClass.getGenericSuperclass();
		Class entrity=(Class) pt.getActualTypeArguments()[0];
		return entrity;
	}
}
