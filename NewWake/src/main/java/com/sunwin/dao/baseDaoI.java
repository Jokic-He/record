package com.sunwin.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface baseDaoI<T> {
	/**����һ������**/
	public void save(T t);
	
	/**����һ������**/
	public void update(T t);
	
	/**ɾ��һ������**/
	public void delete(T t);
	
	/**����id��ѯһ������**/
	public T findById(Class<T> c , Serializable id);
	
	/**����HQL����ѯ,����һ������**/
	public T get(String hql);
	
	/**����HQL���Ͳ�����ѯ,����һ������**/
	public T get(String hql,Map<String,Object> param);
	
	/**����HQL����ѯ,���ض������**/
	public List<T> find(String hql);
	
	/**����HQL���ʹ��ݵĲ�����ѯ,���ض������**/
	public List<T> find(String hql,Map<String,Object> param);
	
	/**����HQL����ѯ,���طֺ�ҳ�Ķ������**/
	public List<T> find(String hql,Integer page,Integer rows);
	
	/**����HQL���ʹ��ݵĲ�����ѯ,���طֺ�ҳ�Ķ������**/
	public List<T> find(String hql,Map<String,Object> param,Integer page,Integer rows);
	
	/**����HQL���,ͳ������**/
	public Long count(String hql);
	
	/**����HQL����ָ������,ͳ������**/
	public Long count(String hql,Map<String,Object> param);
	
}
