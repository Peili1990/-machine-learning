package model;

import sub.individual.annotation.Attribute;
import sub.individual.annotation.Result;

/**
 * Class WeatherModel.java
 *
 * @author liyisen
 * @title WeatherModel.java
 * @Date 2017年3月30日
 */

public class WeatherModel {
	
	@Attribute
	private String outlook;
	
	@Attribute
	private String temperature;
	
	@Attribute
	private String humidity;
	
	@Attribute
	private String windy;
	
	@Result
	private String canPlay;

	public WeatherModel(String outlook, String temperature, String humidity, String windy, String canPlay) {
		super();
		this.outlook = outlook;
		this.temperature = temperature;
		this.humidity = humidity;
		this.windy = windy;
		this.canPlay = canPlay;
	}
	
	

}
