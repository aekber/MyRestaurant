package com.eko.nerdeneyenir.restful;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eko.nerdeneyenir.dao.IFoodDao;
import com.eko.nerdeneyenir.model.Food;
import com.eko.nerdeneyenir.model.FoodCategory;
import com.eko.nerdeneyenir.model.Restaurant;

@Component
@Path("/foods")
@Produces(MediaType.APPLICATION_JSON +";charset=utf-8")
public class FoodResource {

	@Autowired
	private IFoodDao foodDao;

	@Context
	UriInfo uriInfo;

	@Context
	Request request;
	
	@GET
	public String getInfo() {	 
		return "Selam Patron!";
	}
	
	@GET
	@Path("for/{deviceid}")
	public List<Food> getFoods(@PathParam(value = "deviceid") String deviceid) {	 
		List<Food> foodList = foodDao.getAllFoods();
		List<Food> filteredFoods = filterFoodsByActiveness(foodList);
		
		return foodDao.votedFoods(filteredFoods);
	}
	
	@GET
	@Path("for/{deviceid}/latitude/{latitude}/longitude/{longitude}")
	public List<Food> getCityFoods(@PathParam(value = "deviceid") String deviceid, 
								   @PathParam(value = "latitude") Float latitude,
								   @PathParam(value = "longitude") Float longitude) {	
		
		long t1 = System.currentTimeMillis();
		List<Food> foodList = foodDao.getAllFoodsByCoordinate(latitude, longitude);
		long t2 = System.currentTimeMillis();
		System.err.println("s1:"+ (t2-t1)/1000.0);		
		
		long t3 = System.currentTimeMillis();
		List<Food> filteredFoods = filterFoodsByActiveness(foodList);
		long t4 = System.currentTimeMillis();
		System.err.println("s2:"+ (t4-t3)/1000.0);
		
		long t5 = System.currentTimeMillis();
		List<Food> l= foodDao.votedFoods(filteredFoods);
		long t6 = System.currentTimeMillis();
		System.err.println("s3:"+ (t6-t5)/1000.0);
		
		return l;
	}
	
	
	@GET
	@Path("{city}")
	public List<Food> getFoodList(@PathParam(value = "city") String city, @PathParam(value = "deviceid") String deviceid) {	 
		List<Food> list = foodDao.votedFoods(filterFoodsByActiveness(foodDao.getAllFoodsByCity(city)));
		return list;
	}
	

	@GET
	@Path("id/{id}")
	public Food getFoodById(@PathParam(value = "id") int id) {	 
	    return foodDao.findByFoodId(id);
	}


	@GET	
	@Path("{id}/foodcat")
	public FoodCategory getFoodCategoryByFoodId(@PathParam(value = "id") int id) {	 
	    Food food = foodDao.findByFoodId(id);
	    return food.getFoodCategory();
	}
	
	@GET
	@Path("{id}/restaurant")
	public Restaurant getRestaurantByFoodId(@PathParam(value = "id") int id) {	 
		Food food = foodDao.findByFoodId(id);
		return food.getRestaurant();
	}
	
	@GET
	@Path("city/{city}/category/{category}/for/{deviceid}/latitude/{latitude}/longitude/{longitude}")
	public List<Food> findByCityAndCategory(@PathParam(value = "city") String city, 
											@PathParam(value = "category") String category, 
											@PathParam(value = "deviceid") String deviceid,
											@PathParam(value = "latitude") Float latitude,
											@PathParam(value = "longitude") Float longitude) {
		List<Food> foodByCityList = foodDao.findByCityAndCategory(city, category, latitude, longitude);
		List<Food> filteredFoodByCityList = filterFoodsByActiveness(foodByCityList);
		
		return foodDao.votedFoods(filteredFoodByCityList);
	}
	
	private List<Food> filterFoodsByActiveness(List<Food> allFoods){
		List<Food> list = new ArrayList<Food>();
		for(Food food : allFoods){
			if(food.getRestaurant().isRestaurantActive() && food.isFoodActive()){
				list.add(food);
			}
		}
		
		return list;
	}
}
