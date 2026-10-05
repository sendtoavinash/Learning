package com.avi.dsa2.tree;

/**
 * Blind 75 - Tree #2: Same Tree
 * ------------------------------------------------------------------
 * Problem:
 *   Given two binary trees, check whether they are structurally identical and
 *   hold the same values at every node.
 *
 * Example:
 *   [1,2,3] vs [1,2,3] -> true
 *   [1,2]   vs [1,null,2] -> false
 *
 * Approach (parallel recursion):
 *   Compare the two trees node by node simultaneously. Both must be null (match)
 *   or both non-null with equal values AND matching left subtrees AND matching
 *   right subtrees. If one is null while the other is not, or the values
 *   differ, they are not the same.
 *
 * Complexity:
 *   Time  O(n), Space O(h) recursion.
 */
public class SameTree {

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null || p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode b = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(isSameTree(a, b)); // true

        TreeNode c = new TreeNode(1, new TreeNode(2), null);
        TreeNode d = new TreeNode(1, null, new TreeNode(2));
        System.out.println(isSameTree(c, d)); // false
    }
}
