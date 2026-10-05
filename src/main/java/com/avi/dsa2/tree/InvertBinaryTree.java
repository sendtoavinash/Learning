package com.avi.dsa2.tree;

/**
 * Blind 75 - Tree #3: Invert Binary Tree
 * ------------------------------------------------------------------
 * Problem:
 *   Invert (mirror) a binary tree: swap the left and right child of every node.
 *
 * Example:
 *   [4,2,7,1,3,6,9] -> [4,7,2,9,6,3,1]
 *
 * Approach (recursive swap):
 *   For each node, swap its two children, then recurse into both subtrees so
 *   the whole tree is mirrored. Base case: a null node needs nothing done.
 *
 * Complexity:
 *   Time  O(n), Space O(h) recursion.
 */
public class InvertBinaryTree {

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left; // swap children
        root.left = invertTree(root.right);
        root.right = invertTree(temp);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,
                new TreeNode(2, new TreeNode(1), new TreeNode(3)),
                new TreeNode(7, new TreeNode(6), new TreeNode(9)));
        TreeNode inverted = invertTree(root);
        // root's new left should be the old right (7)
        System.out.println(inverted.left.val);  // 7
        System.out.println(inverted.right.val);  // 2
    }
}
