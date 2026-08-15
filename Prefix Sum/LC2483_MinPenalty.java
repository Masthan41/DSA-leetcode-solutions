/*
LeetCode 2483 - Minimum Penalty for a Shop
Approach: The approach to solve this problem is based on the observation that we can use prefix and suffix arrays to keep track of the number of customers who want to visit the shop before and after each hour. We calculate the penalty for each possible closing time and return the time with the minimum penalty.

Time Complexity: O(n) since we are iterating through the input string twice to calculate the prefix and suffix arrays.
Space Complexity: O(n) since we are using two arrays of size n to store the prefix and suffix values.
*/

class LC2483_MinPenalty {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int prefix[] = new int[n + 1];
        int suffix[] = new int[n + 1];

        prefix[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (customers.charAt(i - 1) == 'N') {
                prefix[i] = prefix[i - 1] + 1;
            } else {
                prefix[i] = prefix[i - 1];
            }
        }

        suffix[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (customers.charAt(i) == 'Y') {
                suffix[i] = suffix[i + 1] + 1;
            } else {
                suffix[i] = suffix[i + 1];
            }
        }
        int minPen = Integer.MAX_VALUE;
        int minHour = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++) {
            int curr = prefix[i] + suffix[i];

            if (curr < minPen) {
                minPen = curr;
                minHour = i;
            }
        }
        return minHour;
    }

    public static void main(String[] args) {
        LC2483_MinPenalty obj = new LC2483_MinPenalty();
        String customers = "YYNY";
        int result = obj.bestClosingTime(customers);
        System.out.println("Best closing time: " + result);
    }
}
