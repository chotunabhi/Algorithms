package com.dsnalgomadeeasy.tree.common;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtil {
	public static BinaryTreeNode<Integer> buildTree(String data[]) {
		BinaryTreeNode<Integer> root = null;
		//		System.out.print("Enter Data for root Node : ");
		//		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String dataString;

		dataString = data != null && data.length > 0?data[0]:null;

		if (dataString == null)
			return root;

		root = new BinaryTreeNode<>(Integer.parseInt(dataString));

		Queue<BinaryTreeNode<Integer>> nodesQueue = new LinkedList<>();
		nodesQueue.add(root);
		int i = 0;

		while (!nodesQueue.isEmpty() && ++i < data.length) {
			BinaryTreeNode<Integer> currentNode = nodesQueue.poll();

			dataString = data[i].equalsIgnoreCase("n")?null:data[i];

			BinaryTreeNode<Integer> node = null;
			if (dataString != null) {
				node = new BinaryTreeNode<>(Integer.parseInt(dataString));
				currentNode.setLeft(node.clone());
				nodesQueue.add(currentNode.getLeft());
			}
			i++;
			dataString = i >= data.length || data[i].equalsIgnoreCase("n")?null:data[i];
			node = null;
			if (dataString != null) {
				node = new BinaryTreeNode<>(Integer.parseInt(dataString));
				currentNode.setRight(node.clone());
				nodesQueue.add(currentNode.getRight());
			}

		}

		return root;
	}
}
