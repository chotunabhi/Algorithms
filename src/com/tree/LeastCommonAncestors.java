package com.tree;

import java.util.LinkedList;
import java.util.List;

public class LeastCommonAncestors {
	private boolean aExist,bExist;
	static List<BinaryNode> path = new LinkedList<>();
	
	public static void main(String args[]) {
		BinaryNode lca = new LeastCommonAncestors().leastCommonAncestorBT(BinaryTreeUtil.buildTree(), 4, 7);
//		BinaryNode lca = new LeastCommonAncestors().leastCommonAncestorBST(BinaryTreeUtil.buildTree(), 4, 7);
		System.out.print(path);
		System.out.print(lca);
	}
	
	public BinaryNode leastCommonAncestorBT(BinaryNode root,int a,int b) {
		BinaryNode lca = leastCommonAncestorBTHelper(root,a,b) ;
		
		return (aExist && bExist)? lca : null;
	}
	private BinaryNode leastCommonAncestorBTHelper(BinaryNode root,int a,int b) {
		if(root == null) 
			return null;
		
		if(root.data == a) {
			aExist = true;
			return root;
		}
		
		if(root.data == b) {
			bExist = true;
			return root;
		}
		
		BinaryNode left = leastCommonAncestorBTHelper(root.left, a, b);
		BinaryNode right = leastCommonAncestorBTHelper(root.right, a, b);

		if(left != null && right != null) {
			return root;
		}

		return left != null?left:right;
	}

	private BinaryNode leastCommonAncestorBST(BinaryNode root, int a, int b) {
		if(root == null)
			return null;
		
		if(root.data < a && root.data < b)
			leastCommonAncestorBST(root.right, a, b);
		else if(root.data > a && root.data > b)
			leastCommonAncestorBST(root.left, a, b);
		
		if(!(BinaryTreeUtil.elementExistInBSTIterative(root, a) && BinaryTreeUtil.elementExistInBSTIterative(root, b)))
			return null;
		
		return root;
	}
}
