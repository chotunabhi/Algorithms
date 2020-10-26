package com.tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreePuzzles {
	static List<Integer> pathList = new LinkedList<>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTreeUtil.buildTree();
//		System.out.println(BinaryTreeTraversals.levelOrderTraversal(root));
//		mirrorBinaryTree(root);
//		System.out.println(BinaryTreeTraversals.levelOrderTraversal(root));
//		BinaryNode ancestor = leastCommonAncestor(root, 4, 3);
//		System.out.println(ancestor == null ? -1 : ancestor.data);

//		System.out.println("Min :"+BinaryTreeUtil.minInBTRec(root)+" Max :"+BinaryTreeUtil.maxInBTRec(root));
//		System.out.println("Min :"+BinaryTreeUtil.minInBT(root)+" Max :"+BinaryTreeUtil.maxInBT(root));

//		System.out.println(" Element exist in BT :"+BinaryTreeUtil.elementExistInBT(root, 8));
//		BinaryTreeUtil.insertElementRecursive(root,9);
//		System.out.println(BinaryTreeUtil.heightOfBT(root));

//		printAllAncestors(root, 7);
//		System.out.println(pathList);
//		System.out.println(leastCommonAncestor(root,1,5));
//		System.out.println(BinaryTreeUtil.diameterOfBT(root));
//		printPathBetweenNodes(root, 4, 7);
//		System.out.println(pathExistsWithSum(root, 6));

//		verticalSum(root);
//		printSingleNodes(root);
		
//		System.out.println("Width of Binary Tree : "+BinaryTreeUtil.widthOfBT(root));
//		System.out.println("Width of Binary Tree : "+BinaryTreeUtil.widthInclusiveNullNodes(root));
		
		System.out.println(BinaryTreeUtil.pathBetweenNodes(root, 8, 7));
	}

	public static void printSingleNodes(BinaryNode root) {
		if (root == null)
			return;

		if ((root.left != null && root.right == null) || (root.left == null && root.right != null)) {
			System.out.print(" " + (root.left == null ? root.right.data : root.left.data));
		}

		printSingleNodes(root.left);
		printSingleNodes(root.right);
	}

	public static void verticalSum(BinaryNode root) {
		HashMap<Integer, Integer> sumMap = new HashMap<Integer, Integer>();

		verticalSumHelper(root, sumMap, 0);

		sumMap.forEach((K, V) -> System.out.println(K + " " + V));

	}

	private static void verticalSumHelper(BinaryNode root, HashMap<Integer, Integer> sumMap, int colLevel) {
		if (root == null)
			return;

		int sum = sumMap.containsKey(colLevel) ? sumMap.get(colLevel) + root.data : root.data;

		sumMap.put(colLevel, sum);

		verticalSumHelper(root.left, sumMap, colLevel - 1);
		verticalSumHelper(root.right, sumMap, colLevel + 1);
	}

	public static void mirrorBinaryTree(BinaryNode root) {
		Queue<BinaryNode> nodesQueue = new LinkedList<>();

		nodesQueue.offer(root);

		while (!nodesQueue.isEmpty()) {
			BinaryNode node = nodesQueue.poll();

			BinaryNode temp = node.left;
			node.left = node.right;
			node.right = temp;

			if (node.left != null)
				nodesQueue.offer(node.left);
			if (node.right != null)
				nodesQueue.offer(node.right);
		}
	}

	public static boolean pathExistsWithSum(BinaryNode root, int sum) {
		if (root == null)
			return false;

		if (root.data == sum)
			return true;

		return pathExistsWithSum(root.left, sum - root.data) || pathExistsWithSum(root.right, sum - root.data);
	}

	public static void printPathBetweenNodes(BinaryNode root, int a, int b) {
		BinaryNode commonAncestor = leastCommonAncestor(root, a, b);

		pathList.clear();

		printAllAncestors(commonAncestor, a);
		printAllAncestors(commonAncestor, b);

		pathList.add(0, a);
		pathList.set(pathList.size() - 1, b);

		System.out.println(pathList);

	}

	public static BinaryNode leastCommonAncestor(BinaryNode root, int a, int b) {
		if (root == null)
			return root;

		if (root.data == a || root.data == b)
			return root;

		BinaryNode leftNode = leastCommonAncestor(root.left, a, b);
		BinaryNode rightNode = leastCommonAncestor(root.right, a, b);

		if (leftNode != null && rightNode != null)
			return root;
		else
			return leftNode != null ? leftNode : rightNode;
	}

	public static boolean printAllAncestors(BinaryNode root, int data) {
		if (root == null)
			return false;

		if ((root.left != null && root.left.data == data) || (root.right != null && root.right.data == data)
				|| printAllAncestors(root.left, data) || printAllAncestors(root.right, data)) {
			pathList.add(root.data);
			return true;
		}

		return false;
	}
}
