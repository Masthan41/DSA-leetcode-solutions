/*
LeetCode 3498 - Reverse Degree of a string
Approach: The reverse degree of a string is calculated by iterating through each character in the string, multiplying its position (1-based index) by the difference between 123 and the ASCII value of the character, and summing these values to get the final result.
Time Complexity: O(n) where n is the length of the string, as we iterate through each character once.
Space Complexity: O(1) as we are using a constant amount of space for the variables.
*/

class LC3498_ReverseDegree {
    public int reverseDegree(String s) {
        int n = s.length();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += (i + 1) * (123 - s.charAt(i));
        }
        return sum;
    }

    public static void main(String[] a) {
        LC3498_ReverseDegree solution = new LC3498_ReverseDegree();
        String s = "abc";
        int result = solution.reverseDegree(s);
        System.out.println(result); // Output: 294
    }
}
