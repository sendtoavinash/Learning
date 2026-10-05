package com.avi.dsa2.graph;

/**
 * Blind 75 - Graph #8: Number of Connected Components in an Undirected Graph
 * ------------------------------------------------------------------
 * Problem:
 *   Given n nodes (0..n-1) and a list of undirected edges, count how many
 *   connected components the graph has.
 *
 * Example:
 *   n=5, edges=[[0,1],[1,2],[3,4]] -> 2  ({0,1,2} and {3,4})
 *   n=5, edges=[[0,1],[1,2],[2,3],[3,4]] -> 1
 *
 * Approach (Union-Find):
 *   Start with n separate components (every node is its own set). Each edge
 *   that unites two nodes from DIFFERENT sets merges them, reducing the
 *   component count by one. Edges within an already-joined set change nothing.
 *   The remaining count after processing every edge is the answer.
 *
 * Complexity:
 *   Time  O((n + e) * alpha(n)) ~ near-linear, Space O(n).
 */
public class NumberOfConnectedComponents {

    public static int countComponents(int n, int[][] edges) {
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;
        for (int[] edge : edges) {
            int rootA = find(parent, edge[0]);
            int rootB = find(parent, edge[1]);
            if (rootA != rootB) {
                parent[rootA] = rootB; // merge two components
                components--;
            }
        }
        return components;
    }

    private static int find(int[] parent, int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]]; // path compression
            x = parent[x];
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));          // 2
        System.out.println(countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}));  // 1
    }
}
