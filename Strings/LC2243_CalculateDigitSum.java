/*
Leetcode 2243: Calculate Digit Sum of a String
Approach: Iteratively calculate the sum of digits in groups of size k until the length of the string is less than or equal to k
Time Complexity: O(n) - where n is the length of the string s
Space Complexity: O(n) - we are using a StringBuilder to store the intermediate results
*/

class LC2243_CalculateDigitSum {
    public String digitSum(String s, int k) {
        while (s.length() > k) {
            StringBuilder sb = new StringBuilder();
            int n = s.length();
            for (int i = 0; i < n; i += k) {
                int sum = 0;
                for (int j = i; j < Math.min(i + k, n); j++) {
                    sum += s.charAt(j) - '0';
                }
                sb.append(sum);
            }
            s = sb.toString();
        }
        return s;
    }

    public static void main(String[] args) {
        LC2243_CalculateDigitSum solution = new LC2243_CalculateDigitSum();
        String s = "11111222223";
        int k = 3;
        String result = solution.digitSum(s, k);
        System.out.println(result); // Output: "135"
    }
}