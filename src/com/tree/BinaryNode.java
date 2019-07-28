package com.tree;

public class BinaryNode implements Cloneable {
	int data;
	BinaryNode left;
	BinaryNode right;

	public BinaryNode(int data) {
		this.data = data;
	}

	public BinaryNode clone() {
		Object o = null;

		try {
			o = super.clone();
		} catch (CloneNotSupportedException cnse) {
			cnse.printStackTrace();
		}
		return (BinaryNode)o;
	}
	
	@Override
	public String toString() {
		return this.data+" ";
	}
}
