package com.eko.nerdeneyenir.restful;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eko.nerdeneyenir.dao.IFoodCategoryDao;
import com.eko.nerdeneyenir.model.FoodCategory;

@Component
@Path("/categories")
@Produces(MediaType.APPLICATION_JSON +";charset=utf-8")
public class FoodCategoryResource {

	@Autowired
	private IFoodCategoryDao foodCategoryDao;
	
	
	@GET
	public List<FoodCategory> getAllFoodCategories() {	 
		List<FoodCategory> list = foodCategoryDao.getAllFoodCategories();
		
		return list;
	}
	
}
