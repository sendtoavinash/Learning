package com.avi.dsa2.linkedlist;

/**
 * Blind 75 - Linked List #2: Linked List Cycle
 * ------------------------------------------------------------------
 * Problem:
 *   Determine whether a linked list has a cycle (some node's next points back
 *   to an earlier node).
 *
 * Example:
 *   3 -> 2 -> 0 -> -4, with -4 pointing back to 2 -> true
 *   1 -> 2 -> null -> false
 *
 * Approach (Floyd's tortoise and hare):
 *   Run two pointers: slow moves one step, fast moves two steps per iteration.
 *   If there is no cycle, fast reaches null and we return false. If there is a
 *   cycle, fast eventually laps around and meets slow (the gap between them
 *   shrinks by one each step inside the loop), so a meeting proves a cycle.
 *   This uses O(1) memory, unlike a visited-set approach.
 *
 * Complexity:
 *   Time  O(n), Space O(1).
 */
public class LinkedListCycle {

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;        // 1 step
            fast = fast.next.next;   // 2 steps
            if (slow == fast) return true; // they met -> cycle
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(3), b = new ListNode(2), c = new ListNode(0), d = new ListNode(-4);
        a.next = b; b.next = c; c.next = d; d.next = b; // cycle back to b
        System.out.println(hasCycle(a)); // true

        ListNode noCycle = ListNode.of(1, 2);
        System.out.println(hasCycle(noCycle)); // false
    }
}
