/*
Leetcode 2463 - Minimum Total Distance Traveled
Appraoch : Minimize total distance traveled by the robots to reach the factory positions. We can use dynamic programming to solve this problem. We will sort the robot positions and factory positions to ensure that we are always trying to match the closest robot to the closest factory position. We will create a dp table where dp[i][j] represents the minimum total distance traveled by the first i robots to reach the first j factory positions. We will iterate through the dp table and fill it based on whether we take the current factory position for the current robot or skip it.

Time Complexity: O(n * m) where n is the number of robots and m is the total number of factory positions (after expansion).

Space Complexity: O(n * m) for the dp table. However, we can optimize it to O(m) by only keeping track of the current and previous rows instead of the entire table.
*/

import java.util.*;

class LC2463_MinDistance{
    public long solve(int ri, int fi, List<Integer> robot, List<Integer> position, long dp[][]) {
        if (ri >= robot.size()) {
            return 0;
        }
        if (fi >= position.size()) {
            return (long) 1e12; // Large value representing an infeasible solution
        }
        if (dp[ri][fi] != -1) {
            return dp[ri][fi];
        }

        long takeCurr = Math.abs(robot.get(ri) - position.get(fi)) + solve(ri + 1, fi + 1, robot, position, dp);
        long skipCurr = solve(ri, fi + 1, robot, position, dp);

        return dp[ri][fi] = Math.min(takeCurr, skipCurr);
    }

    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        //step 1 : Sorting
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        //step 2:Expand factory postions
        List<Integer> positions = new ArrayList<>();
        for (int f[] : factory) {
            int pos = f[0];
            int limit = f[1];
            for (int i = 0; i < limit; i++) {
                positions.add(pos);
            }
        }

        long dp[][] = new long[robot.size()][positions.size()];
        for (long row[] : dp) {
            Arrays.fill(row, -1);
        }

        //step 3: solve
        return solve(0, 0, robot, positions, dp);
    }
    public static void main(String[] args){
        LC2463_MinDistance sol = new LC2463_MinDistance();
        List<Integer> robot = Arrays.asList(1, 2, 3);
        int[][] factory = {{2, 1}, {3, 1}};
        System.out.println(sol.minimumTotalDistance(robot, factory));
    }
}