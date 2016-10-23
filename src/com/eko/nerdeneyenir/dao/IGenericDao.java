package com.eko.nerdeneyenir.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.Criterion;


public interface IGenericDao <T, ID extends Serializable> extends Serializable {
	
	public List<T> findByExample(T example);

    public List<T> findByCriteria(Criterion... criteria);

	public void persist(T transientInstance);

	public void update(T persistentInstance);

	public void saveOrUpdate(T persistentInstance);

	public void delete(T persistentInstance);
	
	public void merge(T persistentInstance);
	
	public T findById(Integer id);
}

