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
        int l = 0, maxL = 0;
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxL = Math.max(maxL, r - l + 1);
        }
        return maxL;
    }
}
