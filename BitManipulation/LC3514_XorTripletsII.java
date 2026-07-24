/*
LeetCode 3514 - Unique XOR Triplets II
Approach: The approach to solve this problem is based on the observation that we can use two boolean arrays to keep track of the unique XOR values. The first boolean array, s1, is used to store the XOR values of all pairs of elements in the input array. The second boolean array, s2, is used to store the XOR values of the elements in s1 with each element in the input array. Finally, we count the number of true values in s2 to get the number of unique XOR triplets.

Time Complexity: O(n^2) since we are iterating through all pairs of elements in the input array to calculate the XOR values and then iterating through the boolean arrays to count the unique values.
Space Complexity: O(T) where T is the smallest power of 2 greater than or equal to the maximum element in the input array, since we are using two boolean arrays of size T to store the XOR values.
*/

class LC3514_XorTripletsII {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int maxEle = 0;
        for (int num : nums) {
            maxEle = Math.max(num, maxEle);
        }

        int T = 1;
        while (T <= maxEle) {
            T <<= 1;
        }

        boolean s1[] = new boolean[T];
        boolean s2[] = new boolean[T];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                s1[nums[i] ^ nums[j]] = true;
            }
        }

        for (int i = 0; i < T; i++) {
            if (s1[i] == true) {
                for (int num : nums) {
                    s2[i ^ num] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < T; i++) {
            if (s2[i] == true) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] a) {
        LC3514_XorTripletsII s = new LC3514_XorTripletsII();
        int[] nums = { 1, 2, 3 };
        System.out.println(s.uniqueXorTriplets(nums));
    }
}
