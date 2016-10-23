package com.eko.nerdeneyenir.dao;

import java.io.Serializable;
import java.util.List;

import com.eko.nerdeneyenir.model.EkoUtil;
import com.eko.nerdeneyenir.model.Food;

public interface IFoodDao extends IGenericDao<Food, Serializable>, Serializable {

	public List<Food> getAllFoods();
	public List<String> getAdsCount();
	public List<Food> getAllFoodsByCity(String city);
	public List<Food> getAllFoodsByCoordinate(Float latitude, Float longitude);
	public void updateFood(Food a);
	public Food findByFoodName(String food);
	public List<Food> votedFoods(List<Food> list);
	public Food findByFoodId(Integer id);
	public List<Food> findByCityAndCategory(String city, String category,Float latitude, Float longitude);
}
