/*
LeetCode 210 - Course Schedule II
Approach: Topological Sort using BFS (Kahn's Algorithm)
Time complexity: O(V + E) where V is the number of courses and E is the number of prerequisites
Space complexity: O(V + E) where V is the number of courses and E is the number of prerequisites
 */

import java.util.*;

class LC210_CourseScheduleII {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();
        int indeg[] = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int p[] : prerequisites) {
            int cr = p[0];
            int pre = p[1];

            graph.get(pre).add(cr);
            indeg[cr]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }

        int res[] = new int[numCourses];
        int idx = 0;

        //bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            res[idx++] = curr;

            for (int i : graph.get(curr)) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }
        }
        if (idx == numCourses) {
            return res;
        }

        return new int[0];
    }

    public static void main(String[] args) {
        LC210_CourseScheduleII solution = new LC210_CourseScheduleII();

        int numCourses = 4;
        int[][] prerequisites = {{1, 0}, {2, 0}, {3, 1}, {3, 2}};
        int[] result = solution.findOrder(numCourses, prerequisites);
        System.out.print("Course order: ");
        for (int course : result) {
            System.out.print(course + " "); // Output: Course order: 0 1 2 3
        }
    }
}
