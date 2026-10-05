package com.avi.dsa2.tree;

/**
 * Blind 75 - Tree #4: Binary Tree Maximum Path Sum
 * ------------------------------------------------------------------
 * Problem:
 *   A path is any sequence of connected nodes (it need not pass through the
 *   root and cannot reuse a node). Return the maximum sum of node values along
 *   any such path.
 *
 * Example:
 *   [-10,9,20,null,null,15,7] -> 42  (path 15 -> 20 -> 7)
 *
 * Approach (post-order DFS with two quantities):
 *   For each node compute the best DOWNWARD gain it can contribute to its
 *   parent: node.val + max(0, leftGain, rightGain) - a parent can only extend
 *   through one child, and we clamp negative gains to 0 (skip that branch).
 *   Separately, the best path THROUGH this node (which may bend here using both
 *   children) is node.val + leftGain + rightGain; we track the global max of
 *   that across all nodes.
 *
 * Complexity:
 *   Time  O(n), Space O(h) recursion.
 */
public class BinaryTreeMaximumPathSum {

    private static int maxSum;

    public static int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gain(root);
        return maxSum;
    }

    private static int gain(TreeNode node) {
        if (node == null) return 0;
        int leftGain = Math.max(0, gain(node.left));   // ignore negative branches
        int rightGain = Math.max(0, gain(node.right));
        // path that bends at this node uses both children
        maxSum = Math.max(maxSum, node.val + leftGain + rightGain);
        // but what we return upward can use only one child
        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxPathSum(root)); // 42
    }
}
