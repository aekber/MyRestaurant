package com.eko.nerdeneyenir.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.eko.nerdeneyenir.model.Restaurant;


public class RestaurantDaoImpl extends GenericDaoHibernate<Restaurant, Serializable> implements IRestaurantDao {
	
	
	public RestaurantDaoImpl() {
		super(Restaurant.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Restaurant> getAllRestaurants() {
		
		Query q = getSession().createQuery("from Restaurant r");		
		List<Restaurant> list = q.setCacheable(true).list();		
		
		return list;
	}

	@Override
	public Restaurant findByRestaurantName(String food) {
		Query q = getSession().createQuery("from Restaurant f where f.name = :name");
		q.setString("name", food);
		
		return (Restaurant) q.setCacheable(true).uniqueResult();
	}

	@Override
	public void updateRestaurant(Restaurant food) {
		update(food);		
	}

	@Override
	public Restaurant findById(Integer id) {
		return super.findById(id);
	}


}
