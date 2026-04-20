/*
LeetCode 2078 - Furthest Houses
Approach: To find the furthest houses with different colors, we can iterate through the array and keep track of the maximum distance between houses of different colors.

Time Complexity: O(n) where n is the length of the colors array.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/

class LC2078_FurthestHouses {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int result = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[0]) {
                result = Math.max(result, i);
            }
            if (colors[i] != colors[n - 1]) {
                result = Math.max(result, (n - 1) - i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC2078_FurthestHouses obj = new LC2078_FurthestHouses();
        int[] colors = { 1, 1, 1, 6, 1, 1, 1 };
        System.out.println("Maximum Distance: " + obj.maxDistance(colors));
    }
}
