package com.dsnalgomadeeasy.linkedList.problems;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Stack;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class IntersectionOfSLLs {
	public <T extends Comparable<T>> NodeSLL<T> getNodeIntersectedBruteForce(NodeSLL<T> head1,NodeSLL<T> head2) {
		NodeSLL<T> intersectedNode = null;

		while(head1 != null && intersectedNode == null) {
			NodeSLL<T> current = head2;

			while(current != null) {
				if(head1 == current) {
					intersectedNode = head1;
					break;
				}

				current = current.getNext();
			}

			head1 = head1.getNext();
		}
		return intersectedNode;
	}

	public <T extends Comparable<T>> NodeSLL<T> getNodeIntersectedUsingHashTable(NodeSLL<T> head1,NodeSLL<T> head2) {
		NodeSLL<T> areIntersected = null;
		HashSet<NodeSLL<T>> dataSet = new HashSet<>();

		while(head1 != null) {
			dataSet.add(head1);
			head1 = head1.getNext();
		}

		while(head2 != null) {
			if(dataSet.contains(head2)) {
				areIntersected = head2;
				break;
			}

			head2 = head2.getNext();
		}
		return areIntersected;
	}

	public <T extends Comparable<T>> NodeSLL<T> getNodeIntersectedUsingStack(NodeSLL<T> head1,NodeSLL<T> head2) {
		NodeSLL<T> intersectedNode = null;

		java.util.Stack<NodeSLL<T>> stack1 = new java.util.Stack<NodeSLL<T>>();
		java.util.Stack<NodeSLL<T>> stack2 = new java.util.Stack<NodeSLL<T>>();

		while(head1 != null) {
			stack1.push(head1);
			head1 = head1.getNext();
		}

		while(head2 != null) {
			stack2.push(head2);
			head2 = head2.getNext();
		}

		while(!stack1.isEmpty() && !stack2.isEmpty()) {
			if(!stack1.peek().equals(stack2.pop())) {
				break;
			}

			intersectedNode = stack1.pop();
		}
		return intersectedNode;
	}

	public <T extends Comparable<T>> NodeSLL<T> getNodeIntersectedUsingArray(NodeSLL<T> head1,NodeSLL<T> head2) {
		NodeSLL<T> intersectedNode = null;
		int length1 = 0, length2 = 0,counter = 0;

		NodeSLL<T> node = head1;

		while(node != null) {
			length1++;
			node = node.getNext();
		}

		node = head2;
		while(node != null) {
			length2++;
			node = node.getNext();
		}

		if(length1!= 0  && length2 != 0) {
			NodeSLL<T>[] listsArray = (NodeSLL<T>[])Array.newInstance(head1.getClass(), length1+length2);

			while(head1 != null) {
				listsArray[counter++] = head1;
				head1 = head1.getNext();
			}

			while(head2 != null) {
				listsArray[counter++] = head2;
				head2 = head2.getNext();
			}

			for(int i = 0; i < length1 && intersectedNode == null; i++) {
				for(int j = length1; j < length2 + length1; j++) {
					if(listsArray[i] == listsArray[j]) {
						intersectedNode = listsArray[i];
						break;
					}
				}
			}
		}
		return intersectedNode;
	}
	
	public <T extends Comparable<T>> NodeSLL<T> getNodeIntersectedWithON(NodeSLL<T> head1,NodeSLL<T> head2) {
		NodeSLL<T> intersectedNode = null;
		int length1 = 0, length2 = 0,counter = 0;

		NodeSLL<T> node = head1,list1 = head1,list2 = head2;

		while(node != null) {
			length1++;
			node = node.getNext();
		}

		node = head2;
		while(node != null) {
			length2++;
			node = node.getNext();
		}

		if(length1!= 0  && length2 != 0) {
			int diff = -1;
			
			if(length1 < length2) {
				list1 = head2;
				list2 = head1;
				
				diff = length2 - length1;
			}else
				diff = length1 - length2;
			
			while(diff-- > 0) 
				list1 = list1.getNext();
			
			while(list1 != null && list2 != null) {
				if(list1 == list2) {
					intersectedNode = list1;
					break;
				}
				
				list1 = list1.getNext();
				list2 = list2.getNext();
			}
		}
		return intersectedNode;
	}
}
