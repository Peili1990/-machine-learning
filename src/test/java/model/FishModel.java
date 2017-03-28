package model;

import sub.individual.annotation.Attribute;
import sub.individual.annotation.Result;

/**
 * Class FishModel.java
 *
 * @author liyisen
 * @title FishModel.java
 * @Date 2017年3月24日
 */

public class FishModel {
	
	@Attribute
	private Integer noSurfing;
	
	@Attribute
	private Integer flippers;
	
	@Result
	private String isFish;

	public Integer getNoSurfing() {
		return noSurfing;
	}

	public void setNoSurfing(Integer noSurfing) {
		this.noSurfing = noSurfing;
	}

	public Integer getFlippers() {
		return flippers;
	}

	public void setFlippers(Integer flippers) {
		this.flippers = flippers;
	}

	public String getIsFish() {
		return isFish;
	}

	public void setIsFish(String isFish) {
		this.isFish = isFish;
	}

	public FishModel(Integer noSurfing, Integer flippers, String isFish) {
		super();
		this.noSurfing = noSurfing;
		this.flippers = flippers;
		this.isFish = isFish;
	}
	
	

}
