package com.avi.dsa2.linkedlist;

/**
 * Blind 75 - Linked List #6: Reorder List
 * ------------------------------------------------------------------
 * Problem:
 *   Given L0 -> L1 -> ... -> Ln-1 -> Ln, reorder it in place to
 *   L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 -> ...  (interleave from both ends).
 *
 * Example:
 *   1 -> 2 -> 3 -> 4        ->  1 -> 4 -> 2 -> 3
 *   1 -> 2 -> 3 -> 4 -> 5   ->  1 -> 5 -> 2 -> 4 -> 3
 *
 * Approach (find middle, reverse second half, merge):
 *   Three classic sub-steps:
 *     1. Find the middle with slow/fast pointers.
 *     2. Reverse the second half of the list.
 *     3. Merge the first half and the reversed second half by alternating
 *        nodes. This produces the front-back interleaving without extra memory.
 *
 * Complexity:
 *   Time  O(n), Space O(1).
 */
public class ReorderList {

    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;

        // 1. find middle (slow ends at the start of the second half)
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 2. reverse the second half
        ListNode second = slow.next;
        slow.next = null;
        ListNode prev = null;
        while (second != null) {
            ListNode next = second.next;
            second.next = prev;
            prev = second;
            second = next;
        }

        // 3. merge the two halves alternately
        ListNode first = head;
        second = prev;
        while (second != null) {
            ListNode n1 = first.next, n2 = second.next;
            first.next = second;
            second.next = n1;
            first = n1;
            second = n2;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.of(1, 2, 3, 4, 5);
        reorderList(head);
        System.out.println(ListNode.toString(head)); // 1 -> 5 -> 2 -> 4 -> 3 -> null

        ListNode head2 = ListNode.of(1, 2, 3, 4);
        reorderList(head2);
        System.out.println(ListNode.toString(head2)); // 1 -> 4 -> 2 -> 3 -> null
    }
}
