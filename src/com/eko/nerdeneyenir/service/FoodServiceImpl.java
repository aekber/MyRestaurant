package com.eko.nerdeneyenir.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eko.nerdeneyenir.dao.IFoodDao;
import com.eko.nerdeneyenir.model.Food;


public class FoodServiceImpl implements IFoodService {

	private IFoodDao foodDao;

	public void setFoodDao(IFoodDao foodDao) {
		this.foodDao = foodDao;
	}
	
	@Override
	@Transactional
	public void updateFood(Food a){
		foodDao.update(a);
	}


	@Override
	@Transactional
	public List<Food> getAllFoodsByCity(String city) {
		return foodDao.getAllFoodsByCity(city);
	}


	@Override
	@Transactional
	public Food findByFoodName(String Food) {
		return foodDao.findByFoodName(Food);
	}

	@Override
	@Transactional
	public void addNewFood(Food a) {
		foodDao.persist(a);		
	}


	@Override
	@Transactional
	public void deleteFood(Food a) {
		foodDao.delete(a);
	}

	@Override
	@Transactional
	public Food findByFoodId(Integer id) {
		return foodDao.findById(id);
	}

	@Override
	@Transactional
	public void mergeFood(Food a) {
		foodDao.merge(a);
	}
	
}
