package com.LinkedList;

public class SinglyLinkedList <T>{
	private NodeSLL<T> head;
	private int size;
	
	public SinglyLinkedList() {
		head = null;
		size = 0;
	}
	
	public NodeSLL<T> getHead() {
		return head;
	}

	public NodeSLL<T> insertAtHead(T data){
		NodeSLL<T> node = getNode(data);
		
		if(head == null)
			head = node;
		else{
			node.next = head;
			head = node;
		}
		size++;
		return head;
	}

	public NodeSLL<T> removeAtHead(){
		if(head == null)
			return null;
		
		NodeSLL<T> temp = head;
		head = head.next;
		
		return temp;
	}

	public NodeSLL<T> insertAtEnd(T data){
		NodeSLL<T> node = getNode(data);
		
		if(head == null)
			head = node;
		else{
			NodeSLL<T> temp = head;

			while(temp.next != null)
				temp = temp.next;
			
			temp.next = node;
		}
		size++;
		return head;
	}
	
	public NodeSLL<T> removeAtEnd(){
		if(head == null)
			return null;
	
		NodeSLL<T> temp = head;
		NodeSLL<T> prev = head;
		
		while(temp.next != null){
			prev = temp;
			temp = temp.next;
		}
		
		prev.next = null;
		
		return temp;
	}
	public NodeSLL<T> insertAtPosition(T data,int position){
		
		if(position > size)
			return null;
		
		if(position ==0 && head == null)
			head = getNode(data);
		else{
			NodeSLL<T> temp = head;
			NodeSLL<T> node = getNode(data);
			int count = 1;
			
			while(temp.next != null && count++ < position)
				temp = temp.next;
			
			if(count == position ){
				node.next = temp.next;
				temp.next = node;
			}
		}
		size++;
		return head;
	}
	
	public NodeSLL<T> removeAtPosition(int position){
		if(position > size || head == null)
			return null;
		
		NodeSLL<T> temp,prev;
		if(position == 1)
			temp = removeAtHead();
		else{
			int count = 1;
			temp = head;
			prev = head;
			
			while(temp != null && count++ < position){
				prev.next = temp;
				temp = temp.next;
			}
			
			if(count == position ){
				prev.next = temp.next;
				temp.next = null;
			}
		}
		
		return temp;
	}
	
	public void reverseLinksRecursive(NodeSLL<T> head){
		if(head == null)
			return;
		if(head.next == null){
			//base condition
			return;
		}
		reverseLinksRecursive(head.next);
		head.next.next = head;
		head.next = null;
		toString();
		return;
	}
	
	private NodeSLL<T> getNode(T data) {
		NodeSLL<T> node = new NodeSLL<T>();
		node.data = data;
		node.next = null;
		return node;
	}

	public int getSize(){
		return size;
	}
	
	@Override
	public String toString(){
		String output = "";
		if(head == null)
			output = "[]";
		else{
			NodeSLL<T> temp = head;
			output= "[";
			
			
			
			while(temp != null){
				output = output +","+temp.data;
				temp = temp.next;
			}
			
			output = output + "]\nsize:"+size;
		}
		return output;
		
	}
}
