package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class ModularNode {
	public <T extends Comparable<T>> T getModularNode(NodeSLL<T> head,int k) {
		T modularNode = null;
		int i = 1;
		NodeSLL<T> current = head;
		
		while(current != null && k > 0) {
			if(i++ % k == 0) {
				modularNode = current.getData();
			}
			
			current = current.getNext();
		}
		
		return modularNode;
	}
	
	public <T extends Comparable<T>> T getFirstElementOfModularNode(NodeSLL<T> head,int k) {
		T modularNodeData = null;
		int i = 1;
		NodeSLL<T> current = head,modularNode=null;
		
		if(k <= 0 || current == null)
			return modularNodeData;
		
		while(current != null && i++ < k) 
			current = current.getNext();
		
		modularNodeData = current == null || current == head? null : head.getData();
		
		if(current == null)
			return modularNodeData;
		
		current = current.getNext();
		modularNode = current;
		
		while(current != null) {
			if(i++ % k == 0) {
				modularNodeData = modularNode.getData();
				modularNode = current.getNext();
			}
			
			current = current.getNext();
		}
		
		return modularNodeData;
	}
	
	public <T extends Comparable<T>> T getFractionalNode(NodeSLL<T> head,int k) {
		int i = 0;
		NodeSLL<T> current = head,fractionalNode=null;
		
		if(k <= 0 || current == null)
			return null;
		
		while(current != null) {
			if(i++%k == 0) 
				fractionalNode = fractionalNode == null ? head : fractionalNode.getNext();
			
			current = current.getNext();
		}
		
		return fractionalNode == null? null : fractionalNode.getData();
	}
}
