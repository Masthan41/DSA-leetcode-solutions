/*
LeetCode 3090 - Maximum length substring with atmost two occurences
Approach: Use a sliding window approach with a hash map to keep track of the frequency of characters in the current window. Expand the window by adding characters to the right and update their counts in the hash map. If any character's count exceeds 2, shrink the window from the left until all characters have counts of at most 2. Keep track of the maximum length of valid windows encountered during this process.
Time Complexity: O(n) where n is the length of the string
Space Complexity: O(26) ~ O(1) for the hash map since there are only 26 lowercase letters
*/

import java.util.*;

class LC3090_MaxLength {
    public int maximumLengthSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int len = 0;
        int left = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.get(ch) > 2) {
                char leftChar = s.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
            len = Math.max(len, i - left + 1);
        }
        return len;
    }

    public static void main(String[] a) {
        LC3090_MaxLength sol = new LC3090_MaxLength();
        String s = "abcabcabc";
        System.out.println(sol.maximumLengthSubstring(s)); // Expected: 6
    }
}
