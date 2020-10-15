package com.miscellaneous;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class MaximumSlidingWindow {

	public static void main(String[] args) {
		int[] a = {1,3,-1,-3,5,3,6,7,2,8,0,0,9};
		
		Deque<Integer> queue = new LinkedList<Integer>();
		
		int w = 3;
		int[] b = new int[a.length - w];
		int i = 0;
		
		for(i = 0 ; i < w; i++) {
			while(!queue.isEmpty() && a[queue.peekLast()] < a[i]) 
				queue.pollLast();
			
			queue.offerLast(i);
		}
		
		for(i = w; i < a.length ; i++) {
			b[i - w] = a[queue.peekFirst()];
			
			while(!queue.isEmpty() && a[queue.peekLast()] < a[i]) 
				queue.pollLast();
			
			while(!queue.isEmpty() && i - queue.peekFirst() >= w)
				queue.pollFirst();
			
			queue.offerLast(i);
		}
		
		if(!queue.isEmpty()) {
			b[i - w - 1] = a[queue.pollFirst()];
		}
		
		Arrays.stream(b)
			.mapToObj(n -> Integer.toUnsignedString(n))
			.forEach(System.out::print);
	}

}
