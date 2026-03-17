/*
LeetCode 1903 - Largest Odd Number in String
Approach: Iterate through the string from the end to find the last odd digit. If found, return the substring from the start to that index. If no odd digit is found, return an empty string.

Time Complexity: O(n) where n is the length of the input string.
Space Complexity: O(1) since we are only using a constant amount of extra space.
*/

class LC1903_LargestOddNumber {
    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            if ((num.charAt(i) - '0') % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }

    public static void main(String[] args) {
        LC1903_LargestOddNumber solution = new LC1903_LargestOddNumber();
        String num = "52";
        System.out.println(solution.largestOddNumber(num)); // Output: "5"
    }
}
