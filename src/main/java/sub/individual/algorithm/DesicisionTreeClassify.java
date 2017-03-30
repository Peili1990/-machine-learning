package sub.individual.algorithm;

import java.util.List;

import sub.individual.model.decisionTree.TreeModel;

/**
 * Class DesicisionTree.java
 *
 * @author liyisen
 * @title DesicisionTree.java
 * @Date 2017年3月27日
 */

public interface DesicisionTreeClassify {
	
	public <T> double calcShannonEnt(List<T> dataset);
	
	public <T> Object majorityCnt(List<T> dataset);
	
	public <T> TreeModel createTree(List<T> dataset); 

}
