package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSON;

import model.FishModel;
import model.WeatherModel;
import sub.individual.algorithm.DesicisionTreeClassify;
import sub.individual.algorithm.impl.DesicisionTreeClassifyImpl;

/**
 * Class CalcShannonEntTest.java
 *
 * @author liyisen
 * @title CalcShannonEntTest.java
 * @Date 2017年3月24日
 */

public class CalcShannonEntTest {
	
	DesicisionTreeClassify tree = new DesicisionTreeClassifyImpl();
	
	@Test
	public void calcShannonEntTest(){
		List<FishModel> models = new ArrayList<>();
		models.add(new FishModel(1, 1, "yes"));
		models.add(new FishModel(1, 1, "yes"));
		models.add(new FishModel(1, 0, "no"));
		models.add(new FishModel(0, 1, "no"));
		models.add(new FishModel(0, 1, "no"));
		
		System.out.println(JSON.toJSONString(tree.createTree(models)));
		
		System.out.println(tree.createTree(models).toString());
		
	}
	
	@Test
	public void createTree(){
		List<WeatherModel> models = new ArrayList<>();
		models.add(new WeatherModel("sunny", "hot", "high", "false", "no"));
		models.add(new WeatherModel("sunny", "hot", "high", "true", "no"));
		models.add(new WeatherModel("overcast", "hot", "high", "false", "yes"));
		models.add(new WeatherModel("rain", "mild", "high", "false", "yes"));
		models.add(new WeatherModel("rain", "cool", "normal", "false", "yes"));
		models.add(new WeatherModel("rain", "cool", "normal", "true", "no"));
		models.add(new WeatherModel("overcast", "cool", "normal", "true", "yes"));
		models.add(new WeatherModel("sunny", "mild", "high", "false", "no"));
		models.add(new WeatherModel("sunny", "cool", "normal", "false", "yes"));
		models.add(new WeatherModel("rain", "mild", "normal", "true", "yes"));
		models.add(new WeatherModel("sunny", "mild", "normal", "true", "yes"));
		models.add(new WeatherModel("overcast", "mild", "high", "true", "yes"));
		models.add(new WeatherModel("overcast", "hot", "normal", "false", "yes"));
		models.add(new WeatherModel("rain", "mild", "high", "true", "no"));
		
		System.out.println(tree.createTree(models).toString());
		
	}
	

}
