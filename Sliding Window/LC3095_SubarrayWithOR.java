/*
LeetCode 3095 - Shortest Subarray With OR atleast K items
Approach: Sliding Window with two pointers
Time Complexity: O(n) for iterating through the array once
Space Complexity: O(1) for variables (excluding input array)
*/

class LC3095_SubarrayWithOR {
    private void addBits(int num, int[] bits) {

        for (int b = 0; b < 32; b++) {

            if ((num & (1 << b)) != 0) {
                bits[b]++;
            }
        }
    }

    private void removeBits(int num, int[] bits) {

        for (int b = 0; b < 32; b++) {

            if ((num & (1 << b)) != 0) {
                bits[b]--;
            }
        }
    }

    private int getOR(int[] bits) {

        int or = 0;

        for (int b = 0; b < 32; b++) {

            if (bits[b] > 0) {
                or |= (1 << b);
            }
        }

        return or;
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bits = new int[32];

        int left = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < nums.length; right++) {

            addBits(nums[right], bits);

            while (left <= right && getOR(bits) >= k) {

                ans = Math.min(ans, right - left + 1);

                removeBits(nums[left], bits);

                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public static void main(String[] args) {
        LC3095_SubarrayWithOR ob = new LC3095_SubarrayWithOR();
        int nums[] = { 1, 2, 3, 4 };
        int k = 7;
        int ans = ob.minimumSubarrayLength(nums, k);
        System.out.println(ans);
    }
}
