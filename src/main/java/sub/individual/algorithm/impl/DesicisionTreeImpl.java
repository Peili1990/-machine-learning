package sub.individual.algorithm.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sub.individual.algorithm.DesicisionTree;
import sub.individual.annotation.Attribute;
import sub.individual.annotation.Result;
import sub.individual.model.TreeModel;
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
		Map<Object, Integer> labelCounts = valueCount(dataset);
		if(labelCounts == null) return 0;
		double shannonEnt = 0;
		for(Object key : labelCounts.keySet()){
			double prob = (double)labelCounts.get(key)/dataset.size();
			shannonEnt -= prob*Math.log(prob)/Math.log(2);
		}
		return shannonEnt;	
	}
	
	@Override
	public <T> Object majorityCnt(List<T> dataset) {
		Map<Object, Integer> valueCount = valueCount(dataset);
		if(valueCount == null) return null;
		Integer maxNum = 0;
		Object target = null;
		for(Object value : valueCount.keySet()){
			if(valueCount.get(value) > maxNum){
				maxNum = valueCount.get(value);
				target = value;
			}
		}
		return target;
	}

	@Override
	public <T> TreeModel createTree(List<T> dataset) {
		if(dataset==null || dataset.isEmpty()){
			return null;
		}
		return this.createTree(dataset, ReflectionUtil.getFieldsByAnnotation(dataset.get(0), Attribute.class));
	}

	private <T> String bestFeatureTosplit(List<T> dataset, List<String> labels) {
		double baseshannonEnt = calcShannonEnt(dataset);
		double bestInfoGain = 0;
		int bestFeature = -1;
		for(int index = 0 ; index<labels.size(); index++){
			double newEntropy = 0;
			Map<Object,List<T>> subDataSet = splitDataSet(dataset, labels.get(index));
			for(Object obj : subDataSet.keySet()){
				double prob = (double)subDataSet.get(obj).size()/dataset.size();
				newEntropy += prob * calcShannonEnt(subDataSet.get(obj));
			}			
			if(baseshannonEnt - newEntropy > bestInfoGain){
				bestInfoGain = baseshannonEnt - newEntropy;
				bestFeature = index;
			}
		}
		return labels.get(bestFeature);
	}
	
	private <T> Map<Object, Integer> valueCount(List<T> dataset){
		if(dataset==null || dataset.isEmpty()){
			return null;
		}
		Map<Object, Integer> labelCounts = new HashMap<>();		
		try {			
			for(T data:dataset){
				Object value = ReflectionUtil.getValueByAnnotation(data, Result.class);	
				Integer count = labelCounts.containsKey(value) ? labelCounts.get(value) : 0;
				count++;
				labelCounts.put(value, count);
			}
		} catch (IllegalArgumentException | SecurityException e) {
			throw new RuntimeException(e.getMessage(),e);
		}
		return labelCounts;
	}
	
	private <T> Map<Object,List<T>> splitDataSet(List<T> dataset, String attribute){
		Map<Object, List<T>> category = new HashMap<>();
		for(T data:dataset){
			Object value = ReflectionUtil.getFieldValue(data, attribute);		
			List<T> subList = category.containsKey(value) ? category.get(value) : new ArrayList<T>();
			subList.add(data);
			category.put(value, subList);			
		}
		return category;
	}
	
	private <T> TreeModel createTree(List<T> dataset,List<String> labels){
		TreeModel treeModel = new TreeModel();
		if(calcShannonEnt(dataset) == 0 || labels.isEmpty()){
			treeModel.setLeaf(majorityCnt(dataset));
			return treeModel;
		}
		String bestFeature = labels.size() == 1 ? labels.get(0) : bestFeatureTosplit(dataset, labels);
		treeModel.setRoot(bestFeature);
		Map<Object, TreeModel> branch = new HashMap<>();
		Map<Object, List<T>> subDataSet = splitDataSet(dataset, bestFeature);
		List<String> newLabels = new ArrayList<>(labels);
		newLabels.remove(bestFeature);		
		for(Object value : subDataSet.keySet()){
			branch.put(value, createTree(subDataSet.get(value), newLabels));
		}
		treeModel.setBranch(branch);
		return treeModel;
	}	

}
