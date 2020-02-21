package com.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreePuzzles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTreeUtil.buildTree();
		System.out.println(BinaryTreeTraversals.levelOrderTraversal(root));
		mirrorBinaryTree(root);
		System.out.println(BinaryTreeTraversals.levelOrderTraversal(root));
	}
	
	public static void mirrorBinaryTree(BinaryNode root) {
		Queue<BinaryNode> nodesQueue = new LinkedList<>();
		
		nodesQueue.offer(root);
		
		while(!nodesQueue.isEmpty()) {
			BinaryNode node = nodesQueue.poll();
			
			BinaryNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			
			if(node.left != null)
				nodesQueue.offer(node.left);
			if(node.right != null)
				nodesQueue.offer(node.right);
		}
	}
}
