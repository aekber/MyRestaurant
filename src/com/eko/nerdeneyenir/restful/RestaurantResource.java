package com.eko.nerdeneyenir.restful;

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

import com.eko.nerdeneyenir.dao.IRestaurantDao;
import com.eko.nerdeneyenir.model.Food;
import com.eko.nerdeneyenir.model.Restaurant;

@Component
@Path("/restaurants")
@Produces(MediaType.APPLICATION_JSON +";charset=utf-8")
public class RestaurantResource {

	@Autowired
	private IRestaurantDao restaurantDao;

	@Context
	UriInfo uriInfo;

	@Context
	Request request;
	
	@GET
	public List<Restaurant> getAllRestaurants() {	 
	    return restaurantDao.getAllRestaurants();
	}

	@GET
	@Path("/{id}")
	public Restaurant getRestaurantById(@PathParam(value = "id") int id) {	 
	    return restaurantDao.findById(id);
	}

	@GET	
	@Path("/{id}/foods")
	public List<Food> getFoodCategoryByFoodId(@PathParam(value = "id") int id) {	 
		Restaurant restaurant = restaurantDao.findById(id);
	    return restaurant.getFoods();
	}
	
}
