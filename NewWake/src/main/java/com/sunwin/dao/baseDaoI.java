package com.sunwin.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface baseDaoI<T> {
	/**保存一个对象**/
	public void save(T t);
	
	/**更新一个对象**/
	public void update(T t);
	
	/**删除一个对象**/
	public void delete(T t);
	
	/**根据id查询一个对象**/
	public T findById(Class<T> c , Serializable id);
	
	/**根据HQL语句查询,返回一个对象**/
	public T get(String hql);
	
	/**根据HQL语句和参数查询,返回一个对象**/
	public T get(String hql,Map<String,Object> param);
	
	/**根据HQL语句查询,返回多个对象**/
	public List<T> find(String hql);
	
	/**根据HQL语句和传递的参数查询,返回多个对象**/
	public List<T> find(String hql,Map<String,Object> param);
	
	/**根据HQL语句查询,返回分好页的多个对象**/
	public List<T> find(String hql,Integer page,Integer rows);
	
	/**根据HQL语句和传递的参数查询,返回分好页的多个对象**/
	public List<T> find(String hql,Map<String,Object> param,Integer page,Integer rows);
	
	/**根据HQL语句,统计总数**/
	public Long count(String hql);
	
	/**根据HQL语句和指定参数,统计总数**/
	public Long count(String hql,Map<String,Object> param);
	
}
