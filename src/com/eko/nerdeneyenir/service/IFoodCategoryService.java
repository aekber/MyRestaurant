package com.eko.nerdeneyenir.service;

import java.io.Serializable;
import java.util.List;

import com.eko.nerdeneyenir.model.Food;
import com.eko.nerdeneyenir.model.FoodCategory;


public interface IFoodCategoryService extends Serializable {

	public List<FoodCategory> getAllFoodCategories();
	public void addNewFoodCategory(FoodCategory a);
	public void updateFoodCategory(FoodCategory a);
	public void deleteFoodCategory(FoodCategory a);
	public void mergeFoodCategory(FoodCategory a);
	public FoodCategory findByFoodCategoryName(String food);
	public FoodCategory findById(Integer id);
}
