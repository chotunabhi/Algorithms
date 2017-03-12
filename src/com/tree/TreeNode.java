package com.tree;

import java.util.LinkedList;
import java.util.List;

public class TreeNode {
	String value;
	List<TreeNode> child = new LinkedList<>();
	
	TreeNode(String value){
		this.value = value;
	}
	
	public void addChild(TreeNode child){
		this.child.add(child);
	}
}
