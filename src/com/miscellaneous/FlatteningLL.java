package com.miscellaneous;

public class FlatteningLL {

	public static void main(String[] args) {
		Node head = new Node(5);
		Node node = head,nextNode = head;
		
		node.next = new Node(10);
		node = node.next;
		node.next = new Node(19);
		node = node.next;
		node.next = new Node(28);
		
		node = nextNode;
		nextNode = node.next;
		node.down = new Node(7);
		node = node.down;
		node.down = new Node(8);
		node = node.down;
		node.down = new Node(30);
		
		node = nextNode;
		nextNode = nextNode.next;
		node.down = new Node(20);

		node = nextNode;
		nextNode = nextNode.next;
		node.down = new Node(22);
		node = node.down;
		node.down = new Node(80);
		
		node = nextNode;
		nextNode = nextNode.next;
		node.down = new Node(35);
		node = node.down;
		node.down = new Node(40);
		node = node.down;
		node.down = new Node(45);
		
		FlatteningLL fll = new FlatteningLL();
		fll.printNFList(head);
		node = fll.flatten(head);
		System.out.println();
		fll.printList(node);
	}

	private void printNFList(Node head) {
		Node node = head,nextNode = head.next;
		
		while(node != null) {
			System.out.print(node.data+" ");
			
			if(node.down != null) {
				node = node.down;
			}else{
				
				node = nextNode;
				System.out.println();
				nextNode = node != null?node.next:node;
			}
		}
	}
	private void printList(Node head) {
		Node current = head;
		
		while(current != null) {
			System.out.print(current.data+" ");
			current = current.next;
		}
		
	}

	public Node flatten(Node root) {
		if(root == null || root.next == null)
			return root;

		Node current = root;

		while(current.next != null) {
			if(current.down != null) {
				if(current.down.data <= current.next.data) {
					current.down.next = current.next;
					current.next = current.down;
				}else {
					current.next = mergeSortedSLL(current.down,current.next);
				}
				
				current.down = null;
			}
			
			current = current.next;
		}
		
		while(current != null) {
			current.next = current.down;
			current = current.down;
		}

		return root;
	}

	private Node mergeSortedSLL(Node l1, Node l2) {
		Node head = l2;
		Node prev = null;

		while(l1 != null && l2!= null) {
			if(l1.data <= l2.data) {
				if(prev != null)
					prev.down = l1;
				
				prev = l1;
				l1 = l1.down;
			}else {
				if(prev != null)
					prev.down = l2;
				
				prev = l2;
				l2 = l2.down;
			}
		}

		if(l2 == null) {
			prev.down = l1;
		}

		if(l1 == null) {
			prev.down = l2;
		}

		return head;

	}
}
class Node{
	int data;
	Node next;
	Node down;

	public Node(int data) {
		this.data = data;
	}
}
