package com.eko.nerdeneyenir.dao;

import java.io.Serializable;
import java.util.List;

import com.eko.nerdeneyenir.model.FoodCategory;

public interface IFoodCategoryDao extends IGenericDao<FoodCategory, Serializable>,Serializable {

	public List<FoodCategory> getAllFoodCategories();
	public List<String> getAllCategories();
	public void updateFoodCategory(FoodCategory a);
	public FoodCategory findByFoodCategoryName(String food);
}
