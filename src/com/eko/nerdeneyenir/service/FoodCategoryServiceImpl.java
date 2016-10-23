package com.eko.nerdeneyenir.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eko.nerdeneyenir.dao.IFoodCategoryDao;
import com.eko.nerdeneyenir.model.FoodCategory;


public class FoodCategoryServiceImpl implements IFoodCategoryService {

	private IFoodCategoryDao foodCategoryDao;
	
	public void setFoodCategoryDao(IFoodCategoryDao foodCategoryDao) {
		this.foodCategoryDao = foodCategoryDao;
	}


	@Override
	@Transactional
	public void updateFoodCategory(FoodCategory a){
		foodCategoryDao.update(a);
	}


	@Override
	@Transactional
	public List<FoodCategory> getAllFoodCategories() {
		return foodCategoryDao.getAllFoodCategories();
	}


	@Override
	@Transactional
	public FoodCategory findByFoodCategoryName(String food) {
		return foodCategoryDao.findByFoodCategoryName(food);
	}

	@Override
	@Transactional
	public void addNewFoodCategory(FoodCategory a) {
		foodCategoryDao.persist(a);		
	}

	@Override
	@Transactional
	public void deleteFoodCategory(FoodCategory a) {
		foodCategoryDao.delete(a);
	}


	@Override
	@Transactional
	public void mergeFoodCategory(FoodCategory a) {
		foodCategoryDao.merge(a);
	}


	@Override
	@Transactional
	public FoodCategory findById(Integer id) {
		return foodCategoryDao.findById(id);
	}
	
}
