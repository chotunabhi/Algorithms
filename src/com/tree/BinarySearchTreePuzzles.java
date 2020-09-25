package com.tree;

import java.util.LinkedList;

public class BinarySearchTreePuzzles {
	private static int prev = Integer.MIN_VALUE;

	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		BinaryNode root = bst.insert(null, 8);
		root = bst.insert(root, 4);
		root = bst.insert(root, 12);
		root = bst.insert(root, 2);
		root = bst.insert(root, 6);
		root = bst.insert(root, 10);
		root = bst.insert(root, 14);
		root = bst.insert(root, 1);
		root = bst.insert(root, 3);
		root = bst.insert(root, 5);
		root = bst.insert(root, 7);
		root = bst.insert(root, 9);
		root = bst.insert(root, 11);
		root = bst.insert(root, 13);
		root = bst.insert(root, 15);
		root = bst.insert(root, 16);

		LinkedList<BinaryNode> listNodes = new LinkedList<>();
//		BinaryTreeTraversals.inOrder(root, listNodes);
		listNodes = BinaryTreeTraversals.levelOrderTraversal(root);

		System.out.println(listNodes);
//		
//		bst.delete(root, 8);
//		listNodes = BinaryTreeTraversals.levelOrderTraversal(root);
//		System.out.println(listNodes);
		System.out.println(isBST(root));
		System.out.println(isBSTImproved(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

		root = BinaryTreeUtil.buildTree();
		System.out.println(isBST(root));
		System.out.println(isBSTImproved(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	public static boolean isBST(BinaryNode root) {
		if (root == null)
			return true;

		if ((root.left != null && new BinarySearchTree().findMaxInBST(root.left).data > root.data)
				|| (root.right != null && new BinarySearchTree().findMinInBST(root.right).data < root.data))
			return false;

		return isBST(root.left) && isBST(root.right);
	}

	public static boolean isBSTImproved(BinaryNode root, int min, int max) {
		if (root == null)
			return true;

		return (min < root.data && root.data < max && isBSTImproved(root.left, min, root.data)
				&& isBSTImproved(root.right, root.data, max));
	}

	public static boolean isBSTInorderTraversal(BinaryNode root) {
		if (root == null)
			return true;

		if (!isBSTInorderTraversal(root.left))
			return false;

		if (root.data < prev)
			return false;
		
		prev = root.data;

		return isBSTInorderTraversal(root.right);
	}

}
