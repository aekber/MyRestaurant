package com.eko.nerdeneyenir.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.hibernate.Query;

import com.eko.nerdeneyenir.model.EkoUtil;
import com.eko.nerdeneyenir.model.Food;


public class FoodDaoImpl extends GenericDaoHibernate<Food, Serializable> implements IFoodDao {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8436739987878168581L;

	public FoodDaoImpl() {
		super(Food.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Food> getAllFoods() {
		
		Query q = getSession().createQuery("from Food f");
		List<Food> list = q.setCacheable(true).list();		

		return list;
	}
	
	@Override
	public List<Food> votedFoods(List<Food> list) {
		Query query = getSession().createSQLQuery("select avg(rate), count(*) from foodpopularity where foodid = :foodId");
		
		for(Food food : list){
			query.setInteger("foodId", food.getFoodId());
			List<Object[]> result = query.list();
			food.setAverage(Float.valueOf(result.get(0)[0] != null ? result.get(0)[0].toString() : "0"));
			food.setSum(Integer.valueOf(result.get(0)[1] != null ? result.get(0)[1].toString() : "0"));
		}
		
		return list;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Food> getAllFoodsByCity(String city) {
		
		Query q = getSession().createQuery("from Food f where f.restaurant.restaurantAddress.province = :city");
		q.setString("city", city);
		List<Food> list = q.setCacheable(true).list();		
		
		return list;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Food> getAllFoodsByCoordinate(Float latitude, Float longitude) {
		
		Query q = getSession().createSQLQuery("SELECT a.* " + 
											  "FROM food a,restaurant b,restaurantaddress c "+ 
											  "WHERE a.restaurantid = b.restaurantid and b.addressid = c.restaddresid and c.restaddresid "+ 
												"in( "+
												    "SELECT c.restaddresid "+
												    "FROM restaurantaddress c "+
											        "WHERE round(calc_distance(c.latitude, c.longitude, :latitude, :longitude), 1) <= :maxdist"+
												  ") LIMIT 25;").addEntity("a", Food.class);
		q.setFloat("latitude", latitude);
		q.setFloat("longitude", longitude);
		q.setString("maxdist", getMaxSearchDistance());
		List<Food> list = q.setCacheable(true).list();		
		
		if(list.size() == 0){
			return list;
		}
		
		return setFoodDistance(list, latitude, longitude);
	}

	private String getMaxSearchDistance() {
		Query q = getSession().createSQLQuery("SELECT a.* FROM ekoutil a WHERE a.ekokey='MAXIMUMKM'")
				              .addEntity("a", EkoUtil.class);
		EkoUtil util = (EkoUtil) q.uniqueResult();	
		return util.getEkoValue();
	}

	private List<Food> setFoodDistance(List<Food> list, Float lat2, Float lon2) {
		for(Food food : list){
			Float lat1 = food.getRestaurant().getRestaurantAddress().getLatitude().floatValue();
			Float lon1 = food.getRestaurant().getRestaurantAddress().getLongitude().floatValue();
			food.setDistance(calculateDistance(lat1, lon1, lat2, lon2));
		}
		
		Collections.sort(list, new Comparator<Food>() {

			@Override
			public int compare(Food f1, Food f2) {
				return f1.getDistance().compareTo(f2.getDistance());
			}
		});
		
		return list;
	}

	private Float calculateDistance(Float lat1, Float lng1, Float lat2, Float lng2) {
	    double earthRadius = 6353; //kilometers
	    double dLat = Math.toRadians(lat2-lat1);
	    double dLng = Math.toRadians(lng2-lng1);
	    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
	               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
	               Math.sin(dLng/2) * Math.sin(dLng/2);
	    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
	    float dist = (float) (earthRadius * c);

	    return dist;
	}

	@Override
	public Food findByFoodName(String food) {
		Query q = getSession().createQuery("from Food f where f.name = :name");
		q.setString("name", food);
		
		return (Food) q.setCacheable(true).uniqueResult();
	}

	@Override
	public void updateFood(Food food) {
		update(food);		
	}

	@Override
	public Food findByFoodId(Integer id) {
		return super.findById(id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Food> findByCityAndCategory(String city, String category,Float latitude, Float longitude) {
		
		Query q1 = getSession().createSQLQuery("SELECT a.* " + 
				  "FROM food a,restaurant b,restaurantaddress c,foodcategory d "+ 
				  "WHERE a.restaurantid = b.restaurantid "
				  + "and b.addressid = c.restaddresid "
				  + "and a.categoryid = d.foodcategoryid "
				  + "and d.name = :category "
				  + "and c.province = :city "
				  + "and c.restaddresid "+ 
					"in( "+
					    "SELECT c.restaddresid "+
					    "FROM restaurantaddress c "+
				        "WHERE round(calc_distance(c.latitude, c.longitude, :latitude, :longitude), 1) <= :maxdist "+
					  ") LIMIT 25;").addEntity("a", Food.class);
		
		q1.setFloat("latitude", latitude);
		q1.setFloat("longitude", longitude);
		q1.setString("maxdist", getMaxSearchDistance());
		q1.setString("city", city);
		q1.setString("category", category.replaceAll("0000", " "));
		
		List<Food> distancedFoods = q1.setCacheable(true).list();
		
		if(distancedFoods.size() != 0){
			return setFoodDistance(distancedFoods, latitude, longitude);
		} else{
			Query q2 = getSession().createQuery("from Food f where f.restaurant.restaurantAddress.province = :city and f.foodCategory.name = :category");
			q2.setString("city", city);
			q2.setString("category", category.replaceAll("0000", " "));
			q2.setMaxResults(25);
			
			List<Food> list = q2.setCacheable(true).list();		
			
			return list;
		}
	}

	@Override
	public List<String> getAdsCount() {
		List<String> list = new ArrayList<String>();
		Query q = getSession().createSQLQuery("SELECT a.* FROM ekoutil a WHERE a.ekokey='REKLAMSAY'")
	              .addEntity("a", EkoUtil.class);
		EkoUtil util = (EkoUtil) q.uniqueResult();	
		
		list.add(util.getEkoValue());
		return list;
	}

}
