package com.dsnalgomadeeasy.tree.common;

import com.tree.BinaryNode;

public class BinaryTreeNode<T extends Comparable<T>> implements Cloneable{
	private BinaryTreeNode<T> left;
	private BinaryTreeNode<T> right;
	T data;
	
	public BinaryTreeNode(T data) {
		this.data = data;
	}

	public BinaryTreeNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinaryTreeNode<T> left) {
		this.left = left;
	}

	public BinaryTreeNode<T> getRight() {
		return right;
	}

	public void setRight(BinaryTreeNode<T> right) {
		this.right = right;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	public BinaryTreeNode<T> clone() {
		Object o = null;

		try {
			o = super.clone();
		} catch (CloneNotSupportedException cnse) {
			cnse.printStackTrace();
		}
		return (BinaryTreeNode<T>)o;
	}
}
