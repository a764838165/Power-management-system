package cn.fly.elec.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;

public interface ICommomDao<T> {
	public void save(T entity);
	void update(T entity);
	public void saveObjectByCollection(Collection<T> t);
	T findObjectByID(Serializable id);
	void deleteObjectByIDs(Serializable ... ids);
	void deleteObjectByCollection(Collection<T> entities);
	List<T> findCollectionByConditionNoPage(String hqlWhere,
	Object[] params, LinkedHashMap<String, String> orderby);
}
