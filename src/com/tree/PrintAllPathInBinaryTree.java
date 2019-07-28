package com.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PrintAllPathInBinaryTree {
	private static List<List<Integer>> listOfPaths = new ArrayList<>();
	public static void main(String[] args) {
		
		BinaryNode root = BinaryTreeUtil.buildTree();
//		BinaryNode root = new BinaryNode(1);
//		
//		BinaryNode l1 = new BinaryNode(2);
//		root.left = l1;
//		BinaryNode r1 = new BinaryNode(3);
//		root.right = r1;
//		
//		BinaryNode l1l2 = new BinaryNode(4);
//		l1.left = l1l2;
//		BinaryNode l1r2 = new BinaryNode(5);
//		l1.right = l1r2;
//		
//		BinaryNode r1r2 = new BinaryNode(6);
//		r1.right = r1r2;
//		
//		BinaryNode r1r2l3 = new BinaryNode(7);
//		r1r2.left = r1r2l3;
//		
//		BinaryNode r1r2r3 = new BinaryNode(8);
//		r1r2.right = r1r2r3;
		
		DFS(root,new LinkedList<>());
		System.out.println(listOfPaths);
	}

	public static List<List<Integer>> DFS(BinaryNode root,List<Integer> path) {
		if(root == null)
			return listOfPaths;

		path.add(root.data);
		
		DFS(root.left,path);
		DFS(root.right,path);
		
		if(root.left == null && root.right == null && path.size() > 0) {
			List<Integer> pathTillNow = new ArrayList<>();
			pathTillNow.addAll(path);
			listOfPaths.add(pathTillNow);
		}
		
		path.remove(path.size() - 1);
		
		return listOfPaths;
	}
	
	private static void printPath(List<List<Integer>> listOfPaths) {
		for(List<Integer> path:listOfPaths) {
			for(int i = 0 ;i< path.size();i++) {
				System.out.print(""+path.get(i));
				
				if(i != path.size() - 1)
					System.out.print("->");
			}
			System.out.println();
		}
	}
}
