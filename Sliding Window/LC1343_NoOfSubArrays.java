/*
LeetCode 1343 - Number of Sub-arrays of Size K and Average Greater Than or Equal to Threshold
Approach: Sliding Window with two pointers and average calculation for each window
Time Complexity: O(n) for iterating through the array once
Space Complexity: O(1) for variables (excluding input array)
*/


class LC1343_NoOfSubArrays {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0, windows = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        if (sum / k >= threshold)
            windows++;

        // slide the window
        for (int i = k; i < arr.length; i++) {
            sum += arr[i] - arr[i - k];
            if (sum / k >= threshold)
                windows++;
        }
        return windows;
    }

    public static void main(String[] args) {
        LC1343_NoOfSubArrays solution = new LC1343_NoOfSubArrays();
        int[] arr = { 2, 2, 2, 2, 5, 5, 5, 8 };
        int k = 3;
        int threshold = 4;
        int result = solution.numOfSubarrays(arr, k, threshold);
        System.out.println(result); // Output: 3
    }
}
