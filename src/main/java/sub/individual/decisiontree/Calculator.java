package sub.individual.decisiontree;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sub.individual.decisiontree.annotation.Result;
import sub.individual.util.ReflectionUtil;

/**
 * Class Calculator.java
 *
 * @author liyisen
 * @title Calculator.java
 * @Date 2017年3月24日
 */


public class Calculator {
	
	public static <T> double calcShannonEnt(List<T> dataset){
		if(dataset==null || dataset.isEmpty()){
			return 0;
		}
		Class<?> clazz = dataset.get(0).getClass();
		Field[] fields = clazz.getDeclaredFields();
		int resultIndex = -1;
		for(int index = 0 ; index<fields.length; index++){
			if(fields[index].isAnnotationPresent(Result.class)){
				resultIndex = index;
				break;
			}
		}
		if(resultIndex < 0){
			throw new RuntimeException("No @Result Annotation found in "+dataset.getClass().getName());
		}
		Map<Object, Integer> labelCounts = new HashMap<>();		
		try {			
			for(T data:dataset){
				Object value = ReflectionUtil.getFieldValue(data, fields[resultIndex].getName());				
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

}
