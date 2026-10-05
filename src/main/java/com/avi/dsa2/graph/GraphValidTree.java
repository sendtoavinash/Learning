package com.avi.dsa2.graph;

/**
 * Blind 75 - Graph #7: Graph Valid Tree
 * ------------------------------------------------------------------
 * Problem:
 *   Given n nodes (0..n-1) and a list of undirected edges, determine whether
 *   they form a valid tree. A valid tree is fully connected and has no cycles.
 *
 * Example:
 *   n=5, edges=[[0,1],[0,2],[0,3],[1,4]]       -> true
 *   n=5, edges=[[0,1],[1,2],[2,3],[1,3],[1,4]] -> false (contains a cycle)
 *
 * Approach (Union-Find):
 *   A tree with n nodes has exactly n-1 edges, so first reject anything else.
 *   Then use Union-Find: process each edge and union its two endpoints. If the
 *   two endpoints are ALREADY in the same set, adding this edge creates a cycle
 *   -> not a tree. If we survive all edges with no such conflict and the edge
 *   count was n-1, the graph is connected and acyclic: a valid tree.
 *
 * Complexity:
 *   Time  O(n * alpha(n)) ~ O(n), Space O(n).
 */
public class GraphValidTree {

    public static boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false; // trees have exactly n-1 edges

        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        for (int[] edge : edges) {
            int rootA = find(parent, edge[0]);
            int rootB = find(parent, edge[1]);
            if (rootA == rootB) return false;     // cycle detected
            parent[rootA] = rootB;                // union
        }
        return true;
    }

    private static int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // path compression
            x = parent[x];
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));          // true
        System.out.println(validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));  // false
    }
}
