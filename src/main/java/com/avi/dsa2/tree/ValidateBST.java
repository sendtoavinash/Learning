package com.avi.dsa2.tree;

/**
 * Blind 75 - Tree #9: Validate Binary Search Tree
 * ------------------------------------------------------------------
 * Problem:
 *   Determine whether a binary tree is a valid BST: every node's value is
 *   greater than all values in its left subtree and less than all values in its
 *   right subtree.
 *
 * Example:
 *   [2,1,3]       -> true
 *   [5,1,4,null,null,3,6] -> false (4 is in the right subtree of 5 but < 5)
 *
 * Approach (recursion with (low, high) bounds):
 *   A naive "node.left < node < node.right" check is NOT enough - the whole
 *   left subtree must be below the node, not just the immediate child. So we
 *   pass an allowed open interval (low, high) down the tree. Going left tightens
 *   the upper bound to the current value; going right tightens the lower bound.
 *   A node violating its bounds makes the tree invalid.
 *
 * Complexity:
 *   Time  O(n), Space O(h) recursion.
 */
public class ValidateBST {

    public static boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private static boolean validate(TreeNode node, Integer low, Integer high) {
        if (node == null) return true;
        if (low != null && node.val <= low) return false;
        if (high != null && node.val >= high) return false;
        return validate(node.left, low, node.val)       // left: new upper bound
                && validate(node.right, node.val, high); // right: new lower bound
    }

    public static void main(String[] args) {
        TreeNode valid = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        System.out.println(isValidBST(valid)); // true

        TreeNode invalid = new TreeNode(5,
                new TreeNode(1),
                new TreeNode(4, new TreeNode(3), new TreeNode(6)));
        System.out.println(isValidBST(invalid)); // false
    }
}
