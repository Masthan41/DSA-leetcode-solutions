/*
LeetCode 242 - Valid Anagram

Approach: Count the frequency of each character in the first string and then decrement the count based on the characters in the second string. Finally, check if all counts are zero, which would indicate that the two strings are anagrams of each other.

Time Complexity: O(n) where n is the length of the strings, since we need to iterate through both strings once.

Space Complexity: O(1) since we are using a fixed-size array of length 26 to count the frequency of characters, which does not grow with the input size.
*/

import java.util.*;

class LC242_ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];

        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        for (char ch : t.toCharArray()) {
            count[ch - 'a']--;
        }

        // Check if all elements in the array are 0
        boolean allZeros = Arrays.stream(count).allMatch(element -> element == 0);

        return allZeros;
    }

    public static void main(String[] args) {
        LC242_ValidAnagram s = new LC242_ValidAnagram();
        String str1 = "anagram";
        String str2 = "nagaram";
        System.out.println(s.isAnagram(str1, str2)); // Output: true

        String str3 = "rat";
        String str4 = "car";
        System.out.println(s.isAnagram(str3, str4)); // Output: false
    }
}
