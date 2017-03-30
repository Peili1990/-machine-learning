package sub.individual.model.decisionTree;

import java.util.List;
import java.util.Map;

/**
 * Class BestFeatureModel.java
 *
 * @author liyisen
 * @title BestFeatureModel.java
 * @Date 2017年3月30日
 */

public class BestFeatureModel<T> {
	
	private String feature;
	
	private Map<Object,List<T>> subList;

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public Map<Object, List<T>> getSubList() {
		return subList;
	}

	public void setSubList(Map<Object, List<T>> subList) {
		this.subList = subList;
	}

}
