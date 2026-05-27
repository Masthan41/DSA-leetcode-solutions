/*
Leetcode 3121 - Number of Special Characters in a String II
Appraoch : Use two arrays to track the last occurrence of lowercase letters and the first occurrence of uppercase letters. Iterate through the string to populate these arrays, then count how many characters have a valid lowercase and uppercase occurrence where the lowercase occurs before the uppercase.
Time Complexity: O(n) for iterating through the string.
Space Complexity: O(1) for the two arrays, as they have a fixed size of 26.
*/

import java.util.*;

class LC3121_SpecialCharsII {
    public int numberOfSpecialChars(String word) {
        int lower[] = new int[26];
        int upper[] = new int[26];

        Arrays.fill(lower, -1);
        Arrays.fill(upper, -1);

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                lower[ch - 'a'] = i; // last lowercase occurrence
            } else {
                if (upper[ch - 'A'] == -1) {
                    upper[ch - 'A'] = i; // first uppercase occurrence
                }
            }
        }

        int count = 0;

        for (int i = 0; i < 26; i++) {
            if (lower[i] != -1 &&
                    upper[i] != -1 &&
                    lower[i] < upper[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC3121_SpecialCharsII solution = new LC3121_SpecialCharsII();
        String word = "aAbBcC";
        int result = solution.numberOfSpecialChars(word);
        System.out.println("Number of special characters: " + result);
    }
}
