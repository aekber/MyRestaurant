package com.eko.nerdeneyenir.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;

import com.eko.nerdeneyenir.model.RestaurantAddress;


public class RestaurantAddressDaoImpl extends GenericDaoHibernate<RestaurantAddress, Serializable> implements IRestaurantAddressDao {
	
	
	public RestaurantAddressDaoImpl() {
		super(RestaurantAddress.class);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<String> getAllRestaurantAddresses() {
		List<String> result = new ArrayList<String>();
		
		Query query = getSession().createSQLQuery("select distinct ra.province from restaurantaddress ra, restaurant r, food f where ra.restaddresid = r.addressid and r.restaurantid = f.restaurantid and r.isrestaurantactive = 1 and f.isfoodactive = 1");
		List<Object> aa = query.list();
		
		for(Object obj : aa){
			result.add(obj.toString());
		}
		return result;
	}

}
