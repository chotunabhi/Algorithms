package com.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversals {
	static LinkedList<BinaryNode> listOfNodes = new LinkedList<>();
	
	public static void clear() {
		if(listOfNodes != null)
			listOfNodes.clear();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryNode root = BinaryTreeUtil.buildTree();
//		preOrder(root,listOfNodes);
//		System.out.println(listOfNodes);
//		listOfNodes.clear();
//		
//		listOfNodes = preOrderIterative(root);
//		System.out.println(listOfNodes);
//		listOfNodes.clear();
//
		listOfNodes = inOrderIterative(root);
		System.out.println(listOfNodes);
		listOfNodes.clear();
		
		inOrder(root,listOfNodes);
		System.out.println(listOfNodes);
		listOfNodes.clear();
//		
//		postOrder(root,listOfNodes);
//		System.out.println(listOfNodes);
//		listOfNodes.clear();
//		
//		postOrderIterative(root);
//		System.out.println(listOfNodes);
	}

	public static void preOrder(BinaryNode root,LinkedList<BinaryNode> listNodes) {
		if(root != null) {
			listOfNodes.add(root);
			preOrder(root.left,listOfNodes);
			preOrder(root.right,listOfNodes);
		}
	}
	
	public static LinkedList<BinaryNode> preOrderIterative(BinaryNode root) {
		if(root == null)
			return listOfNodes;
		
		Stack<BinaryNode> stack = new Stack<>();
		stack.push(root);
		
		while(!stack.isEmpty()) {
			BinaryNode node = stack.pop();
			
			listOfNodes.add(node);
			
			if(node.right != null)
				stack.push(node.right);
			if(node.left != null)
				stack.push(node.left);
		}
		
		return listOfNodes;
	}
	
	public static void inOrder(BinaryNode root,LinkedList<BinaryNode> listNodes) {
		if(root != null) {
			inOrder(root.left,listNodes);
			listNodes.add(root);
			inOrder(root.right,listNodes);
		}
	}
	
	public static LinkedList<BinaryNode> inOrderIterative(BinaryNode root) {
		if(root == null)
			return listOfNodes;
		
		Stack<BinaryNode> stack = new Stack<BinaryNode>();
		BinaryNode current = root;
		boolean done = false;

		while(!done) {
			if(current != null) {
				stack.push(current);
				current = current.left;
			}else {
				if(stack.isEmpty())
					done = true;
				else {
					current = stack.pop();
					listOfNodes.add(current);
					current = current.right;
				}
			}
		}
		
		return listOfNodes;
	}
	
	public static void postOrder(BinaryNode root,LinkedList<BinaryNode> listNodes) {
		if(root != null) {
			postOrder(root.left,listNodes);
			postOrder(root.right,listNodes);
			listNodes.add(root);
		}
	}
	
	public static LinkedList<BinaryNode> postOrderIterative(BinaryNode root) {
		if(root != null) {
			BinaryNode current,prev = null;
			
			Stack<BinaryNode> stack = new Stack<BinaryNode>();
			stack.push(root);
			
			while(!stack.isEmpty()) {
				current = stack.peek();
				
				if(prev == null || prev.left == current || prev.right == current) {
					if(current.left != null)
						stack.push(current.left);
					else if(current.right != null)
						stack.push(current.right);
				}else if(current.left == prev) {
					if(current.right != null)
						stack.push(current.right);
				}else {
					listOfNodes.add(stack.pop());
				}
				
				prev = current;
			}
		}
			
		return listOfNodes;
			
	}
	
	public static LinkedList<BinaryNode> levelOrderTraversal(BinaryNode root){
		listOfNodes.clear();
		
		if(root != null) {
			Queue<BinaryNode> nodesQueue = new LinkedList<>();
			nodesQueue.offer(root);
			
			while(!nodesQueue.isEmpty()) {
				BinaryNode node = nodesQueue.poll();
				
				listOfNodes.add(node);
				
				if(node.left != null)
					nodesQueue.offer(node.left);
				
				if(node.right != null)
					nodesQueue.offer(node.right);
			}
		}
		
		return listOfNodes;
	}
}
