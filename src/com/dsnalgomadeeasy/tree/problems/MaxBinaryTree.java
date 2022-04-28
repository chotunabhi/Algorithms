package com.dsnalgomadeeasy.tree.problems;

import java.util.LinkedList;
import java.util.Queue;

import com.dsnalgomadeeasy.tree.common.BinaryTreeNode;

public class MaxBinaryTree {
	public int getMaxInBinaryTree(BinaryTreeNode<Integer> root) {
		int max =Integer.MIN_VALUE;
		
		if(root != null) {
			int lMax = getMaxInBinaryTree(root.getLeft());
			int rMax = getMaxInBinaryTree(root.getRight());
			
			max = lMax > rMax ? lMax : rMax;
			
			if(root.getData().compareTo(max) > 0)
				max = root.getData();
		}
		
		return max;
	}
	
	public int getMaxInBinaryTreeIt(BinaryTreeNode<Integer> root) {
		int max =Integer.MIN_VALUE;
		
		if(root != null) {
			Queue<BinaryTreeNode<Integer>> nodeQueue = new LinkedList<BinaryTreeNode<Integer>>();
			nodeQueue.offer(root);
			
			while(!nodeQueue.isEmpty()) {
				BinaryTreeNode<Integer> node = nodeQueue.poll();
				
				if(node.getLeft() != null)
					nodeQueue.offer(node.getLeft());
				
				if(node.getRight() != null)
					nodeQueue.offer(node.getRight());
				
				if(node.getData().compareTo(max) > 0)
					max = node.getData();
			}
		}
		
		return max;
	}
}
