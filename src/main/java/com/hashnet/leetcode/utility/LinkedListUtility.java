package com.hashnet.leetcode.utility;

public class LinkedListUtility {
	public static ListNode createList(String str) {
		str = str.replaceAll("[\\s(){}\\[\\]]", "");

		String[] values = str.split("->");

		ListNode head = null;
		ListNode prev = null;
		for (int i = 0; i < values.length; i++) {
			if(values[i] == null || values[i].isEmpty()) continue;
			
			ListNode node = new ListNode(Integer.parseInt(values[i]));
			node.next = null;

			if (head == null)
				head = node;

			if (prev != null)
				prev.next = node;

			prev = node;
		}

		return head;
	}

	public static String linkedListToString(ListNode head) {
		StringBuilder sb = new StringBuilder();
		sb.append("(");

		while (head != null) {
			sb.append(head.val);

			if (head.next != null)
				sb.append(" -> ");

			head = head.next;
		}

		sb.append(")");

		return sb.toString();
	}

	public static void main(String[] args) {
		ListNode head1 = LinkedListUtility.createList("()");
		ListNode head2 = LinkedListUtility.createList("(1)");
		ListNode head3 = LinkedListUtility.createList("(2 -> 3)");
		ListNode head4 = LinkedListUtility.createList("(4 -> 5 -> 6)");

		System.out.println(LinkedListUtility.linkedListToString(head1));
		System.out.println(LinkedListUtility.linkedListToString(head2));
		System.out.println(LinkedListUtility.linkedListToString(head3));
		System.out.println(LinkedListUtility.linkedListToString(head4));
	}
}
