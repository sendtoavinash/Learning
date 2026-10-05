package com.avi.dsa2.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Blind 75 - Graph #1: Clone Graph
 * ------------------------------------------------------------------
 * Problem:
 *   Given a reference to a node in a connected undirected graph, return a deep
 *   copy (clone) of the entire graph. Each node holds a value and a list of
 *   neighbours.
 *
 * Example:
 *   adjacency [[2,4],[1,3],[2,4],[1,3]] -> an identical but independent graph.
 *
 * Approach (DFS + visited map):
 *   The challenge is cycles: naively following neighbours would loop forever.
 *   We keep a map from original node -> its clone. When we visit a node:
 *     - If it is already cloned, return the existing clone (handles cycles and
 *       shared neighbours).
 *     - Otherwise create its clone, record it in the map BEFORE recursing, then
 *       clone each neighbour and attach.
 *
 * Complexity:
 *   Time  O(V + E), Space O(V).
 */
public class CloneGraph {

    static class Node {
        int val;
        List<Node> neighbors;
        Node(int val) {
            this.val = val;
            this.neighbors = new ArrayList<>();
        }
    }

    public static Node cloneGraph(Node node) {
        return dfs(node, new HashMap<>());
    }

    private static Node dfs(Node node, Map<Node, Node> cloned) {
        if (node == null) return null;
        if (cloned.containsKey(node)) return cloned.get(node); // already copied

        Node copy = new Node(node.val);
        cloned.put(node, copy); // record before recursing to break cycles
        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(dfs(neighbor, cloned));
        }
        return copy;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1), n2 = new Node(2), n3 = new Node(3), n4 = new Node(4);
        n1.neighbors.add(n2); n1.neighbors.add(n4);
        n2.neighbors.add(n1); n2.neighbors.add(n3);
        n3.neighbors.add(n2); n3.neighbors.add(n4);
        n4.neighbors.add(n1); n4.neighbors.add(n3);

        Node clone = cloneGraph(n1);
        System.out.println("Clone root val: " + clone.val);                  // 1
        System.out.println("Is deep copy (different object): " + (clone != n1)); // true
        System.out.println("Neighbor count: " + clone.neighbors.size());     // 2
    }
}
