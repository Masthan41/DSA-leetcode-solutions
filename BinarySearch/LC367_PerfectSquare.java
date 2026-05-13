/*
LeetCode 367 - Valid Perfect Square
Approach: Use binary search to find if there exists an integer whose square equals the input number
Time complexity: O(log n) where n is the input number
Space complexity: O(1) for the in-place modification
*/

class LC367_PerfectSquare {
    public boolean isPerfectSquare(int num) {
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            long square = (long) mid * mid;

            if (square == num) {
                return true;
            } else if (square < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC367_PerfectSquare solution = new LC367_PerfectSquare();
        int num = 16;
        boolean result = solution.isPerfectSquare(num);
        System.out.println(num + " is a perfect square: " + result);
    }
}
