package test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import model.FishModel;
import sub.individual.algorithm.DesicisionTree;
import sub.individual.algorithm.impl.DesicisionTreeImpl;

/**
 * Class CalcShannonEntTest.java
 *
 * @author liyisen
 * @title CalcShannonEntTest.java
 * @Date 2017年3月24日
 */

public class CalcShannonEntTest {
	
	DesicisionTree tree = new DesicisionTreeImpl();
	
	@Test
	public void calcShannonEntTest(){
		List<FishModel> models = new ArrayList<>();
		models.add(new FishModel(1, 1, "yes"));
		models.add(new FishModel(1, 1, "yes"));
		models.add(new FishModel(1, 0, "no"));
		models.add(new FishModel(0, 1, "no"));
		models.add(new FishModel(0, 1, "no"));
		
		System.out.println(tree.majorityCnt(models));
	}
	

}
