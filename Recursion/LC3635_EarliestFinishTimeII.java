/*
LeetCode 3635 - Earliest Possible Finish Time for land and water rides II
Approach: calculate the earliest finish time for both land and water rides and return the minimum of the two. We can use a helper function to calculate the finish time for one type of ride given the start times and durations of both types of rides.
Time Complexity: O(m + n) where m and n are the lengths of the land and water rides arrays.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/


class LC3635_EarliestFinishTimeII{
    private int finish(int start1[], int duration1[], int start2[], int duration2[]) {
        int finish1 = Integer.MAX_VALUE;

        for (int i = 0; i < start1.length; i++) {
            finish1 = Math.min(finish1, start1[i] + duration1[i]);
        }

        int finish2 = Integer.MAX_VALUE;
        for (int i = 0; i < start2.length; i++) {
            finish2 = Math.min(finish2, Math.max(finish1, start2[i]) + duration2[i]);
        }
        return finish2;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {

        int firstLand = finish(landStartTime, landDuration, waterStartTime, waterDuration);

        int firstWater = finish(waterStartTime, waterDuration, landStartTime, landDuration);

        return Math.min(firstLand, firstWater);
    }
    public static void main(String[] args) {
        LC3635_EarliestFinishTimeII obj = new LC3635_EarliestFinishTimeII();
        int[] landStartTime = { 1, 2, 3 };
        int[] landDuration = { 2, 2, 2 };
        int[] waterStartTime = { 2, 3, 4 };
        int[] waterDuration = { 2, 2, 2 };
        int res = obj.earliestFinishTime(landStartTime, landDuration, waterStartTime, waterDuration);
        System.out.println(res);
    }
}