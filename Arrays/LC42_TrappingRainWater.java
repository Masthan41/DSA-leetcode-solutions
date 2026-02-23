/*
LeetCode 42 - Trapping Rain Water
Approach: Prefix Max & Suffix Max (DP)
Time Complexity: O(n)
Space Complexity: O(n)
*/

class LC42_TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        if (n < 3) return 0;

        int[] leftMax = new int[n];
        int[] rightMax = new int[n];

        // left max boundary
        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        // right max boundary
        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }

        // calculate trapped water
        int trappedWater = 0;
        for (int i = 0; i < n; i++) {
            int waterLevel = Math.min(leftMax[i], rightMax[i]);
            trappedWater += (waterLevel - height[i]);
        }

        return trappedWater;
    }
    public static void main(String[] args) {
        LC42_TrappingRainWater obj = new LC42_TrappingRainWater();
        int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        System.out.println(obj.trap(height)); // 6
    }
}
