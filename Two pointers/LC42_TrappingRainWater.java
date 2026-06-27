/*
LeetCode 42 - Trapping Rain Water
Approach: Two pointers tracking left and right maximum heights and calculating trapped water based on the minimum of the two maximums
Time Complexity: O(n) as we traverse the height array once
Space Complexity: O(1) as we are using constant space for variables and not using any additional data structures
*/

class LC42_TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int ans = 0;
        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;

        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);

            if (leftMax < rightMax) {
                ans += leftMax - height[left];
                left++;
            } else {
                ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC42_TrappingRainWater obj = new LC42_TrappingRainWater();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(obj.trap(height)); // 6
    }
}
