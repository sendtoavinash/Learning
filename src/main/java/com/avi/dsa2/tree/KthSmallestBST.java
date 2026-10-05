package com.avi.dsa2.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Blind 75 - Tree #10: Kth Smallest Element in a BST
 * ------------------------------------------------------------------
 * Problem:
 *   Return the kth smallest value (1-indexed) in a binary search tree.
 *
 * Example:
 *   [3,1,4,null,2], k = 1 -> 1
 *   [5,3,6,2,4,null,null,1], k = 3 -> 3
 *
 * Approach (iterative in-order traversal):
 *   An in-order traversal of a BST visits values in ascending order. So we walk
 *   in-order with an explicit stack and stop as soon as we have popped k nodes;
 *   that kth popped value is the answer. Using a stack lets us stop early
 *   without traversing the whole tree.
 *
 * Complexity:
 *   Time  O(h + k), Space O(h).
 */
public class KthSmallestBST {

    public static int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()) {
            while (curr != null) {       // dive to the leftmost node
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();          // visit in ascending order
            if (--k == 0) return curr.val;
            curr = curr.right;           // then explore the right subtree
        }
        return -1; // k larger than number of nodes
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3, new TreeNode(2, new TreeNode(1), null), new TreeNode(4)),
                new TreeNode(6));
        System.out.println(kthSmallest(root, 3)); // 3
        System.out.println(kthSmallest(root, 1)); // 1
    }
}
