package com.avi.dsa2.tree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Blind 75 - Tree #6: Serialize and Deserialize Binary Tree
 * ------------------------------------------------------------------
 * Problem:
 *   Design algorithms to serialize a binary tree to a string and deserialize
 *   that string back into the identical tree.
 *
 * Example:
 *   [1,2,3,null,null,4,5] -> "1,2,3,#,#,4,5" -> identical tree
 *
 * Approach (pre-order DFS with null markers):
 *   Serialize with a pre-order walk (root, left, right), writing '#' for null
 *   children. The null markers are what make the reconstruction unambiguous.
 *   Deserialize by reading tokens in the SAME pre-order sequence: build the
 *   root, then recursively build its left subtree, then its right subtree,
 *   consuming tokens from a queue.
 *
 * Complexity:
 *   Time  O(n), Space O(n).
 */
public class SerializeDeserializeBinaryTree {

    public static String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private static void buildString(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(',');
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    public static TreeNode deserialize(String data) {
        Queue<String> tokens = new LinkedList<>(Arrays.asList(data.split(",")));
        return buildTree(tokens);
    }

    private static TreeNode buildTree(Queue<String> tokens) {
        String token = tokens.poll();
        if ("#".equals(token)) return null;
        TreeNode node = new TreeNode(Integer.parseInt(token));
        node.left = buildTree(tokens);   // pre-order: left before right
        node.right = buildTree(tokens);
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(2),
                new TreeNode(3, new TreeNode(4), new TreeNode(5)));
        String data = serialize(root);
        System.out.println(data); // 1,2,#,#,3,4,#,#,5,#,#,
        TreeNode restored = deserialize(data);
        System.out.println(serialize(restored).equals(data)); // true (round-trips)
    }
}
