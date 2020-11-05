package com.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AVLTree {

	public static void main(String[] args) {
		boolean done = false;
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		AVLTree tree = new AVLTree();

		String str;
		BinaryNode root = null;

		try {
			do {
				System.out.print("Enter data:");
				str = reader.readLine();

				if (str != null && !"".equals(str))
					root = tree.insert(root, Integer.parseInt(str));

			} while (str != null && !str.equals(""));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(BinaryTreeTraversals.preOrderIterative(root));
		BinaryTreeTraversals.clear();
		System.out.print(BinaryTreeTraversals.inOrderIterative(root));
	}

    private BinaryNode leftRotate(BinaryNode root){
    	BinaryNode newRoot = root.right;
        root.right = root.right.left;
        newRoot.left = root;
        
        setHeight(root);
        setHeight(newRoot);
        
        return newRoot;
    }
    
    private BinaryNode rightRotate(BinaryNode root){
    	BinaryNode newRoot = root.left;
        root.left = root.left.right;
        newRoot.right = root;
        
        setHeight(root);
        setHeight(newRoot);
        
        return newRoot;
    }

    private void setHeight(BinaryNode root){
        if(root != null)
        	root.height = 1 + Math.max((root.left != null ? root.left.height : 0), (root.right != null ? root.right.height : 0));
    }
    
    private int height(BinaryNode root){
        return root == null?0:root.height;
    }
    
    public BinaryNode insert(BinaryNode root, int data){
        if(root == null){
            return new BinaryNode(data);
        }
        
        if(root.data <= data){
            root.right = insert(root.right,data);
        }else{
            root.left = insert(root.left,data);
        }
        
        int balance = balance(root.left, root.right);
        
        if(balance > 1){
            if(height(root.left.left) >= height(root.left.right)){
                root = rightRotate(root);
            }else{
                root.left = leftRotate(root.left);
                root = rightRotate(root);
            }
        }else if(balance < -1){
            if(height(root.right.right) >= height(root.right.left)){
                root = leftRotate(root);
            }else{
                root.right = rightRotate(root.right);
                root = leftRotate(root);
            }
        }else{
            setHeight(root);
        }
        
        return root;
    }
    
    private int balance(BinaryNode rootLeft, BinaryNode rootRight){
        return height(rootLeft) - height(rootRight);
    }
}
