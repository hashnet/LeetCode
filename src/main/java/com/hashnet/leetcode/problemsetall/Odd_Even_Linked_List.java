package com.hashnet.leetcode.problemsetall;

public class Odd_Even_Linked_List {
    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        Odd_Even_Linked_List s = new Odd_Even_Linked_List();
        int[] nums = {1, 2, 3, 4};

        ListNode next = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            ListNode node = new ListNode(nums[i]);
            node.next = next;

            next = node;
        }

        s.printNode(next);

        s.printNode(s.oddEvenList(next));
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;

        ListNode oddIter = head;
        ListNode even = head.next;
        ListNode evenIter = even;

        while (oddIter.next != null && oddIter.next.next != null) {
            oddIter.next = oddIter.next.next;
            oddIter = oddIter.next;

            evenIter.next = oddIter.next;
            evenIter = evenIter.next;
        }

        oddIter.next = even;

        return head;
    }

    private void printNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }
}