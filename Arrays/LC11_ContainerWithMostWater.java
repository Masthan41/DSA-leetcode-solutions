/* LeetCode 11 - Container With Most Water
Approach: Two Pointers
Time Complexity: O(n)
Space Complexity: O(1)
*/

public class LC11_ContainerWithMostWater {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxArea = 0;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            int width = r - l;
            int area = h * width;

            maxArea = Math.max(maxArea, area);

            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        LC11_ContainerWithMostWater obj = new LC11_ContainerWithMostWater();
        int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        System.out.println(obj.maxArea(height)); // 49
}
