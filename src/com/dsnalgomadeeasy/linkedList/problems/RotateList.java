package com.dsnalgomadeeasy.linkedList.problems;

import com.dsnalgomadeeasy.linkedList.common.NodeSLL;

public class RotateList {
	public <T extends Comparable<T>> NodeSLL<T> getRotatedList(NodeSLL<T> head, int k) {
		NodeSLL<T> newHead = head, tail = null, prev = null,current = head;
		int i = 1,n = k;

		if (head != null) {
			if(k < 0) {
				n = -1 * n;
				while(i++ <= n) {
					prev = current;
					current = current.getNext();

					if(current == null)
						current = head;
				}

				if(current != head) {
					tail = current;

					while(tail.getNext() != null)
						tail = tail.getNext();

					tail.setNext(head);
					prev.setNext(null);
					newHead = current;
				}
			}else if(k > 0) {
				tail = head;

				while(i++ < n) {
					tail = tail.getNext();

					if(tail == null)
						tail = head;
				}

				if(tail.getNext() !=  null) {
					while(tail.getNext() != null) {
						prev = current;
						current = current.getNext();

						tail = tail.getNext();
					}

					tail.setNext(head);
					prev.setNext(null);
					newHead = current;
				}
			}
		}

		return newHead;
	}
}
