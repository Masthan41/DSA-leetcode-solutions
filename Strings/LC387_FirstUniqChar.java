/*
Leetcode 387: First Unique Character in a String
Approach: Frequency counting with two passes
Time Complexity: O(n)
Space Complexity: O(1) - since we are only storing frequency of 26 lowercase letters
*/

public class LC387_FirstUniqChar {
    public int firstUniqChar(String s) {

        int[] freq = new int[26];

        // Pass 1: count frequency
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        // Pass 2: find first unique character index
        for (int i = 0; i < s.length(); i++) {

            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        LC387_FirstUniqChar solution = new LC387_FirstUniqChar();
        System.out.println(solution.firstUniqChar("leetcode")); // Output: 0
        System.out.println(solution.firstUniqChar("loveleetcode")); // Output: 2
        System.out.println(solution.firstUniqChar("aabb")); // Output: -1
    }
}
