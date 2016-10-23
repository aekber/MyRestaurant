package com.eko.nerdeneyenir.service;

import java.io.Serializable;
import java.util.List;

import com.eko.nerdeneyenir.model.Restaurant;


public interface IRestaurantService extends Serializable {

	public List<Restaurant> getAllRestaurants();
	public void addNewRestaurant(Restaurant a);
	public void updateRestaurant(Restaurant a);
	public void deleteRestaurant(Restaurant a);
	public void mergeRestaurant(Restaurant a);
	public Restaurant findByRestaurantName(String food);
	public Restaurant findById(Integer id);
}
