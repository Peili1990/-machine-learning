package sub.individual.algorithm;

import java.util.List;

/**
 * Class DesicisionTree.java
 *
 * @author liyisen
 * @title DesicisionTree.java
 * @Date 2017年3月27日
 */

public interface DesicisionTree {
	
	public <T> double calcShannonEnt(List<T> dataset);
	
	public <T> Object majorityCnt(List<T> dataset);

}
