package com.tree;

import java.util.LinkedList;

public class MirrorTree {
	public static void main(String args[]) {
		BinaryNode root1 = BinaryTreeUtil.buildTree();

		LinkedList<BinaryNode> treeNodes = BinaryTreeTraversals.levelOrderTraversal(root1);
		System.out.println(treeNodes);

		/*
		 * BinaryNode root2 = mirrorOfBT(root1.clone()); BinaryTreeTraversals.clear();
		 * 
		 * treeNodes = BinaryTreeTraversals.levelOrderTraversal(root2);
		 * System.out.println(treeNodes);
		 */

		BinaryNode root2 = BinaryTreeUtil.buildTree();

		treeNodes = BinaryTreeTraversals.levelOrderTraversal(root2);
		System.out.println(treeNodes);

		System.out.println(isMirrors(root1, root2));

	}

	public static BinaryNode mirrorOfBT(BinaryNode root) {
		if (root != null) {
			BinaryNode temp = root.left;
			root.left = root.right;
			root.right = temp;

			mirrorOfBT(root.left != null ? root.left.clone() : root.left);
			mirrorOfBT(root.right != null ? root.right.clone() : root.right);
		}

		return root;
	}

	public static boolean isMirrors(BinaryNode root1, BinaryNode root2) {
		if (root1 == null && root2 == null)
			return true;

		if (root1 == null || root2 == null)
			return false;

		if (root1.data != root2.data)
			return false;
		else
			return (isMirrors(root1.left, root2.right) && isMirrors(root1.right, root2.left));
	}
}
