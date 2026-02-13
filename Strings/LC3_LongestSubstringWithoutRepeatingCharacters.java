/*
LeetCode 3 - Longest Substring Without Repeating Characters
Approach: Sliding Window with HashSet
Time Complexity: O(n)
Space Complexity: O(min(n, charset))
*/

import java.util.HashSet;

class LC3_LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {

        HashSet<Character> set = new HashSet<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LC3_LongestSubstringWithoutRepeatingCharacters obj =
                new LC3_LongestSubstringWithoutRepeatingCharacters();

        String s = "abcabcbb";
        System.out.println(obj.lengthOfLongestSubstring(s)); // Output: 3
    }
}
