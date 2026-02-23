/*
LeetCode 69 - Sqrt(x)
Approach: Binary Search on answer space
Time Complexity: O(log n)
Space Complexity: O(1)
*/

//Although the problem can be solved using Newton's method, here we use binary search for clarity.

class LC69_SqrtX {
    public int mySqrt(int x) {

        if (x < 2)
            return x;

        int left = 1, right = x / 2;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Use division to avoid overflow
            if (mid <= x / mid) {
                ans = mid;
                left = mid + 1; // try larger value
            } else {
                right = mid - 1; // go smaller
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        LC69_SqrtX solution = new LC69_SqrtX();
        int x = 8;
        System.out.println(solution.mySqrt(x)); // Output: 2
    }
}
