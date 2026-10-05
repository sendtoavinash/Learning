package com.avi.dsa2.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * Blind 75 - Tree #8: Construct Binary Tree from Preorder and Inorder Traversal
 * ------------------------------------------------------------------
 * Problem:
 *   Given preorder and inorder traversals of a tree with unique values,
 *   reconstruct and return the tree.
 *
 * Example:
 *   preorder=[3,9,20,15,7], inorder=[9,3,15,20,7] -> the original tree
 *
 * Approach (recursion using the two orderings):
 *   In PREorder the first element is always the current subtree's root. Find
 *   that root inside INorder: everything to its left is the left subtree,
 *   everything to its right is the right subtree. The size of the left part
 *   tells us how to split preorder as well. We advance a shared preorder index
 *   and recurse, using a value -> inorder-index map for O(1) root lookup.
 *
 * Complexity:
 *   Time  O(n), Space O(n).
 */
public class ConstructTreeFromPreorderInorder {

    private static int preIndex;
    private static Map<Integer, Integer> inorderIndex;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex = 0;
        inorderIndex = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndex.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;
        int rootVal = preorder[preIndex++];      // next root in preorder
        TreeNode root = new TreeNode(rootVal);
        int mid = inorderIndex.get(rootVal);     // split point in inorder
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        System.out.println(root.val);            // 3
        System.out.println(root.left.val);       // 9
        System.out.println(root.right.val);      // 20
        System.out.println(root.right.left.val); // 15
    }
}
