package com.avi.dsa2.tree;

/**
 * Blind 75 - Tree #1: Maximum Depth of Binary Tree
 * ------------------------------------------------------------------
 * Problem:
 *   Return the maximum depth: the number of nodes along the longest path from
 *   the root down to a leaf.
 *
 * Example:
 *   [3,9,20,null,null,15,7] -> 3
 *
 * Approach (recursive DFS):
 *   The depth of a tree is 1 (for the root) plus the depth of its deeper
 *   subtree. An empty tree has depth 0. This recurrence naturally expresses
 *   itself as a post-order recursion.
 *
 * Complexity:
 *   Time  O(n), Space O(h) recursion stack where h is the tree height.
 */
public class MaximumDepthBinaryTree {

    public static int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(maxDepth(root)); // 3
    }
}
