/*
LeetCode 207 - Course Schedule I
Approach: Topological Sort using BFS (Kahn's Algorithm)
Time complexity: O(V + E) where V is the number of courses and E is the number of prerequisites
Space complexity: O(V + E) where V is the number of courses and E is the number of prerequisites
*/

import java.util.*;

class LC207_CourseScheduleI {

    public boolean canFinish(int n, int[][] prereq) {

        ArrayList<Integer> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        int indeg[] = new int[n];

        //build graph
        for (int p[] : prereq) {
            int a = p[0];
            int b = p[1];

            graph[b].add(a);
            indeg[a]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indeg[i] == 0) {
                q.add(i);
            }
        }
        int c = 0;
        //bfs
        while (!q.isEmpty()) {
            int curr = q.remove();
            c++;

            for (int i : graph[curr]) {
                indeg[i]--;
                if (indeg[i] == 0) {
                    q.add(i);
                }
            }
        }
        return n == c;
    }

    public static void main(String[] args) {
        LC207_CourseScheduleI solution = new LC207_CourseScheduleI();

        int numCourses = 2;
        int[][] prerequisites = {{1, 0}};
        boolean result = solution.canFinish(numCourses, prerequisites);
        System.out.println(result);
    }
}
