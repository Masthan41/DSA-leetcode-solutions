/*
LeetCode 3 - Longest Substring Without Repeating Characters
Approach: Sliding Window with HashSet
Time Complexity: O(n)
Space Complexity: O(min(n, charset))
*/

import java.util.*;

class LC3_LongestSubstring {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();
        int length = 0, maxlength = 0;

        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(length));
                length++;
            }
            set.add(s.charAt(i));
            maxlength = Math.max(maxlength, i - length + 1);
        }
        return maxlength;
    }

    public static void main(String[] args) {
        LC3_LongestSubstring solution = new LC3_LongestSubstring();
        String s = "abcabcbb";
        int result = solution.lengthOfLongestSubstring(s);
        System.out.println(result); // Output: 3
    }
}
