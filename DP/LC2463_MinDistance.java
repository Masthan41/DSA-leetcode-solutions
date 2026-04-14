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