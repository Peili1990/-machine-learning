package sub.individual.model;

import java.util.Map;

/**
 * Class DecisionTree.java
 *
 * @author liyisen
 * @title DecisionTree.java
 * @Date 2017年3月30日
 */

public class TreeModel {
	
	private String root;
	
	private Object leaf;
	
	private Map<Object, TreeModel> branch;

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public Object getLeaf() {
		return leaf;
	}

	public void setLeaf(Object leaf) {
		this.leaf = leaf;
	}

	public Map<Object, TreeModel> getBranch() {
		return branch;
	}

	public void setBranch(Map<Object, TreeModel> branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		if(this.root == null) {
			return this.leaf.toString();
		}
		builder.append("{"+this.root+":{");
		for(Object value : this.branch.keySet()){
			builder.append(value+":"+branch.get(value).toString()+",");
		}
		builder.deleteCharAt(builder.lastIndexOf(","));
		builder.append("}}");
		return builder.toString();
	}
	
	

}
