package com.miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class JosephusTest {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		System.out.print("Enter number of persons :");
		int n = Integer.parseInt(reader.readLine());
		System.out.print("Enter which person to be killed :");
		int k = Integer.parseInt(reader.readLine());

		System.out.println(josephusCll(n, k));
	}

	/**
	 * function to return the person who survives using recursive
	 * 
	 * @param n
	 *            - number of persons in circle
	 * @param k
	 *            - killing every kth person
	 * @return person finally who survives
	 */
	public static int josephus(int n, int k) {
		if (n == 1)
			return 1;

		return (josephus(n - 1, k) + k - 1) % n + 1;
	}

	/**
	 * function to return the person who survives using circular linked list
	 * 
	 * @param n
	 *            - number of persons in circle
	 * @param k
	 *            - killing every kth person
	 * @return person finally who survives
	 */
	public static int josephusCll(int n, int k) {
/*		CircularListNode<Integer> circle = new CircularListNode<>();

		for (int i = 1; i <= n; i++)
			circle.insertAtTail(i);

		int i = 1;
		
		NodeSLL<Integer> killer = circle.head;
		
		while(killer.next != killer){
			while(i++ != k - 1)
				killer = killer.next;
			
			circle.delete((Integer) killer.next.data);
			
			i = 1;
			killer = killer.next;
		}
		
		return killer.data;*/
		return -1;
	}
}
