/*
LeetCode 628 - Maximum Product of Three Numbers
Approach: Keep track of the three largest and two smallest numbers in the array.
Time Complexity: O(n) where n is the length of the array, since we need to iterate through the array to find the required numbers.
Space Complexity: O(1) since we are using a constant amount of space.
*/

class LC628_MaxProduct {
    public int maximumProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max3 = max2;
                max2 = num;
            } else if (num > max3) {
                max3 = num;
            }

            if (num < min1) {
                min2 = min1;
                min1 = num;
            } else if (num < min2) {
                min2 = num;
            }
        }
        return Math.max((max1 * max2 * max3), (max1 * min1 * min2));
    }

    public static void main(String[] a) {
        LC628_MaxProduct solution = new LC628_MaxProduct();
        int[] nums = { 1, 2, 3 };
        System.out.println(solution.maximumProduct(nums));
    }
}