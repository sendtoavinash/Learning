package com.avi.dsa2.linkedlist;

import java.util.PriorityQueue;

/**
 * Blind 75 - Linked List #4: Merge k Sorted Lists
 * ------------------------------------------------------------------
 * Problem:
 *   Merge k sorted linked lists into one sorted list.
 *
 * Example:
 *   [1->4->5, 1->3->4, 2->6] -> 1->1->2->3->4->4->5->6
 *
 * Approach (min-heap of list heads):
 *   Put the head node of each list into a min-heap keyed by value. Repeatedly
 *   pop the smallest node, append it to the result, and push that node's next
 *   (if any) back into the heap. The heap always holds at most k nodes - one
 *   "frontier" node per list - so each extraction is O(log k).
 *
 * Complexity:
 *   Time  O(N log k) where N is total nodes, Space O(k).
 */
public class MergeKSortedLists {

    public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) {
            if (node != null) heap.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (!heap.isEmpty()) {
            ListNode smallest = heap.poll();
            tail.next = smallest;
            tail = tail.next;
            if (smallest.next != null) heap.offer(smallest.next); // refill from same list
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = {
                ListNode.of(1, 4, 5),
                ListNode.of(1, 3, 4),
                ListNode.of(2, 6)
        };
        System.out.println(ListNode.toString(mergeKLists(lists)));
        // 1 -> 1 -> 2 -> 3 -> 4 -> 4 -> 5 -> 6 -> null
    }
}
