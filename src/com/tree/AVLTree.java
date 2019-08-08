package com.tree;

public class AVLTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public void rotateRight(BinaryNode root) {
		BinaryNode temp = root.left;
		root.left = root.left.right;
		temp.right = root;
		
		root = temp;
	}
	
	public void rotateLeft(BinaryNode root) {
		BinaryNode temp = root.right;
		root.right = root.right.left;
		temp.left = root;
		
		root = temp;
	}
}
