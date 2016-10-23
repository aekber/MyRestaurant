package com.eko.nerdeneyenir.dao;

import java.io.Serializable;

import com.eko.nerdeneyenir.model.FoodPopularity;

public interface IFoodPopularityDao extends IGenericDao<FoodPopularity, Serializable>, Serializable {

	public boolean isPopularityExist(int foodId, String deviceId);
	public void insertPopularity(FoodPopularity a);
	public void updatePopularity(FoodPopularity a);
	public long getPopularityByFood(int foodId);
	public void removePopularity(int foodId, String deviceId);
	public FoodPopularity findByFoodIdAndDeviceId(int foodId, String deviceId);
}
