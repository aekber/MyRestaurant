package com.eko.nerdeneyenir.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;

import com.eko.nerdeneyenir.model.Food;
import com.eko.nerdeneyenir.model.FoodPopularity;


public class FoodPopularityDaoImpl extends GenericDaoHibernate<FoodPopularity, Serializable> implements IFoodPopularityDao {
	
	
	public FoodPopularityDaoImpl() {
		super(FoodPopularity.class);
	}

	@Override
	public boolean isPopularityExist(int foodId, String deviceId) {
		Query q = getSession().createSQLQuery("select fp.* from foodpopularity fp where fp.foodid = :foodId and fp.deviceid = :deviceId").addEntity("fp", FoodPopularity.class);
		q.setInteger("foodId", foodId);
		q.setString("deviceId", deviceId);
		List<Food> list = q.setCacheable(true).list();		
		
		return list.size() > 0;
	}

	@Override
	public void insertPopularity(FoodPopularity a) {
		persist(a);
	}

	@Override
	public long getPopularityByFood(int foodId) {
		Query query = getSession().createQuery("select count(*) from FoodPopularity fp where fp.popularityFood.foodId = :foodId");
		query.setInteger("foodId", foodId);
		
		return(long)query.uniqueResult();
	}

	@Override
	public void removePopularity(int foodId, String deviceId) {
		Query q = getSession().createSQLQuery("delete from foodpopularity where foodid = :foodId and deviceid = :deviceId");
		q.setInteger("foodId", foodId);
		q.setString("deviceId", deviceId);
		
		q.executeUpdate();
	}

	@Override
	public void updatePopularity(FoodPopularity a) {
		update(a);
	}

	@Override
	public FoodPopularity findByFoodIdAndDeviceId(int foodId, String deviceId) {
		Query q = getSession().createSQLQuery("select * from foodpopularity where foodid = :foodId and deviceid = :deviceId").addEntity(FoodPopularity.class);
		q.setInteger("foodId", foodId);
		q.setString("deviceId", deviceId);
		
		return (FoodPopularity) q.uniqueResult();
	}

}
