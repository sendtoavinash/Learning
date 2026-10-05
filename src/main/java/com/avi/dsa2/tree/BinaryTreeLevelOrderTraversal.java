package com.avi.dsa2.tree;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Blind 75 - Tree #5: Binary Tree Level Order Traversal
 * ------------------------------------------------------------------
 * Problem:
 *   Return the node values grouped by level, from top to bottom and left to
 *   right within each level.
 *
 * Example:
 *   [3,9,20,null,null,15,7] -> [[3],[9,20],[15,7]]
 *
 * Approach (BFS with level-size batching):
 *   Standard breadth-first traversal using a queue. Before processing a level,
 *   record how many nodes are currently in the queue - that is exactly the size
 *   of this level. Dequeue precisely that many nodes into one list and enqueue
 *   their children for the next level.
 *
 * Complexity:
 *   Time  O(n), Space O(n) for the queue.
 */
public class BinaryTreeLevelOrderTraversal {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // nodes on the current level
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            result.add(level);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3,
                new TreeNode(9),
                new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        System.out.println(levelOrder(root)); // [[3], [9, 20], [15, 7]]
    }
}
