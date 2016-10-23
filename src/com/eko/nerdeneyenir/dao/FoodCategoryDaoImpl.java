package com.eko.nerdeneyenir.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.eko.nerdeneyenir.model.FoodCategory;


public class FoodCategoryDaoImpl extends GenericDaoHibernate<FoodCategory, Serializable> implements IFoodCategoryDao {
	
	
	public FoodCategoryDaoImpl() {
		super(FoodCategory.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<FoodCategory> getAllFoodCategories() {
		
		Query q = getSession().createQuery("from FoodCategory f");		
		List<FoodCategory> list = q.setCacheable(true).list();		
		
		return list;
	}

	@Override
	public FoodCategory findByFoodCategoryName(String food) {
		Query q = getSession().createQuery("from FoodCategory f where f.name = :name");
		q.setString("name", food);
		
		return (FoodCategory) q.setCacheable(true).uniqueResult();
	}

	@Override
	public void updateFoodCategory(FoodCategory food) {
		update(food);		
	}

	@Override
	public List<String> getAllCategories() {
		List<String> result = new ArrayList<String>();
		
		Query query = getSession().createSQLQuery("select distinct fc.name from foodcategory fc, restaurant r, food f where fc.foodcategoryid = f.categoryid and r.restaurantid = f.restaurantid and r.isrestaurantactive = 1 and f.isfoodactive = 1");
		List<Object> aa = query.list();
		
		for(Object obj : aa){
			result.add(obj.toString());
		}
		return result;
	}

	@Override
	public FoodCategory findById(Integer id) {
		return super.findById(id);
	}
}
