/*
LeetCode 179 - Greatest Common Divisor of Array
Approach: Find the minimum and maximum elements in the array and compute their GCD
Time complexity: O(n) as we are traversing the array once to find the minimum and maximum elements.
Space complexity: O(1) as we are using only a constant amount of space.
*/

class LC1979_GreatestDivisor {
    public int GCD(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public int findGCD(int[] nums) {
        int left = Integer.MAX_VALUE, right = 0;
        for (int num : nums) {
            left = Math.min(left, num);
            right = Math.max(right, num);
        }
        return GCD(left, right);
    }

    public static void main(String[] args) {
        LC1979_GreatestDivisor obj = new LC1979_GreatestDivisor();
        int[] nums = { 2, 5, 6, 9, 10 };
        System.out.println(obj.findGCD(nums)); // Output: 2
    }
}
