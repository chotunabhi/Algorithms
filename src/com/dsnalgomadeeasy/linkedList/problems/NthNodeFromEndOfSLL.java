package com.dsnalgomadeeasy.linkedList.problems;

import java.util.Hashtable;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class NthNodeFromEndOfSLL {
	private static int position = 0;
	
	public static void main(String[] args) {
		NodeSLL<Integer> node = new NodeSLL<>(1);
		NodeSLL<Integer> next = node;

		next.setNext(new NodeSLL<>(2));
		next = next.getNext();

		next.setNext(new NodeSLL<>(3));
		next = next.getNext();

		next.setNext(new NodeSLL<>(4));
		next = next.getNext();

		next.setNext(new NodeSLL<>(5));
		next = next.getNext();

//		System.out.println(new NthNodeFromEndOfSLL().bruteForce(node, -1));
//		System.out.println(new NthNodeFromEndOfSLL().usingStack(node, -1));
//		System.out.println(new NthNodeFromEndOfSLL().usingHT(node, 10));
//		System.out.println(new NthNodeFromEndOfSLL().usingLengthOfSLL(node, -2));
//		System.out.println(new NthNodeFromEndOfSLL().usingStack(node, 10));
		System.out.println(new NthNodeFromEndOfSLL().usingRecursion(node, 5));
	}

	private <T> T bruteForce(NodeSLL<T> sll,int n){
		T data = null;

		if(sll == null) {
			System.out.println("List is null");
		}else if(n <= 0) {
			System.out.println("n should be >= 0");
		}else {
			NodeSLL<T> mySLL = sll;

			while(mySLL != null) {
				NodeSLL<T> node = mySLL;
				int size = 0;

				while(node != null) {
					size++;
					node = node.getNext();
				}

				if(size == n) {
					data =  mySLL.getData();
					break;
				}else if(size < n) {
					System.out.println("No data available");
					break;
				}else {
					mySLL = mySLL.getNext();
				}
			}

		}

		return data;
	}

	private <T> T usingStack(NodeSLL<T> sll,int n) {
		T data = null;

		if(sll == null) {
			System.out.println("List is null");
		}else if(n <= 0) {
			System.out.println("n should be >= 0");
		}else {
			NodeSLL<T> node = sll;
			Stack<T> nodeStack = new Stack<>();

			while(node != null) {
				nodeStack.push(node.getData());

				node = node.getNext();
			}

			while(n-- > 0) {
				data = nodeStack.isEmpty()?null : nodeStack.pop();
			}
		}
		
		return data;
	}
	
	private<T> T usingHT(NodeSLL<T> sll,int n) {
		T data = null;
		Hashtable<Integer, T> listTable = new Hashtable<>();
		
		if(sll == null) {
			System.out.println("List is null");
		}else if(n <= 0) {
			System.out.println("n should be >= 0");
		}else {
			NodeSLL<T> node = sll;
			int index = 1;
			
			while(node != null) {
				listTable.put(index++, node.getData());
				node = node.getNext();
			}
			
		}
		
		if(listTable.size() > 0) {
			data = listTable.get(n);
		}
		
		return data;
	}
	
	private<T> T usingLengthOfSLL(NodeSLL<T> sll,int n) {
		T data = null;
		
		if(sll == null) {
			System.out.println("List is null");
		}else if(n <= 0) {
			System.out.println("n should be >= 0");
		}else {
			NodeSLL<T> node = sll;
			int length = 1;
			
			while(node != null) {
				length++;
				node = node.getNext();
			}
			
			if(length >= n) {
				node = sll;
				
				int cl = length - n;
				
				while(cl-- > 1) 
					node = node.getNext();
			}
			
			if(node != null)
				data = node.getData();
		}
		
		return data;
	}
	
	private<T> T usingOnePass(NodeSLL<T> sll,int n) {
		T data = null;
		
		if(sll == null) {
			System.out.println("List is null");
		}else if(n <= 0) {
			System.out.println("n should be >= 0");
		}else {
			NodeSLL<T> advPointer = sll;
			NodeSLL<T> dataPointer = sll;
			
			while(n-- > 1) 
				advPointer = advPointer.getNext();
			
			while(advPointer != null) {
				dataPointer = dataPointer.getNext();
				advPointer = advPointer.getNext();
			}
			
			if(dataPointer != null)
				data = dataPointer.getData();
		}
		return data;
	}

	private<T> T usingRecursion(NodeSLL<T> sll,int n) {
		T data = null;
		
		if(sll != null) {
			data = usingRecursion(sll.getNext(), n);
		}
		
		if(position == n && sll != null) {
			data = sll.getData();
		}
		
		position++;
		
		return data;
	}
}
