package com.eko.nerdeneyenir.restful;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eko.nerdeneyenir.dao.IFoodCategoryDao;
import com.eko.nerdeneyenir.dao.IFoodDao;
import com.eko.nerdeneyenir.dao.IRestaurantAddressDao;
import com.eko.nerdeneyenir.model.EkoUtil;

@Component
@Path("/citycategory")
@Produces(MediaType.APPLICATION_JSON +";charset=utf-8")
public class RestaurantAddressResource {

	@Autowired
	private IRestaurantAddressDao restaurantAddressDao;
	
	@Autowired
	private IFoodCategoryDao foodCategoryDao;
	
	@Autowired
	private IFoodDao foodDao;
	
	
	@GET
	public Map<String, List<String>> getAllRestaurantAddresses() {	 
		Map<String, List<String>> result = new HashMap<String, List<String>>();
		List<String> list = restaurantAddressDao.getAllRestaurantAddresses();
		List<String> categoryList = foodCategoryDao.getAllCategories();
		List<String> utilityList = foodDao.getAdsCount();
		
		result.put("city", list);
		result.put("category", categoryList);
		result.put("utility", utilityList);
		
		return result;
	}
	
}
