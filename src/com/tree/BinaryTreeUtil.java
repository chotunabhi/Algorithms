package com.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeUtil {
	public static BinaryNode buildTree() {
		BinaryNode root = null;
		System.out.print("Enter Data for root Node : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String dataString;

		try {
			dataString = reader.readLine();


			if(dataString == null || dataString.trim().length() == 0)
				return root;

			root = new BinaryNode(Integer.parseInt(dataString));

			Queue<BinaryNode> nodesQueue = new LinkedList<>();
			nodesQueue.add(root);

			while(!nodesQueue.isEmpty()) {
				BinaryNode currentNode = nodesQueue.poll();

				System.out.print("Enter left node Data for "+ currentNode.data +" Node : ");
				dataString = reader.readLine();

				BinaryNode node = null;
				if(dataString != null && dataString.trim().length() > 0) {
					node = new BinaryNode(Integer.parseInt(dataString));
					currentNode.left = node.clone();
					nodesQueue.add(currentNode.left);
				}
				

				System.out.print("Enter Right node Data for "+ currentNode.data +" Node : ");

				dataString = reader.readLine();
				node = null;
				if(dataString != null && dataString.trim().length() > 0) {
					node = new BinaryNode(Integer.parseInt(dataString));
					currentNode.right = node.clone();
					nodesQueue.add(currentNode.right);
				}
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return root;
	}
}
