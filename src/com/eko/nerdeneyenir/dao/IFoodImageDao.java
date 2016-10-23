package com.eko.nerdeneyenir.dao;

import java.io.Serializable;
import java.util.List;

import com.eko.nerdeneyenir.model.Food;
import com.eko.nerdeneyenir.model.FoodImage;

public interface IFoodImageDao extends IGenericDao<FoodImage, Serializable>, Serializable {

	public List<FoodImage> getAllFoodImages();
	public void updateFoodImage(FoodImage a);
	public FoodImage findByFoodImageId(Integer id);
}
