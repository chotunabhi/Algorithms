package com.dsnalgomadeeasy.tree.common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeTraversals {
	public enum TraversalMethod {
		PREORDER, PREORDER_IT, INORDER, INORDER_IT, POSTORDER, POSTORDER_IT, LEVELORDER
	}

	private List<Integer> resultList = new LinkedList<>();

	public BinaryTreeTraversals() {
		clear();
	}

	public void clear() {
		resultList.clear();
	}

	public List<Integer> getResultList() {
		return resultList;
	}

	public Object[] getTreeAsArray(BinaryTreeNode<Integer> root, TraversalMethod traversalMethod) {
		return getTreeAsList(root, traversalMethod).toArray();
	}
	public List<Integer> getTreeAsList(BinaryTreeNode<Integer> root, TraversalMethod traversalMethod) {
		resultList.clear();

		switch (traversalMethod) {
		case PREORDER:
			preOrder(root);
			break;
		case PREORDER_IT:
			preOrderIterative(root);
			break;
		case INORDER:
			inOrder(root);
			break;
		case INORDER_IT:
			inOrderIterative(root);
			break;
		case POSTORDER:
			postOrder(root);
			break;
		case POSTORDER_IT:
			postOrderIterative(root);
			break;
		case LEVELORDER:
			levelOrderTraversal(root);
			break;
		}

		return resultList;
	}

	private void postOrderIterative(BinaryTreeNode<Integer> root) {
		if(root != null) {
			BinaryTreeNode<Integer> current,previous = null;
			Stack<BinaryTreeNode<Integer>> nodeStack = new Stack<BinaryTreeNode<Integer>>();
			nodeStack.push(root);
			
			while(!nodeStack.isEmpty()) {
				current = nodeStack.peek();
				
				if(previous == null || previous.getLeft() == current || previous.getRight() == current) {
					if(current.getLeft() != null) {
						nodeStack.push(current.getLeft());
					}else if(current.getRight() != null) {
						nodeStack.push(current.getRight());
					}
				}else if(current.getLeft() == previous) {
					if(current.getRight() != null) {
						nodeStack.push(current.getRight());
					}
				}else {
					resultList.add(nodeStack.pop().getData());
				}
				
				previous = current;
			}
		}
	}

	private void inOrderIterative(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;

		boolean done = false;

		Stack<BinaryTreeNode<Integer>> nodeStack = new Stack<>();
		BinaryTreeNode<Integer> currentNode = root;

		while(!done) {
			if(currentNode != null) {
				nodeStack.push(currentNode);
				currentNode = currentNode.getLeft();
			}else {
				if(nodeStack.isEmpty())
					done = true;
				else {
					currentNode = nodeStack.pop();
					resultList.add(currentNode.getData());

					currentNode = currentNode.getRight();
				}
			}
		}
	}

	private void preOrderIterative(BinaryTreeNode<Integer> root) {
		resultList.clear();

		if(root != null) {
			Stack<BinaryTreeNode<Integer>> preOrderStack = new Stack<>();
			preOrderStack.push(root);

			while(!preOrderStack.isEmpty()) {
				BinaryTreeNode<Integer> node = preOrderStack.pop();

				resultList.add(node.getData());

				if(node.getRight() != null)
					preOrderStack.push(node.getRight());

				if(node.getLeft() != null)
					preOrderStack.push(node.getLeft());
			}
		}

	}

	public void preOrder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			resultList.add(root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public void inOrder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			inOrder(root.getLeft());
			resultList.add(root.getData());
			inOrder(root.getRight());
		}
	}

	public void postOrder(BinaryTreeNode<Integer> root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			resultList.add(root.getData());
		}
	}

	public void levelOrderTraversal(BinaryTreeNode<Integer> root) {
		resultList.clear();

		if (root == null)
			return;

		Queue<BinaryTreeNode<Integer>> nodesQueue = new LinkedList<>();
		nodesQueue.offer(root);

		while (!nodesQueue.isEmpty()) {
			BinaryTreeNode<Integer> node = nodesQueue.poll();
			resultList.add(node.getData());

			if (node.getLeft() != null)
				nodesQueue.offer(node.getLeft());

			if (node.getRight() != null)
				nodesQueue.offer(node.getRight());
		}
	}

	public static void main(String args[]) {
		String data[] = { "4", "2", "6", "1", "3", "5", "7" };

		BinaryTreeTraversals btt = new BinaryTreeTraversals();
		BinaryTreeNode<Integer> root = BinaryTreeUtil.buildTree(data);
		btt.preOrder(root);
		System.out.println(btt.getResultList());

		btt.clear();
		btt.inOrder(root);
		System.out.println(btt.getResultList());

		btt.clear();
		btt.postOrder(root);
		System.out.println(btt.getResultList());

		btt.levelOrderTraversal(root);
		System.out.println(btt.getResultList());
	}
}
