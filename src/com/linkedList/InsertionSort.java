package com.linkedList;

public class InsertionSort {

	public static void main(String[] args) {
		SinglyLinkedList<Integer> sll = new SinglyLinkedList<>();
		sll.add(5);
		sll.add(1);
		sll.add(3);
		sll.add(2);
		sll.add(4);

		insertionSort(sll);
	}

	private static <T extends Comparable<T>> void insertionSort(SinglyLinkedList<T> list){
		NodeSLL<T> head = list.getHead();

		if(head == null || head.next == null)
			return;

		NodeSLL<T> temp = head;
		NodeSLL<T> startPointer = null;
		NodeSLL<T> prev = null;

		while(temp.next != null){
			prev = startPointer;
			startPointer = temp;
			temp = temp.next;
		}

		NodeSLL<T> beforeStartPointer = prev;
		NodeSLL<T> tail = temp;

		while(startPointer != null){
			NodeSLL<T> current = startPointer;
			
			while(current != tail){
				if(current.data.compareTo((T) current.next.data) > 0){
					// only two nodes
					if(prev != null)
						prev.next = current.next;

					//if swapping with first node then update startPointer
					if(current == startPointer)
						startPointer = current.next;
					
					//if swapping with tail update tail
					if(current.next == tail)
						tail = current;
					
					temp = current.next.next;
					current.next.next = current;
					current.next = temp;
				}
				
				current = current.next;
			}
			
			temp = startPointer;
			prev = null;
			startPointer = head;
			
			// to get startPointer and prev
			while(startPointer.next != temp){
				prev = startPointer;
				startPointer = startPointer.next;
			}

		}
	}
}