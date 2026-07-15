/*
LeetCode 1870 - Minimum Speed to Arrive on Time
Approach: We can use binary search to find the minimum speed. The search space is from 1 to a large value (10^7). For each mid value, we calculate the total time required to travel all distances and adjust our search space accordingly.
Time Complexity: O(n * log(max_speed)) where n is the length of the dist array and max_speed is the maximum possible speed.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/

class LC1870_MinSpeed {
    public double canReach(int dist[], double speed) {
        double time = 0.0;
        for (int i = 0; i < dist.length - 1; i++) {
            time += Math.ceil(dist[i] * 1.0 / speed);
        }
        time += (double) dist[dist.length - 1] / speed;

        return time;
    }

    public int minSpeedOnTime(int[] dist, double hour) {
        int low = 1, high = 10000000;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canReach(dist, mid) <= hour) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC1870_MinSpeed obj = new LC1870_MinSpeed();
        int[] dist = { 1, 3, 2 };
        double hour = 2.7;
        int result = obj.minSpeedOnTime(dist, hour);
        System.out.println("Minimum Speed: " + result);
    }
}
