/*
LeetCode 2187 - Minimum Time to Complete Trips
Approach: Binary search on the answer. For each mid value, check if it's possible to complete at least totalTrips.
Time Complexity: O(n * log(max(time))) where n is the length of the time array and max(time) is the maximum value in the array.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/

class LC2187_MinTime {
    public long canReach(int time[], long givenTime) {
        long actualTrips = 0;
        for (int t : time) {
            actualTrips += givenTime / t;
        }
        return actualTrips;
    }

    public long minimumTime(int[] time, int totalTrips) {
        long low = 1, high = 0;
        int minTime = Integer.MAX_VALUE;
        for (int num : time) {
            minTime = Math.min(num, minTime);
        }
        high = 1L * minTime * totalTrips;
        long ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;

            if (canReach(time, mid) >= totalTrips) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC2187_MinTime obj = new LC2187_MinTime();
        int[] time = { 1, 2, 3 };
        int totalTrips = 5;
        long result = obj.minimumTime(time, totalTrips);
        System.out.println("Minimum Time: " + result);
    }
}
