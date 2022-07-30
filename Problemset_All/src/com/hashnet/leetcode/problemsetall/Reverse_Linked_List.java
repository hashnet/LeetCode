package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.LinkedListUtility;
import com.hashnet.leetcode.utility.ListNode;

public class Reverse_Linked_List {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode curr = head;

		while(curr != null) {
			ListNode next = curr.next;
			curr.next = prev;

			prev = curr;
			curr = next;
		}

		return prev;
	}

	public static void main(String[] args) {
		Reverse_Linked_List solution = new Reverse_Linked_List();
		
		ListNode node = LinkedListUtility.createList("1->2->3->4->5");
		System.out.println("Original: " + LinkedListUtility.linkedListToString(node));
		System.out.println("Reversed: " + LinkedListUtility.linkedListToString(solution.reverseList(node)));
	}
}
