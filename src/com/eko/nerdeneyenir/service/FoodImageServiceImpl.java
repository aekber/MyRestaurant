package com.eko.nerdeneyenir.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.eko.nerdeneyenir.dao.IFoodImageDao;
import com.eko.nerdeneyenir.model.FoodImage;


public class FoodImageServiceImpl implements IFoodImageService {

	private IFoodImageDao foodImageDao;
	
	public void setFoodImageDao(IFoodImageDao foodImageDao) {
		this.foodImageDao = foodImageDao;
	}


	@Override
	@Transactional
	public void updateFoodImage(FoodImage a){
		foodImageDao.update(a);
	}


	@Override
	@Transactional
	public List<FoodImage> getAllFoodImages() {
		return foodImageDao.getAllFoodImages();
	}

	@Override
	@Transactional
	public void addNewFoodImage(FoodImage a) {
		foodImageDao.persist(a);		
	}


	@Override
	@Transactional
	public void deleteFoodImage(FoodImage a) {
		foodImageDao.delete(a);
	}

	@Override
	@Transactional
	public FoodImage findByFoodImageId(Integer id) {
		return foodImageDao.findById(id);
	}

	@Override
	@Transactional
	public void mergeFoodImage(FoodImage a) {
		foodImageDao.merge(a);
	}
	
}
