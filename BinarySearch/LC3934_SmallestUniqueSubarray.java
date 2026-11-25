/*
Leetcode 3934 - Smallest Unique Subarray
Appraoch : Binary Search / Rolling Hash / Hash Table

We can use binary search to find the smallest size of a subarray that contains at least one unique element. For each size, we can use a rolling hash technique to check if there exists a subarray of that size with a unique element. We maintain a hash of the current subarray and use a map to count the occurrences of each hash. If any hash occurs exactly once, it means there is a unique subarray of that size.

Time Complexity: O(n log n) for binary search and checking each size, where n is the length of the nums array.
Space Complexity: O(n) for storing the hash counts in the map.
*/
import java.util.*;

class LC3934_SmallestUniqueSubarray{
    private static final long MOD = 1_000_000_007L;

    // Binary exponentiation
    private long findPower(long a, long exp) {
        if (exp == 0) {
            return 1;
        }

        long half = findPower(a, exp / 2);
        long result = (half * half) % MOD;
        if (exp % 2 == 1) {
            result = (result * a) % MOD;
        }

        return result;
    }

    private boolean check(int[] nums, int size, long base) {
        int n = nums.length;

        long hash = 0;
        Map<Long, Integer> mp = new HashMap<>();

        long p = findPower(base % MOD, size - 1); // O(log(size))

        int i = 0;
        int j = 0;

        while (j < n) { // O(n)
            hash = (hash * base + nums[j]) % MOD;

            if (j - i + 1 < size) {
                j++;
            } else {
                mp.put(hash, mp.getOrDefault(hash, 0) + 1);

                hash = (hash - (p * nums[i]) % MOD + MOD) % MOD;

                i++;
                j++;
            }
        }

        for (int count : mp.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        long base = Arrays.stream(nums).max().getAsInt() + 1L;

        int l = 1;
        int r = n;

        int result = n;

        while (l <= r) { // O(log n)
            int mid = l + (r - l) / 2;

            if (check(nums, mid, base)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        LC3934_SmallestUniqueSubarray solution = new LC3934_SmallestUniqueSubarray();
        int[] nums = {1, 2, 3, 2, 1};
        int result = solution.smallestUniqueSubarray(nums);
        System.out.println("The smallest unique subarray has length: " + result);
    }
}