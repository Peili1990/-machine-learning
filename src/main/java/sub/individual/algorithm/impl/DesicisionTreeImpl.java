package sub.individual.algorithm.impl;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sub.individual.algorithm.DesicisionTree;
import sub.individual.annotation.Result;
import sub.individual.util.ReflectionUtil;

/**
 * Class Calculator.java
 *
 * @author liyisen
 * @title Calculator.java
 * @Date 2017年3月24日
 */


public class DesicisionTreeImpl implements DesicisionTree{
	
	@Override
	public <T> double calcShannonEnt(List<T> dataset){
		if(dataset==null || dataset.isEmpty()){
			return 0;
		}
		Map<Object, Integer> labelCounts = new HashMap<>();		
		try {			
			for(T data:dataset){
				Object value = ReflectionUtil.getValueByAnnotation(data, Result.class);				
				if(labelCounts.containsKey(value)){
					Integer count = labelCounts.get(value);
					count++;
					labelCounts.put(value, count);
				} else {
					labelCounts.put(value, 1);
				}
			}
		} catch (IllegalArgumentException | SecurityException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		double shannonEnt = 0;
		for(Object key : labelCounts.keySet()){
			double prob = (double)labelCounts.get(key)/dataset.size();
			shannonEnt -= prob*Math.log(prob)/Math.log(2);
		}
		return shannonEnt;	
	}

	@Override
	public <T> int bestFeatureTosplit(List<T> dataset) {
		Class<?> clazz = dataset.get(0).getClass();
		Field[] fields = clazz.getDeclaredFields();
		double baseshannonEnt = calcShannonEnt(dataset);
		double bestInfoGain = 0;
		int bestFeature = -1;
		for(int index = 0 ; index<fields.length; index++){
			if(!fields[index].isAnnotationPresent(Result.class)){
				
				break;
			}
		}
		return 0;
	}

}
