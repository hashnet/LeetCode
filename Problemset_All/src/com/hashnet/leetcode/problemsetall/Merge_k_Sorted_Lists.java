package com.hashnet.leetcode.problemsetall;
import java.util.Comparator;
import java.util.PriorityQueue;

import com.hashnet.leetcode.utility.LinkedListUtility;
import com.hashnet.leetcode.utility.ListNode;

public class Merge_k_Sorted_Lists {
	private class Pair{
		private int index;
		private int val;
		
		public Pair(int index, int val) {
			this.index = index;
			this.val = val;
		}
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
		PriorityQueue<Pair> minPQ = new PriorityQueue<>(new Comparator<Pair>() {
			@Override
			public int compare(Pair thisPair, Pair otherPair) {
				return thisPair.val - otherPair.val;
			}
		});
		
		for(int i=0; i<lists.length; i++) {
			if(lists[i] != null) {
				minPQ.add(new Pair(i, lists[i].val));
			}
		}
		
		ListNode head = null;
		ListNode prev = null;
		while(!minPQ.isEmpty()) {
			int minIndex = minPQ.remove().index;
			
			if(head == null) {
				head = lists[minIndex];
			} else {
				prev.next = lists[minIndex];
			}
			
			prev = lists[minIndex];
			lists[minIndex] = lists[minIndex].next;
			if(lists[minIndex] != null) minPQ.add(new Pair(minIndex, lists[minIndex].val));
		}
		
		return head;
	}

	public static void main(String[] args) {
		Merge_k_Sorted_Lists solution = new Merge_k_Sorted_Lists();
		
		ListNode l1 = LinkedListUtility.createList("1->4->5");
		ListNode l2 = LinkedListUtility.createList("1->3->4");
		ListNode l3 = LinkedListUtility.createList("2->6");
		ListNode[] lists = {l1, l2, l3};
		System.out.println(LinkedListUtility.linkedListToString(solution.mergeKLists(lists)));
	}
}
