package com.avi.dsa2.graph;

import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * Blind 75 - Graph #2: Course Schedule (cycle detection / topological sort)
 * ------------------------------------------------------------------
 * Problem:
 *   numCourses courses are labelled 0..n-1. prerequisites[i] = [a, b] means you
 *   must take b before a. Return true if you can finish all courses (i.e. the
 *   dependency graph has no cycle).
 *
 * Example:
 *   n=2, [[1,0]]        -> true
 *   n=2, [[1,0],[0,1]]  -> false (circular dependency)
 *
 * Approach (Kahn's topological sort / BFS on indegrees):
 *   Build a directed graph b -> a and count each node's indegree (number of
 *   prerequisites). Start a queue with all courses that have indegree 0 (no
 *   prerequisites). Repeatedly remove a course, "complete" it, and decrement
 *   the indegree of its dependents; any that reach 0 join the queue. If we
 *   manage to process all courses there was no cycle. Leftover courses mean a
 *   cycle exists.
 *
 * Complexity:
 *   Time  O(V + E), Space O(V + E).
 */
public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new ArrayList<>());
        int[] indegree = new int[numCourses];

        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // pre[1] -> pre[0]
            indegree[pre[0]]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) queue.offer(i);
        }

        int completed = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completed++;
            for (int next : graph.get(course)) {
                if (--indegree[next] == 0) queue.offer(next);
            }
        }
        return completed == numCourses;
    }

    public static void main(String[] args) {
        System.out.println(canFinish(2, new int[][]{{1, 0}}));           // true
        System.out.println(canFinish(2, new int[][]{{1, 0}, {0, 1}}));   // false
    }
}
