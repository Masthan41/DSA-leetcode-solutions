/*
LeetCode 1482 - Minimum Number of Days to Make m Bouquets
Approach: Use binary search to find the minimum number of days required to make m bouquets. The search space is between 1 and the maximum number of days in the bloomDay array. For each mid value, check if it's possible to make m bouquets with each bouquet requiring k consecutive flowers that have bloomed by mid days.
Time Complexity: O(n log m), where n is the number of elements in bloomDay and m is the maximum number of days in the bloomDay array.
Space Complexity: O(1) - For storing variables and no additional data structures are used.
*/

class LC1482_MinDays {
    public int canMakeBouquets(int[] bloomDay, int mid, int k) {
        int bouqet_count = 0;
        int consecutive_count = 0;

        for (int i = 0; i < bloomDay.length; i++) {
            if (bloomDay[i] <= mid) {
                consecutive_count++;
            } else {
                consecutive_count = 0;
            }

            if (consecutive_count == k) {
                bouqet_count++;
                consecutive_count = 0;
            }
        }
        return bouqet_count;
    }

    public int minDays(int[] bloomDay, int m, int k) {
        int low = 1, high = 0;
        for (int num : bloomDay) {
            high = Math.max(high, num);
        }
        int minDays = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (canMakeBouquets(bloomDay, mid, k) >= m) {
                minDays = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return minDays;
    }

    public static void main(String[] args) {
        LC1482_MinDays solution = new LC1482_MinDays();
        int[] bloomDay = { 1, 10, 3, 10, 2 };
        int m = 3;
        int k = 1;
        int result = solution.minDays(bloomDay, m, k);
        System.out.println("The minimum number of days to make " + m + " bouquets is: " + result);
    }
}
