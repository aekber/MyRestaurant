package com.eko.nerdeneyenir.restful;

import java.math.BigDecimal;
import java.util.Date;

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
import com.eko.nerdeneyenir.dao.IFoodPopularityDao;
import com.eko.nerdeneyenir.model.FoodPopularity;

@Component
@Path("/popularity")
@Produces(MediaType.APPLICATION_JSON +";charset=utf-8")
public class FoodPopularityResource {

	@Autowired
	private IFoodPopularityDao foodPopularityDao;
	
	@Autowired
	private IFoodDao foodDao;

	@Context
	UriInfo uriInfo;

	@Context
	Request request;
	
	
	@GET
	@Path("exist/food/{foodId}/device/{deviceId}")
	public boolean isPopularityExist(@PathParam(value = "foodId") int foodId, 
									 @PathParam(value = "deviceId") String deviceId) {	 
		return foodPopularityDao.isPopularityExist(foodId, deviceId);
	}
	
	@GET
	@Path("change/food/{foodId}/device/{deviceId}/rate/{rate}")
	public void changeFoodPopularity(@PathParam(value = "foodId") int foodId, 
			 						 @PathParam(value = "deviceId") String deviceId,
			 						 @PathParam(value = "rate") BigDecimal rate) {	 
		
		if(!foodPopularityDao.isPopularityExist(foodId, deviceId)){
			FoodPopularity popularity = new FoodPopularity();
			popularity.setDeviceID(deviceId);
			popularity.setRate(rate);
			popularity.setInsertDate(new Date());
			popularity.setPopularityFood(foodDao.findByFoodId(foodId));
			foodPopularityDao.insertPopularity(popularity);
		} else{
			FoodPopularity fp = foodPopularityDao.findByFoodIdAndDeviceId(foodId, deviceId);
			fp.setRate(rate);
			foodPopularityDao.merge(fp);
		}
		
	}

}
