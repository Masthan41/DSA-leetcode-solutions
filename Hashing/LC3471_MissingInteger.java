/*
LeetCode 3471 - Largest Almost missing Integer
Approach: Use a sliding window approach to iterate through all subarrays of length k. For each subarray, use a HashSet to track the unique integers present. Maintain a HashMap to count the occurrences of each integer across all subarrays. After processing all subarrays, iterate through the HashMap to find the largest integer that appears in exactly one subarray of length k.
Time Complexity: O(n * k) where n is the length of the array and k is the size of the subarray
Space Complexity: O(n) for the HashMap and HashSet used to track occurrences and unique integers
*/

class LC3471_MissingInteger {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = -1;

        for (int i = 0; i <= nums.length - k; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
            }
            for (int num : set) {
                map.put(num, map.getOrDefault(num, 0) + 1);

            }
        }
        for (int num : map.keySet()) {
            if (map.get(num) == 1) {
                res = Math.max(res, num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC3471_MissingInteger solution = new LC3471_MissingInteger();
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 3;
        int result = solution.largestInteger(nums, k);
        System.out
                .println("The largest integer that appears in exactly one subarray of length " + k + " is: " + result);
    }
}