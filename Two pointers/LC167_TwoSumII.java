/*
LeetCode 167 - Two Sum II (Input array is sorted)
Approach: Two Pointers
Time Complexity: O(n)
Space Complexity: O(1)
*/

class LC167_TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int lp = 0, rp = numbers.length - 1;

        while (lp < rp) {
            int sum = numbers[lp] + numbers[rp];

            if (sum == target) {
                return new int[]{lp + 1, rp + 1}; // 1-based index
            } else if (sum < target) {
                lp++;
            } else {
                rp--;
            }
        }
        return new int[]{};
    }
    public static void main(String[] args) {
        LC167_TwoSumII solution = new LC167_TwoSumII();
        int[] numbers = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(numbers, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]);
    }
}
