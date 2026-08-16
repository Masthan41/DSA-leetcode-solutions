/*
LeetCode 1422 - Maximum Score After Splitting a String
Approach: Use a one-pass approach to calculate the maximum score by maintaining counts of zeros and ones.
Time Complexity: O(n) as we traverse the array once
Space Complexity: O(1) as we dont use any extra space
*/

class LC1422_MaxScore {
    public int maxScore(String s) {
        int n = s.length();
        int maxScore = Integer.MIN_VALUE;

        // one pass approach
        int ones = 0, zeroes = 0;
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            } else {
                zeroes++;
            }
            maxScore = Math.max(zeroes - ones, maxScore);
        }
        if (s.charAt(n - 1) == '1') {
            ones++;
        }
        return maxScore + ones;
    }

    public static void main(String[] a) {
        LC1422_MaxScore obj = new LC1422_MaxScore();
        System.out.println(obj.maxScore("011101"));
    }
}
