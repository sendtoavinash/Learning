package com.avi.dsa2.linkedlist;

/**
 * Blind 75 - Linked List #5: Remove Nth Node From End of List
 * ------------------------------------------------------------------
 * Problem:
 *   Remove the nth node from the end of the list and return the head.
 *
 * Example:
 *   1 -> 2 -> 3 -> 4 -> 5, n = 2  ->  1 -> 2 -> 3 -> 5
 *
 * Approach (two pointers with a gap of n):
 *   Advance a fast pointer n nodes ahead first. Then move fast and slow
 *   together until fast reaches the end. Now slow sits exactly one node BEFORE
 *   the target, so we unlink it with slow.next = slow.next.next. A dummy head
 *   gracefully handles removing the first node (n == length).
 *
 * Complexity:
 *   Time  O(length) one pass, Space O(1).
 */
public class RemoveNthNodeFromEnd {

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;

        for (int i = 0; i < n; i++) {   // open a gap of n nodes
            fast = fast.next;
        }
        while (fast.next != null) {     // move both until fast hits the last node
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;     // skip the target node
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println(ListNode.toString(removeNthFromEnd(ListNode.of(1, 2, 3, 4, 5), 2)));
        // 1 -> 2 -> 3 -> 5 -> null
        System.out.println(ListNode.toString(removeNthFromEnd(ListNode.of(1), 1)));
        // null
    }
}
