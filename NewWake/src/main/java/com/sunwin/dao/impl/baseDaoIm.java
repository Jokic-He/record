package com.sunwin.dao.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sunwin.dao.baseDaoI;

@SuppressWarnings("unchecked")
@Repository("baseDaoI")
public class baseDaoIm<T> implements baseDaoI<T>{
	
	@Autowired
	private SessionFactory sessionFactory;

	
	private Session getCurrentSession(){
		return this.sessionFactory.getCurrentSession();
	}
	
	public void save(T t) {
		this.getCurrentSession().save(t);
	}

	public void update(T t) {
		this.getCurrentSession().update(t);
		
	}

	public void delete(T t) {
		this.getCurrentSession().delete(t);
		
	}

	public T findById(Class<T> c, Serializable id) {
		return (T) this.getCurrentSession().get(c, id);
	}

	public T get(String hql) {
		return (T) this.getCurrentSession().createQuery(hql).uniqueResult();
	}

	public T get(String hql, Map<String,Object> param) {
		Query q=this.getCurrentSession().createQuery(hql);
		if(param!=null&param.size()>0){
			for(Map.Entry<String, Object> p:param.entrySet()){
				q.setParameter(p.getKey(), p.getValue());
			}
		}
		return (T) q.uniqueResult();
	}

	public List<T> find(String hql) {
		return  this.getCurrentSession().createQuery(hql).list();
	}

	public List<T> find(String hql, Map<String,Object> param) {
		Query q=this.getCurrentSession().createQuery(hql);
		if(param!=null&param.size()>0){
			for(Map.Entry<String, Object> p:param.entrySet()){
				q.setParameter(p.getKey(), p.getValue());
			}
		}
		return q.list();
	}

	public List<T> find(String hql, Integer page, Integer rows) {
		if(page == null || page < 1){
			page = 1;
		}
		
		if(rows == null || rows < 1){
			rows = 1;
		}
		return this.getCurrentSession().createQuery(hql).setFirstResult((page - 1)*rows).setMaxResults(rows).list();
	}

	public List<T> find(String hql, Map<String,Object> param, Integer page, Integer rows) {
		if(page == null || page < 1){
			page = 1;
		}
		
		if(rows == null || rows < 1){
			rows = 1;
		}
		
		Query q = this.getCurrentSession().createQuery(hql);
		if(param != null && param.size() > 0 ){
			for(Map.Entry<String, Object> p : param.entrySet()){
				q.setParameter(p.getKey(), p.getValue());
			}
		}

		return q.setFirstResult((page - 1)*rows).setMaxResults(rows).list();
	}

	public Long count(String hql) {
		return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
	}

	public Long count(String hql, Map<String,Object> param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if(param != null && param.size() > 0 ){
			for(Map.Entry<String, Object> p : param.entrySet()){
				q.setParameter(p.getKey(), p.getValue());
			}
		}
		return (Long) q.uniqueResult();
	}

}
