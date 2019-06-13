package com.hashnet.leetcode.amazon;

import com.hashnet.leetcode.utility.LinkedListUtility;
import com.hashnet.leetcode.utility.ListNode;

public class Merge_Two_Sorted_Lists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode prev = null;
		while(l1 != null || l2 != null) {
			ListNode node;
			if(l1 == null) {
				node = l2;
				l2 = l2.next;
			} else if(l2 == null) {
				node = l1;
				l1 = l1.next;
			} else if(l1.val <= l2.val){
				node = l1;
				l1 = l1.next;
			} else {
				node = l2;
				l2 = l2.next;
			}
			
			if(head == null) {
				head = node;
			} else {
				prev.next = node;
			}
			
			prev = node;
		}
		
		return head;
	}

	public static void main(String[] args) {
		Merge_Two_Sorted_Lists solution = new Merge_Two_Sorted_Lists();
		
		ListNode l1 = LinkedListUtility.createList("1->2->4");
		ListNode l2 = LinkedListUtility.createList("1->3->4");
		
		System.out.println(LinkedListUtility.linkedListToString(solution.mergeTwoLists(l1, l2)));
	}
}
