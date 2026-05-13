/*
LeetCode 1423 - Maximum Points You Can Obtain from Cards
Approach: Use a sliding window technique to find the minimum sum of a subarray of size (n - k), then subtract it from the total sum.
Time complexity: O(n) where n is the length of the input array
Space complexity: O(1) for the in-place modification
*/

class LC1423_MaxPoints {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int totalSum = 0;

        for (int num : cardPoints) {
            totalSum += num;
        }

        // take all cards
        if (k == n)
            return totalSum;

        int win = n - k;

        int windowSum = 0;
        int minWindow = Integer.MAX_VALUE;

        int left = 0;

        for (int right = 0; right < n; right++) {

            windowSum += cardPoints[right];

            // maintain fixed window size
            if (right - left + 1 > win) {
                windowSum -= cardPoints[left];
                left++;
            }

            // valid window
            if (right - left + 1 == win) {
                minWindow = Math.min(minWindow, windowSum);
            }
        }

        return totalSum - minWindow;
    }

    public static void main(String[] args) {
        LC1423_MaxPoints obj = new LC1423_MaxPoints();
        int[] cardPoints = { 1, 2, 3, 4, 5, 6, 1 };
        int k = 3;
        System.out.println(obj.maxScore(cardPoints, k)); // Output: 12
    }
}
