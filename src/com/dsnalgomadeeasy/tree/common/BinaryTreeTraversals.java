package com.dsnalgomadeeasy.tree.common;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import com.dsnalgomadeeasy.stack.common.StackLL;

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

		}
	}

	private void inOrderIterative(BinaryTreeNode<Integer> root) {
		if(root != null) {
		
		}
	}

	private void preOrderIterative(BinaryTreeNode<Integer> root) {
		if(root != null) {
			resultList.clear();

			Stack<BinaryTreeNode<Integer>> nodeStack = new Stack<>();
			nodeStack.push(root);

			while(!nodeStack.isEmpty()) {
				BinaryTreeNode<Integer> currentNode = nodeStack.pop();

				resultList.add(currentNode.getData());

				if(currentNode.getRight() != null)
					nodeStack.push(currentNode.getRight());
				if(currentNode.getLeft() != null)
					nodeStack.push(currentNode.getLeft());
			}

		}
	}

	public void preOrder(BinaryTreeNode<Integer> root) {
		if(root != null) {
			resultList.add(root.data);
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public void inOrder(BinaryTreeNode<Integer> root) {
		if(root != null) {
			inOrder(root.getLeft());
			resultList.add(root.data);
			inOrder(root.getRight());
		}
	}

	public void postOrder(BinaryTreeNode<Integer> root) {
		if(root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			resultList.add(root.data);
		}
	}

	public void levelOrderTraversal(BinaryTreeNode<Integer> root) {
		if(root == null)
			return;

		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.offer(root);

		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> node = queue.poll();

			if(node.getLeft() != null)
				queue.offer(node.getLeft());
			if(node.getRight() != null)
				queue.offer(node.getRight());

			resultList.add(node.data);
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
