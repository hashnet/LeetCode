package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.LinkedListUtility;
import com.hashnet.leetcode.utility.ListNode;

public class Add_Two_Numbers2 {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) return null;
		
		int rem = 0;
		ListNode head = null;
		ListNode prev = null;
		do {
			int n1 = (l1 == null ? 0 : l1.val);
			int n2 = (l2 == null ? 0 : l2.val);
			int sum = n1 + n2 + rem;
			rem = sum >= 10 ? 1 : 0;
			sum %= 10;
			
			ListNode node = new ListNode(sum);
			if(head == null) {
				head = node;
			} else {
				prev.next = node;
			}
			
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
			prev = node;
		} while(!(l1 == null && l2 == null && rem != 1));
		
		return head;
	}

	public static void main(String[] args) {
		Add_Two_Numbers2 solution = new Add_Two_Numbers2();
		
		ListNode l1 = LinkedListUtility.createList("2 -> 4 -> 3");
		ListNode l2 = LinkedListUtility.createList("5 -> 6 -> 4");
		System.out.println(LinkedListUtility.linkedListToString(solution.addTwoNumbers(l1, l2)));
		
		l1 = LinkedListUtility.createList("9");
		l2 = LinkedListUtility.createList("5 -> 6 -> 4");
		System.out.println(LinkedListUtility.linkedListToString(solution.addTwoNumbers(l1, l2)));
	}
}
