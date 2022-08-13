package com.hashnet.leetcode.problemsetall;

import java.util.HashMap;
import java.util.Map;

public class Copy_List_with_Random_Pointer {
    private class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;

        Map<Node, Node> map = new HashMap<>();
        int idx = 0;
        Node originalIterator = head;
        Node newHead = new Node(0);
        Node prevNode = newHead;
        while (originalIterator != null) {
            Node node = new Node(originalIterator.val);
            map.put(originalIterator, node);
            prevNode.next = node;

            prevNode = node;
            originalIterator = originalIterator.next;
        }
        newHead = newHead.next;

        originalIterator = head;
        Node currIterator = newHead;
        while (originalIterator != null) {
            currIterator.random = originalIterator.random == null ? null : map.get(originalIterator.random);

            originalIterator = originalIterator.next;
            currIterator = currIterator.next;
        }


        return newHead;
    }

    public static void main(String[] args) {

    }
}
