package com.avi.dsa2.linkedlist;

/**
 * Blind 75 - Linked List #1: Reverse Linked List
 * ------------------------------------------------------------------
 * Problem:
 *   Reverse a singly linked list and return the new head.
 *
 * Example:
 *   1 -> 2 -> 3 -> 4 -> 5 -> null  becomes  5 -> 4 -> 3 -> 2 -> 1 -> null
 *
 * Approach (iterative pointer reversal):
 *   Walk the list once keeping three pointers: prev (already reversed part),
 *   curr (node being processed), and a saved next. For each node we point its
 *   next backward to prev, then slide the window forward. When curr falls off
 *   the end, prev is the new head.
 *
 * Complexity:
 *   Time  O(n), Space O(1).
 */
public class ReverseLinkedList {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next; // save the rest of the list
            curr.next = prev;          // reverse this link
            prev = curr;               // advance prev
            curr = next;               // advance curr
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        System.out.println(ListNode.toString(reverseList(head))); // 5 -> 4 -> 3 -> 2 -> 1 -> null
    }
}
