/*
Leetcode 3120 - Number of Special Characters in a String
Appraoch : Use a HashSet to store unique characters from the input string, then iterate through the lowercase letters and check if both the lowercase and uppercase versions of the letter are present in the set.
Time Complexity: O(n) for iterating through the string.
Space Complexity: O(n) for the HashSet, where n is the number of unique characters.
*/

import java.util.*;

class LC3120_SpecialChars {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> set = new HashSet<>();

        for (char ch : word.toCharArray()) {
            set.add(ch);
        }

        int count = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (set.contains(ch) && set.contains((char) (ch - 'a' + 'A'))) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC3120_SpecialChars solution = new LC3120_SpecialChars();
        String word = "aAbBcC";
        int result = solution.numberOfSpecialChars(word);
        System.out.println("Number of special characters: " + result);
    }
}