package com.eko.nerdeneyenir.service;

import java.io.Serializable;
import java.util.List;

import com.eko.nerdeneyenir.model.Food;


public interface IFoodService extends Serializable {

	public List<Food> getAllFoodsByCity(String city);
	public void addNewFood(Food a);
	public void updateFood(Food a);
	public void deleteFood(Food a);
	public void mergeFood(Food a);
	public Food findByFoodName(String Food);
	public Food findByFoodId(Integer id);
}
