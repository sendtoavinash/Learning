package com.avi.dsa2.linkedlist;

/**
 * Blind 75 - Linked List #3: Merge Two Sorted Lists
 * ------------------------------------------------------------------
 * Problem:
 *   Merge two sorted linked lists into one sorted list and return its head.
 *
 * Example:
 *   1 -> 2 -> 4  and  1 -> 3 -> 4  ->  1 -> 1 -> 2 -> 3 -> 4 -> 4
 *
 * Approach (dummy head + splice):
 *   Use a dummy node so we never special-case the head. Walk both lists with a
 *   tail pointer, always appending the smaller current node and advancing that
 *   list. When one list runs out, attach the remainder of the other (already
 *   sorted) directly. Splicing existing nodes means no new allocations.
 *
 * Complexity:
 *   Time  O(m + n), Space O(1).
 */
public class MergeTwoSortedLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = (l1 != null) ? l1 : l2; // attach the leftover tail
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = ListNode.of(1, 2, 4);
        ListNode l2 = ListNode.of(1, 3, 4);
        System.out.println(ListNode.toString(mergeTwoLists(l1, l2)));
        // 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> null
    }
}
