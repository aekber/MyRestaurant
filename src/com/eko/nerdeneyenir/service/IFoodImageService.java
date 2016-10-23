package com.eko.nerdeneyenir.service;

import java.io.Serializable;
import java.util.List;

import com.eko.nerdeneyenir.model.FoodImage;


public interface IFoodImageService extends Serializable {

	public List<FoodImage> getAllFoodImages();
	public void addNewFoodImage(FoodImage a);
	public void updateFoodImage(FoodImage a);
	public void deleteFoodImage(FoodImage a);
	public void mergeFoodImage(FoodImage a);
	public FoodImage findByFoodImageId(Integer id);
}
