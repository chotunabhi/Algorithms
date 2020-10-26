package com.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sun.org.apache.xpath.internal.operations.Bool;

public class BinaryTreeUtil {
	private static List<Integer> leftMostNodesPosition = new LinkedList<>();
	private static int width = 0;
	private static int numberOfLeaves = 0;
	
	public static void clear() {
		leftMostNodesPosition.clear();
		width = 0;
		numberOfLeaves = 0;
	}
	
	public static BinaryNode buildTree() {
		BinaryNode root = null;
		System.out.print("Enter Data for root Node : ");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String dataString;

		try {
			dataString = reader.readLine();

			if (dataString == null || dataString.trim().length() == 0)
				return root;

			root = new BinaryNode(Integer.parseInt(dataString));

			Queue<BinaryNode> nodesQueue = new LinkedList<>();
			nodesQueue.add(root);

			while (!nodesQueue.isEmpty()) {
				BinaryNode currentNode = nodesQueue.poll();

				System.out.print("Enter left node Data for " + currentNode.data + " Node : ");
				dataString = reader.readLine();

				BinaryNode node = null;
				if (dataString != null && dataString.trim().length() > 0) {
					node = new BinaryNode(Integer.parseInt(dataString));
					currentNode.left = node.clone();
					nodesQueue.add(currentNode.left);
				}

				System.out.print("Enter Right node Data for " + currentNode.data + " Node : ");

				dataString = reader.readLine();
				node = null;
				if (dataString != null && dataString.trim().length() > 0) {
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

	public static int maxInBTRec(BinaryNode root) {
		int max = Integer.MIN_VALUE;

		if (root != null) {
			int leftMax = maxInBTRec(root.left);
			int rightMax = maxInBTRec(root.right);

			max = leftMax > rightMax ? leftMax : rightMax;

			if (root.data > max)
				max = root.data;
		}

		return max;
	}

	public static int maxInBT(BinaryNode root) {
		int max = Integer.MIN_VALUE;

		if (root != null) {
			Queue<BinaryNode> nodeQueue = new LinkedList<BinaryNode>();
			nodeQueue.offer(root);

			while (!nodeQueue.isEmpty()) {
				BinaryNode node = nodeQueue.poll();

				if (node.left != null)
					nodeQueue.offer(node.left);
				if (node.right != null)
					nodeQueue.offer(node.right);

				if (max < node.data)
					max = node.data;
			}
		}

		return max;
	}

	public static int minInBTRec(BinaryNode root) {
		int min = Integer.MAX_VALUE;

		if (root != null) {
			int leftMin = maxInBTRec(root.left);
			int rightMin = maxInBTRec(root.right);

			min = leftMin < rightMin ? leftMin : rightMin;

			if (root.data < min)
				min = root.data;
		}

		return min;
	}

	public static boolean elementExistInBT(BinaryNode root, int element) {
		boolean elementExist = Boolean.FALSE;

		if (root == null)
			elementExist = false;
		else if (root.data == element)
			elementExist = true;
		else
			elementExist = elementExistInBT(root.left, element) || elementExistInBT(root.right, element);

		return elementExist;
	}
	
	public static boolean elementExistInBST(BinaryNode root,int element) {
		boolean elementExist = Boolean.FALSE;
		
		if(root == null)
			elementExist = Boolean.FALSE;
		else if(root.data == element)
			elementExist = Boolean.TRUE;
		else if(root.data > element)
			elementExist = elementExistInBST(root.left, element);
		else if(root.data < element)
			elementExist = elementExistInBST(root.right, element);
		
		return elementExist;
	}
	
	public static boolean elementExistInBSTIterative(BinaryNode root,int element) {
		boolean elementExist = Boolean.FALSE;
		
		if(root != null) {
			while(root != null) {
				if(root.data == element) {
					elementExist = Boolean.TRUE;
					break;
				}else if(root.data < element)
					root = root.right;
				else if(root.data > element)
					root = root.left;
			}
		}
		
		return elementExist;
	}

	public static BinaryNode insertElement(BinaryNode root, int data) {
		if (root != null) {
			BinaryNode node = new BinaryNode(data);

			BinaryNode current = root;

			while (current.left != null)
				current = current.left;

			current.left = node;
		}

		return root;
	}

	public static BinaryNode insertElementRecursive(BinaryNode root, int data) {
		if (root == null)
			return new BinaryNode(data);
		else {
			if (root.data >= data) {
				if (root.left == null)
					root.left = new BinaryNode(data);
				else
					insertElement(root.left, data);
			} else {
				if (root.right == null)
					root.right = new BinaryNode(data);
				else
					insertElement(root.right, data);
			}
		}

		return root;
	}

	public static int sizeOfBT(BinaryNode root) {
		if (root == null)
			return 0;

		return sizeOfBT(root.left) + sizeOfBT(root.right) + 1;
	}
	
	public static int heightOfBT(BinaryNode root) {
		if(root == null)
			return 0;
		
		int leftHeight = heightOfBT(root.left);
		int rightHeight = heightOfBT(root.right);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}

	public static int diameterOfBT(BinaryNode root) {
		if(root == null)
			return 0;
		
		int lHeight = heightOfBT(root.left);
		int rHeight = heightOfBT(root.right);
		
		int lDiameter = diameterOfBT(root.left);
		int rDiameter = diameterOfBT(root.right);
		
		return Math.max((lHeight + rHeight + 1), Math.max(lDiameter, rDiameter));
	}
	
	public static int minInBT(BinaryNode root) {
		int min = Integer.MAX_VALUE;

		if (root != null) {
			Queue<BinaryNode> nodeQueue = new LinkedList<BinaryNode>();
			nodeQueue.offer(root);

			while (!nodeQueue.isEmpty()) {
				BinaryNode node = nodeQueue.poll();

				if (node.left != null)
					nodeQueue.offer(node.left);
				if (node.right != null)
					nodeQueue.offer(node.right);

				if (min > node.data)
					min = node.data;
			}
		}

		return min;
	}
	
	public static int numberOfLeavesRec(BinaryNode root) {
		if(root == null)
			return 0;
		
		if(root.left == null && root.right == null)
			return 1;
		
		return numberOfLeavesRec(root.left) + numberOfLeavesRec(root.right);
	}
	
	public static int numberOfFullLeavesRec(BinaryNode root) {

		if(root == null)
			return 0;
	
		if(root.left != null && root.right != null)
			numberOfLeaves++;
		
		numberOfFullLeavesRec(root.left);
		numberOfFullLeavesRec(root.right);
		
		return numberOfLeaves;
	}
	
	public static int widthOfBT(BinaryNode root) {
		int width = 0;
		
		if(root != null) {
			Queue<BinaryNode> nodesQueue = new LinkedList<BinaryNode>();
			
			nodesQueue.offer(root);
			nodesQueue.offer(null);
			int w = 0;
			
			while(!nodesQueue.isEmpty()) {
				BinaryNode node = nodesQueue.poll();
				
				if(node != null) {
					if(node.left != null)
						nodesQueue.offer(node.left);
					
					if(node.right != null)
						nodesQueue.offer(node.right);
					
					w++;
				}else {
					if(!nodesQueue.isEmpty()) {
						width = Math.max(w, width);
						w = 0;
						
						nodesQueue.offer(null);
					}
				}
			}
		}
		
		return width;
	}
	
	public static int widthInclusiveNullNodes(BinaryNode root) {
		return widthInclusiveNullNodesHelper(root, 1, 1);
	}
	
	private static int widthInclusiveNullNodesHelper(BinaryNode root,int level,int position) {
		if(root == null)
			return 0;
		
		if(level > leftMostNodesPosition.size())
			leftMostNodesPosition.add(position);
		
		widthInclusiveNullNodesHelper(root.left,level+1,position*2);
		widthInclusiveNullNodesHelper(root.right,level+1,position*2+1);
		
		width = Math.max(width, position - leftMostNodesPosition.get(level-1) + 1);
		
		return width;
	}

	public static List<Integer> pathBetweenNodes(BinaryNode root,int a,int b){
		List<Integer> pathA = pathOfNode(root,a);
		List<Integer> pathB = pathOfNode(root,b);
		int i = 0;
		
		while(i < Math.min(pathA.size(),pathB.size()) && pathA.get(i) == pathB.get(i))
			i++;
		
		i--;
		
		List<Integer> path = new LinkedList<>();
		
		if(i != pathA.size() || i != pathB.size()) {
			for(int j = pathA.size() - 1; j > i;j--)
				path.add(pathA.get(j));
			
			path.addAll(pathB.subList(i, pathB.size()));
		}
		
		return path;
	}
	public static List<Integer> pathOfNode(BinaryNode root,int x){
		List<Integer> pathList = new LinkedList<Integer>();
		
		pathExist(root,x,pathList);
			
		return pathList;
	}

	private static boolean pathExist(BinaryNode root, int x, List<Integer> pathList) {
		if(root == null)
			return false;
		
		pathList.add(root.data);
		
		if(root.data == x)
			return true;
		
		if(pathExist(root.left, x, pathList) || pathExist(root.right, x, pathList))
			return true;
		
		pathList.remove(pathList.size() - 1);
		
		return false;
	}
}
