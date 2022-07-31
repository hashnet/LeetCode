package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.LinkedListUtility;
import com.hashnet.leetcode.utility.ListNode;

public class Add_Two_Numbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode prev = null;
		
		int extra = 0;
		while(true) {
			if(l1 == null && l2 == null && extra == 0) break;
			
			int sum = 0;
			sum += extra;
			if(l1 != null) sum += l1.val;
			if(l2 != null) sum += l2.val;
			
			extra = sum / 10;
			sum %= 10;
			
			ListNode node = new ListNode(sum);
			node.next = null;
			
			if(head == null) head = node;
			
			if(prev != null) prev.next = node;
			prev = node;
			
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
		}
		
		return head;
	}

	public static void main(String[] args) {
		Add_Two_Numbers solution = new Add_Two_Numbers();
		
		
		ListNode l1 = LinkedListUtility.createList("(2 -> 4 -> 3)");
		System.out.println("l1  = " + LinkedListUtility.linkedListToString(l1));
		ListNode l2 = LinkedListUtility.createList("5 -> 6 -> 4");		
		System.out.println("l2  = " + LinkedListUtility.linkedListToString(l2));
		System.out.println("sum = " + LinkedListUtility.linkedListToString(solution.addTwoNumbers(l1, l2)));
		
		l1 = LinkedListUtility.createList("(0)");
		System.out.println("l1  = " + LinkedListUtility.linkedListToString(l1));
		l2 = LinkedListUtility.createList("()");		
		System.out.println("l2  = " + LinkedListUtility.linkedListToString(l2));
		System.out.println("sum = " + LinkedListUtility.linkedListToString(solution.addTwoNumbers(l1, l2)));
		l1 = LinkedListUtility.createList("(9 -> 9)");
		System.out.println("l1  = " + LinkedListUtility.linkedListToString(l1));
		l2 = LinkedListUtility.createList("(1)");		
		System.out.println("l2  = " + LinkedListUtility.linkedListToString(l2));
		System.out.println("sum = " + LinkedListUtility.linkedListToString(solution.addTwoNumbers(l1, l2)));
	}
	
	
}
