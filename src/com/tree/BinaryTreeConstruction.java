package com.tree;

public class BinaryTreeConstruction {

	public static void main(String[] args) {
		int[] inOrder = {4,2,5,1,6,3};
		int[] preOrder = {1,2,4,5,3,6};
		
		BinaryNode root = new BinaryTreeConstruction().InorderPreorderBinaryTree(inOrder, 0, inOrder.length-1, preOrder, 0);
		
		System.out.println(BinaryTreeTraversals.inOrderIterative(root));
	}
	
	public BinaryNode InorderPreorderBinaryTree(int[] inOrder,int iStart,int iEnd,int[] preOrder,int preStart) {
		if(iStart < 0 || iEnd >= inOrder.length)
			return null;
		
		iStart = getIndexOfElement(inOrder, preOrder[preStart]);
		
		BinaryNode node = new BinaryNode(preOrder[preStart]);
		node.left = InorderPreorderBinaryTree(inOrder, 0 , iStart - 1 , preOrder, preStart+1);
		node.right = InorderPreorderBinaryTree(inOrder, iStart + 1 , iEnd , preOrder, preStart+1);
		
		return node;
	}
	
	private int getIndexOfElement(int[] a,int element) {
		int index = -1;
		
		for(int i = 0;i < a.length;i++)
			if(element == a[i])
				index = i;
				
		return index;
	}
	
}
