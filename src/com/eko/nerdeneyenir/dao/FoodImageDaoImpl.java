package com.eko.nerdeneyenir.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.eko.nerdeneyenir.model.FoodImage;


public class FoodImageDaoImpl extends GenericDaoHibernate<FoodImage, Serializable> implements IFoodImageDao {
	
	
	public FoodImageDaoImpl() {
		super(FoodImage.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<FoodImage> getAllFoodImages() {
		
		Query q = getSession().createQuery("from FoodImage f");		
		List<FoodImage> list = q.setCacheable(true).list();		
		
		return list;
	}

	@Override
	public void updateFoodImage(FoodImage food) {
		update(food);		
	}

	@Override
	public FoodImage findByFoodImageId(Integer id) {
		return findById(id);
	}

}
