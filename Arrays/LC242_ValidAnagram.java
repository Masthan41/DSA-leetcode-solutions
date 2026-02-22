/*
LeetCode 242 - Valid Anagram
Pattern: Frequency Counting (Array Hashing)
Approach: Count characters of both strings and compare
Time Complexity: O(n)
Space Complexity: O(1)
*/

import java.util.Arrays;

class LC242_ValidAnagram {
    public static boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        char arr1[] = s1.toCharArray();
        char arr2[] = s2.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";
        System.out.println(isAnagram(s1, s2)); // true
}
