/*
Leetcode 3110 - Score of a String
Appraoch : To calculate the score of a string, we can iterate through the string and compute the absolute difference between the ASCII values of adjacent characters. The score is the sum of these absolute differences.
Time Complexity: O(n) for iterating through the string.
Space Complexity: O(1) for storing the score.
*/

class LC3110_StringScore {
    public int scoreOfString(String s) {
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            ans += Math.abs((s.charAt(i) - 'a') - (s.charAt(i + 1) - 'a'));
        }
        return ans;
    }

    public static void main(String[] args) {
        LC3110_StringScore solution = new LC3110_StringScore();
        String s = "abc";
        int result = solution.scoreOfString(s);
        System.out.println("The score of the string \"" + s + "\" is: " + result);
    }
}