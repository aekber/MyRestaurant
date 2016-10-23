package com.eko.nerdeneyenir.dao;

import java.io.Serializable;
import java.util.List;

import com.eko.nerdeneyenir.model.RestaurantAddress;

public interface IRestaurantAddressDao extends IGenericDao<RestaurantAddress, Serializable> {

	public List<String> getAllRestaurantAddresses();
}
