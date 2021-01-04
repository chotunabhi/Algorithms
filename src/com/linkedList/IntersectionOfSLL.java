package com.linkedList;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.linkedList.NodeSLL;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class IntersectionOfSLL {

	public static void main(String[] args) {
		NodeSLL<Integer> list1 = null,list2 = null;
		NodeSLL<Integer> node = new NodeSLL<>(5);
		list1 = node;
		
		node.next = new NodeSLL<>(9);
		node = node.next;
		
		NodeSLL<Integer> intersectNode = new NodeSLL<>(0);
		node.next = intersectNode;
		node = node.next;
		
		node.next = new NodeSLL<>(6);
		node = node.next;
		
		node.next = new NodeSLL<>(8);
		node = node.next;
		
		node.next = new NodeSLL<>(1);
		node = node.next;
		
		node = new NodeSLL<>(3);
		list2 = node;
		
		node.next = new NodeSLL<>(2);
		node = node.next;
		
		node.next = new NodeSLL<>(7);
		node = node.next;
		
		node.next = new NodeSLL<>(4);
		node = node.next;
		
		node.next = intersectNode;
		
		System.out.println(new IntersectionOfSLL().intesectionExistBF(list1, list2));
		System.out.println(new IntersectionOfSLL().intesectionExistHM(list1, list2));
		System.out.println(new IntersectionOfSLL().intesectionExistStack(list1, list2));
		System.out.println(new IntersectionOfSLL().intesectionExist(list1, list2));
	}

	private <T> boolean intesectionExistBF(NodeSLL<T> list1,NodeSLL<T> list2) {
		boolean iExist = Boolean.FALSE;
		NodeSLL<T> c1 = list1;
		
		while(c1 != null) {
			NodeSLL<T> c2 = list2;	
			while(c2 != null) {
				if(c1 == c2) {
					iExist = Boolean.TRUE;
					break;
				}
				
				c2 = c2.next;
			}
			
			if(iExist)
				break;
			
			c1 = c1.next;
		}
		
		return iExist;
	}
	
	private <T> boolean intesectionExistHM(NodeSLL<T> list1,NodeSLL<T> list2) {
		boolean iExist = Boolean.FALSE;
		NodeSLL<T> c1 = list1;
		Set<NodeSLL<T>> nodesSet = new HashSet<>();
		
		while(c1 != null) {
			nodesSet.add(c1);
			c1 = c1.next;
		}
		
		c1 = list2;
		
		while(c1 != null) {
			if(nodesSet.contains(c1)) {
				iExist = Boolean.TRUE;
				break;
			}
			
			c1 = c1.next;
		}
		
		return iExist;
	}
	
	private <T> boolean intesectionExistStack(NodeSLL<T> list1,NodeSLL<T> list2) {
		boolean iExist = Boolean.FALSE;
		
		NodeSLL<T> c1 = list1;
		NodeSLL<T> c2 = list2;
		
		Stack<NodeSLL<T>> s1 = new Stack<>();
		Stack<NodeSLL<T>> s2 = new Stack<>();
		
		while(c1 != null) {
			s1.push(c1);
			c1 = c1.next;
		}
		
		while(c2 != null) {
			s2.push(c2);
			c2 = c2.next;
		}
		
		while(!s1.isEmpty() && !s2.isEmpty()) 
			if(s1.pop() == s2.pop()) 
				iExist = Boolean.TRUE;
		
		return iExist;
	}
	
	private <T> boolean intesectionExist(NodeSLL<T> list1,NodeSLL<T> list2) {
		boolean iExist = Boolean.FALSE;
		NodeSLL<T> c1 = list1;
		NodeSLL<T> c2 = list2;
		
		int l1 = 0,l2 = 0,diff = 0;
		
		while(c1 != null) {
			l1++;
			c1 = c1.next;
		}
		
		while(c2 != null) {
			l2++;
			c2 = c2.next;
		}
		
		
		if(l1 >= l2) {
			c1 = list1;
			c2 = list2;
			diff = l1 - l2;
		}else {
			c1 = list2;
			c2 = list1;
			diff = l2 - l1;
		}
		
		for(int i = 0; i < diff; i++) 
			c1 = c1.next;

		while(c1 != null && c2 != null) {
			if(c1 == c2) {
				iExist = Boolean.TRUE;
				break;
			}
			
			c1 = c1.next;
			c2 = c2.next;
		}
			
		return iExist;
	}
}
