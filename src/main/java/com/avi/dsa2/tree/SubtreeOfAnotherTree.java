package com.avi.dsa2.tree;

/**
 * Blind 75 - Tree #7: Subtree of Another Tree
 * ------------------------------------------------------------------
 * Problem:
 *   Given trees root and subRoot, return true if subRoot is a subtree of root
 *   (there is a node in root whose subtree is identical to subRoot).
 *
 * Example:
 *   root=[3,4,5,1,2], subRoot=[4,1,2] -> true
 *
 * Approach (traverse + sameTree check):
 *   Walk every node of root. At each node, test whether the subtree rooted
 *   there is IDENTICAL to subRoot using the Same Tree comparison. If any node
 *   matches, subRoot is a subtree. An empty subRoot is trivially a subtree.
 *
 * Complexity:
 *   Time  O(m * n) worst case (n nodes in root, each compared against m-node
 *   subRoot). Space O(h) recursion.
 */
public class SubtreeOfAnotherTree {

    public static boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) return true;
        if (root == null) return false;
        if (isSameTree(root, subRoot)) return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) return true;
        if (a == null || b == null || a.val != b.val) return false;
        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(4, new TreeNode(1), new TreeNode(2)),
                new TreeNode(5));
        TreeNode subRoot = new TreeNode(4, new TreeNode(1), new TreeNode(2));
        System.out.println(isSubtree(root, subRoot)); // true

        TreeNode notSub = new TreeNode(4, new TreeNode(1), new TreeNode(3));
        System.out.println(isSubtree(root, notSub)); // false
    }
}
