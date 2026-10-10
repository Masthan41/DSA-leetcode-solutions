/*
LeetCode 2333 - Minimum Sum of Squared Differences
Approach: Use a diffrence array for performing counting sort. Count the number of occurrences of each difference and then iterate from the maximum difference down to 1, reducing the differences by using the available operations (k1 + k2). Finally, calculate the sum of squared differences based on the updated counts.

Time complexity: O(n + maxDiff) where n is the length of the input arrays and maxDiff is the maximum difference between corresponding elements in nums1 and nums2.
Space complexity: O(maxDiff) since we are using an array of size maxDiff + 1 to store the counts.
*/


class LC2333_SumOfDiffrences {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int diff[] = new int[n];
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = (Math.abs(nums1[i] - nums2[i]));
            maxDiff = Math.max(diff[i], maxDiff);
        }

        // counting sort
        int count[] = new int[maxDiff + 1];
        for (int d : diff) {
            count[d]++;
        }

        long K = (long) k1 + k2;

        for (int i = maxDiff; i > 0 && K > 0; i--) {
            int ops = (int) Math.min(count[i], K);

            count[i] -= ops;
            count[i - 1] += ops;
            K -= ops;
        }

        long sum = 0;
        for (int i = 1; i <= maxDiff; i++) {
            sum += (long) count[(int) i] * i * i;
        }
        return sum;
    }

    public static void main(String[] args) {
        LC2333_SumOfDiffrences solution = new LC2333_SumOfDiffrences();
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 2, 3, 4 };
        int k1 = 1;
        int k2 = 1;
        long result = solution.minSumSquareDiff(nums1, nums2, k1, k2);
        System.out.println("Minimum sum of squared differences: " + result);
    }
}
