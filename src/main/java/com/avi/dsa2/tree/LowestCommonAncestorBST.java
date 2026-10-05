package com.avi.dsa2.tree;

/**
 * Blind 75 - Tree #11: Lowest Common Ancestor of a BST
 * ------------------------------------------------------------------
 * Problem:
 *   Given a BST and two nodes p and q, return their lowest common ancestor
 *   (the deepest node that has both as descendants; a node can be its own
 *   descendant).
 *
 * Example:
 *   root=[6,2,8,0,4,7,9], p=2, q=8 -> 6
 *   root=[6,2,8,0,4,7,9], p=2, q=4 -> 2
 *
 * Approach (exploit BST ordering):
 *   Starting at the root, use the BST property:
 *     - If both p and q are greater than the current node, the LCA is in the
 *       right subtree.
 *     - If both are smaller, it is in the left subtree.
 *     - Otherwise the values split (one on each side, or one equals the node),
 *       so the current node is the lowest common ancestor.
 *
 * Complexity:
 *   Time  O(h), Space O(1).
 */
public class LowestCommonAncestorBST {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode node = root;
        while (node != null) {
            if (p.val > node.val && q.val > node.val) {
                node = node.right;      // both on the right
            } else if (p.val < node.val && q.val < node.val) {
                node = node.left;       // both on the left
            } else {
                return node;            // split point = LCA
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode n2 = new TreeNode(2, new TreeNode(0), new TreeNode(4));
        TreeNode n8 = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        TreeNode root = new TreeNode(6, n2, n8);
        System.out.println(lowestCommonAncestor(root, n2, n8).val); // 6
        System.out.println(lowestCommonAncestor(root, n2, n2.right).val); // 2
    }
}
