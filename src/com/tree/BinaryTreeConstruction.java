package com.tree;

public class BinaryTreeConstruction {

	public static void main(String[] args) {
		int[] inOrder = {4,2,5,1,6,3};
		int[] preOrder = {1,2,4,5,3,6};
		
		BinaryNode root = new BinaryTreeConstruction().InorderPreorderBinaryTree(inOrder, 0, inOrder.length-1, preOrder, 0,preOrder.length -1);
		
		System.out.println(BinaryTreeTraversals.inOrderIterative(root));
	}
	
	public BinaryNode InorderPreorderBinaryTree(int[] inOrder,int iStart,int iEnd,int[] preOrder,int preStart,int preEnd) {
		if(iStart > iEnd)
			return null;
		
		if(preStart > preEnd)
			return null;
		
		int element = preOrder[preStart];
		int offset = getIndexOfElement(preOrder, element);
		BinaryNode node = new BinaryNode(element);
		
		node.left = InorderPreorderBinaryTree(inOrder, iStart , offset - 1, preOrder, preStart + 1, preStart + offset - iStart);
		node.right = InorderPreorderBinaryTree(inOrder, offset + 1, iEnd, preOrder, preStart + offset  - iStart + 1, preEnd);
		
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
