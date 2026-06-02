/*
LeetCode 3633 - Earliest Possible Finish Time for land and water rides I
Approach: calculate the earliest finish time for both land and water rides and return the minimum of the two.
Time Complexity: O(m + n) where m and n are the lengths of the land and water rides arrays.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/

class LC3633_MinimizeRidesI {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int landToWater = calc(
                landStartTime, landDuration,
                waterStartTime, waterDuration);

        int waterToLand = calc(
                waterStartTime, waterDuration,
                landStartTime, landDuration);

        return Math.min(landToWater, waterToLand);
    }

    private int calc(int[] firstStart, int[] firstDuration,
            int[] secondStart, int[] secondDuration) {

        int minEnd = Integer.MAX_VALUE;

        for (int i = 0; i < firstStart.length; i++) {
            minEnd = Math.min(minEnd, firstStart[i] + firstDuration[i]);
        }

        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < secondStart.length; i++) {
            int finishTime = Math.max(minEnd, secondStart[i]) + secondDuration[i];
            ans = Math.min(ans, finishTime);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC3633_MinimizeRidesI obj = new LC3633_MinimizeRidesI();
        int[] landStartTime = { 1, 2, 3 };
        int[] landDuration = { 2, 2, 2 };
        int[] waterStartTime = { 2, 3, 4 };
        int[] waterDuration = { 2, 2, 2 };
        int res = obj.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        System.out.println(res);
    }
}
