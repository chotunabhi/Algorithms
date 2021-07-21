package com.dsnalgomadeeasy.linkedList.common;

public class NodeSLL<T extends Comparable<T>> {
	private NodeSLL<T> next;
	private T data;
	
	public NodeSLL(T data) {
		this.data = data;
	}
	
	public NodeSLL<T> getNext() {
		return next;
	}
	public void setNext(NodeSLL<T> next) {
		this.next = next;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
