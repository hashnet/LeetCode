package com.hashnet.leetcode.problemsetall;

import com.hashnet.leetcode.utility.LinkedListUtility;
import com.hashnet.leetcode.utility.ListNode;

public class Reverse_Nodes_in_k_Group {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root = new ListNode(0);
        root.next = head;
        ListNode prev = root;

        while (prev.next != null) {
            ListNode first = prev.next;
            ListNode last = first;

            boolean complete = true;
            for (int i = 1; i < k; i++) {
                last = last.next;
                if (last == null) {
                    complete = false;
                    break;
                }
            }
            if (!complete) break;
            ListNode next = last.next;

            ListNode tPrev = first;
            ListNode curr = first.next;
            for (int i = 1; i < k; i++) {
                ListNode tNext = curr.next;
                curr.next = tPrev;

                tPrev = curr;
                curr = tNext;
            }

            prev.next = last;
            first.next = next;

            prev = first;
        }

        return root.next;
    }

    public static void main(String[] args) {
        Reverse_Nodes_in_k_Group solution = new Reverse_Nodes_in_k_Group();

        ListNode node = LinkedListUtility.createList("1->2->3->4->5->6->7->8");
        System.out.println(LinkedListUtility.linkedListToString(solution.reverseKGroup(node, 3)));
    }
}
