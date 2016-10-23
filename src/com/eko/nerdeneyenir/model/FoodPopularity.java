package com.eko.nerdeneyenir.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.owlike.genson.annotation.JsonIgnore;

public class FoodPopularity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer foodPopularityId;
	private Food popularityFood;
	private String deviceID;
	private BigDecimal rate;
	private Date insertDate;
	
	public FoodPopularity() {
		this.setInsertDate(new Date());
	}

	public FoodPopularity(Integer foodPopularityId, Food popularityFood,
			String deviceID, BigDecimal rate, Date insertDate) {
		super();
		this.foodPopularityId = foodPopularityId;
		this.popularityFood = popularityFood;
		this.deviceID = deviceID;
		this.rate = rate;
		this.insertDate = insertDate;
	}

	public Integer getFoodPopularityId() {
		return foodPopularityId;
	}
	
	public void setFoodPopularityId(Integer foodPopularityId) {
		this.foodPopularityId = foodPopularityId;
	}
	
	@JsonIgnore
	public Food getPopularityFood() {
		if(popularityFood == null){
			popularityFood = new Food();
		}
		return popularityFood;
	}
	
	public void setPopularityFood(Food popularityFood) {
		this.popularityFood = popularityFood;
	}
	
	public String getDeviceID() {
		return deviceID;
	}
	
	public void setDeviceID(String deviceID) {
		this.deviceID = deviceID;
	}
	
	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public Date getInsertDate() {
		return insertDate;
	}
	
	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((foodPopularityId == null) ? 0 : foodPopularityId.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object object) {
		if (!(object instanceof FoodPopularity)) {
			return false;
		}
		FoodPopularity other = (FoodPopularity) object;
		if ((this.foodPopularityId == null && other.foodPopularityId != null)
				|| (this.foodPopularityId != null && !this.foodPopularityId.equals(other.foodPopularityId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "FoodPopularity[" + foodPopularityId + " = " + this.popularityFood.getFoodName() + "]";
	}
}
