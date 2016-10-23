package com.eko.nerdeneyenir.dao;

import java.io.Serializable;
import java.util.List;

import com.eko.nerdeneyenir.model.Restaurant;

public interface IRestaurantDao extends IGenericDao<Restaurant, Serializable>, Serializable {

	public List<Restaurant> getAllRestaurants();
	public void updateRestaurant(Restaurant a);
	public Restaurant findByRestaurantName(String food);
}
