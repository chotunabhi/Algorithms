package com.tree;

import java.util.LinkedList;
import java.util.List;

public class PrintEachPath {
	List<String> path = new LinkedList<>();

	public static void main(String[] args) {
		TreeNode men = new TreeNode("Men");
		TreeNode women = new TreeNode("Women");
		TreeNode electronics = new TreeNode("Electronics");

		TreeNode footWear = new TreeNode("Foot Wear");
		TreeNode clothes = new TreeNode("Clothes");
		TreeNode watches = new TreeNode("Watches");

		TreeNode formals = new TreeNode("Formals");
		TreeNode sports= new TreeNode("Sports");
		TreeNode casuals = new TreeNode("Casuals");
		TreeNode shirts = new TreeNode("Shirts");
		TreeNode trousers = new TreeNode("Trousers");
		TreeNode mechanical = new TreeNode("Mechanical");
		TreeNode quartz = new TreeNode("Quartz");

		TreeNode premium = new TreeNode("Premium");
		TreeNode regular = new TreeNode("Regular");

		formals.addChild(premium);
		formals.addChild(regular);

		mechanical.addChild(premium);
		mechanical.addChild(regular);

		footWear.addChild(formals);
		footWear.addChild(sports);
		footWear.addChild(casuals);

		clothes.addChild(shirts);
		clothes.addChild(trousers);

		watches.addChild(mechanical);
		watches.addChild(quartz);

		electronics.addChild(premium);
		electronics.addChild(quartz);

		men.addChild(footWear);
		men.addChild(clothes);
		men.addChild(watches);

		women.addChild(footWear);
		women.addChild(clothes);
		women.addChild(watches);

		TreeNode[] parents = new TreeNode[3];
		parents[0] = men;
		parents[1] = women;
		parents[2] = electronics;

		new PrintEachPath().printEachPath(parents);
	}
	
	public void printEachPath(TreeNode[] parents){
		for (TreeNode treeNode : parents) {
			path.clear();
			DFS(treeNode);
		}
	}
	
	public void DFS(TreeNode root){
		if(root == null)
			return;
		path.add(root.value);

		for(TreeNode child:root.child){
			DFS(child);
			
			if(child.child.isEmpty()){
				System.out.println(path);
			}
			
			path.remove(path.size() - 1);
		}
	}
}

