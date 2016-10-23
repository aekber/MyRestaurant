package com.eko.nerdeneyenir.model;

// default package
// Generated 27.Tem.2014 21:21:56 by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.owlike.genson.annotation.JsonIgnore;

/**
 * Food generated by hbm2java
 */

public class Food implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer foodId;
	private FoodCategory foodCategory;
	private Restaurant restaurant;
	private List<FoodImage> foodImages;
	private List<FoodPopularity> popularityList;
	private String foodName;
	private String comment;
	private Integer popularity;
	private boolean foodActive;
	private Date insertDate;
	private Date updateDate;
	private transient int count;
	private transient Integer sum = 0;
	private transient Float average = 0f;
	private transient Float distance;

	public Food() {
		this.setInsertDate(new Date());
		this.setUpdateDate(new Date());
	}

	public Food(Integer foodId, FoodCategory foodCategory, String foodName, Date insertDate, Date updateDate) {
		super();
		this.foodId = foodId;
		this.foodCategory = foodCategory;
		this.foodName = foodName;
		this.insertDate = insertDate;
		this.updateDate = updateDate;
	}


	public Integer getFoodId() {
		return foodId;
	}

	public void setFoodId(Integer foodId) {
		this.foodId = foodId;
	}

	public FoodCategory getFoodCategory() {
		if(foodCategory == null){
			foodCategory = new FoodCategory();
		}
		return foodCategory;
	}

	public void setFoodCategory(FoodCategory foodCategory) {
		this.foodCategory = foodCategory;
	}

	public Restaurant getRestaurant() {
		if(restaurant == null){
			restaurant = new Restaurant();
		}
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<FoodImage> getFoodImages() {
		if(foodImages == null){
			foodImages = new ArrayList<FoodImage>();
		}
		return foodImages;
	}

	public void setFoodImages(List<FoodImage> foodImages) {
		this.foodImages = foodImages;
	}

	@JsonIgnore
	public List<FoodPopularity> getPopularityList() {
		if(popularityList == null){
			popularityList = new ArrayList<FoodPopularity>();
		}
		return popularityList;
	}

	public void setPopularityList(List<FoodPopularity> popularityList) {
		this.popularityList = popularityList;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public Integer getPopularity() {
		return popularity;
	}

	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}

	public boolean isFoodActive() {
		return foodActive;
	}

	public void setFoodActive(boolean foodActive) {
		this.foodActive = foodActive;
	}

	public int getCount() {
		return this.getPopularityList().size();
	}

	public void setCount(int count) {
		this.count = count;
	}

	public Integer getSum() {
		return sum;
	}

	public void setSum(Integer sum) {
		this.sum = sum;
	}

	public Float getAverage() {
		return average;
	}

	public void setAverage(Float average) {
		this.average = average;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodId == null) ? 0 : foodId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object object) {
		if (!(object instanceof Food)) {
			return false;
		}
		Food other = (Food) object;
		if ((this.foodId == null && other.foodId != null)
				|| (this.foodId != null && !this.foodId.equals(other.foodId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Food[" + foodId + " = " + foodName + "]";
	}

}
