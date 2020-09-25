package com.tree;

public class BinarySearchTree {
	public BinaryNode insert(BinaryNode root,int data) {
		if(root == null)
			return new BinaryNode(data);
		
		if(data < root.data) {//left child
			if(root.left == null) {
				root.left = insert(root.left,data); 
			}else
				insert(root.left, data);
			
		}else {//right child
			if(root.right == null) {
				root.right = insert(root.right,data); 
			}else
				insert(root.right, data);
		}
		
		return root;
	}
	
	public BinaryNode delete(BinaryNode root,int data) {
		if(root == null)
			return null;
		else if(root.data > data) {
			root.left = delete(root.left,data);
		}else if(root.data < data){
			root.right = delete(root.right,data);
		}else {
			if(root.left == null && root.right == null) {
				return null;
			}else if(root.right == null){
				return root.left;
			}else if(root.left == null) {
				return root.right;
			}else {
				root.data = findMaxInBST(root.left).data;
				delete(root.left,root.data);
			}
		}
		
		return root;
	}
	
	public BinaryNode findMaxInBST(BinaryNode root) {
		if(root == null)
			return null;
		
		BinaryNode maxNode = root;
		
		while(maxNode.right != null)
			maxNode = maxNode.right;
		
		return maxNode;
	}
	
	public BinaryNode findMinInBST(BinaryNode root) {
		if(root == null)
			return null;
		
		BinaryNode maxNode = root;
		
		while(maxNode.left != null)
			maxNode = maxNode.left;
		
		return maxNode;
	}
}
