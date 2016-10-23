package com.eko.nerdeneyenir.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eko.nerdeneyenir.dao.IRestaurantDao;
import com.eko.nerdeneyenir.model.Restaurant;


public class RestaurantServiceImpl implements IRestaurantService {

	private IRestaurantDao restaurantDao;

	public void setRestaurantDao(IRestaurantDao restaurantDao) {
		this.restaurantDao = restaurantDao;
	}
	
	@Override
	@Transactional
	public void updateRestaurant(Restaurant a){
		restaurantDao.update(a);
	}


	@Override
	@Transactional
	public List<Restaurant> getAllRestaurants() {
		return restaurantDao.getAllRestaurants();
	}


	@Override
	@Transactional
	public Restaurant findByRestaurantName(String name) {
		return restaurantDao.findByRestaurantName(name);
	}

	@Override
	@Transactional
	public void addNewRestaurant(Restaurant a) {
		restaurantDao.persist(a);		
	}


	@Override
	@Transactional
	public void deleteRestaurant(Restaurant a) {
		restaurantDao.delete(a);
	}

	@Override
	@Transactional
	public void mergeRestaurant(Restaurant a) {
		restaurantDao.merge(a);
	}

	@Override
	@Transactional
	public Restaurant findById(Integer id) {
		return restaurantDao.findById(id);
	}
	
}
