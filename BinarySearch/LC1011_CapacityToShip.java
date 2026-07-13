/*
LeetCode 1011 - Capacity To Ship Packages Within D Days
Approach: Use binary search to find the minimum capacity. The search space is between the maximum weight of a single package and the sum of all package weights. For each mid value, check if it's possible to ship all packages within the given number of days using a helper function.
Time Complexity: O(n log m), where n is the number of packages and m is the difference between the maximum and minimum capacities.
Space Complexity: O(1) - For storing variables and no additional data structures are used.
*/

class LC1011_CapacityToShip {
    public int findDays(int weights[], int capacity) {
        int load = 0, days = 1;
        for (int i : weights) {
            if (i + load > capacity) {
                days++;
                load = i;
            } else {
                load += i;
            }
        }
        return days;
    }

    public int shipWithinDays(int[] weights, int days) {
        int left = 0, right = 0;
        for (int i : weights) {
            left = Math.max(i, left);
            right += i;
        }

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (findDays(weights, mid) <= days) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        LC1011_CapacityToShip obj = new LC1011_CapacityToShip();
        int weights[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int days = 5;
        System.out.println(obj.shipWithinDays(weights, days));
    }
}
