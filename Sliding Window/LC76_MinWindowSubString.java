/*
Leetcode 76 - Minimum Window Substring
Appraoch : Use sliding window technique to find the minimum window in string s which will contain all the characters in string t. We maintain two arrays, need and window, to keep track of the frequency of characters needed and currently in the window. We expand the right pointer to include characters until we have a valid window, then we try to shrink the left pointer to find the minimum window.
Time Complexity: O(n) where n is the length of the input string s.
Space Complexity: O(1) for the need and window arrays, as they are of fixed size 128 (ASCII character set).
*/

class LC76_MinWindowSubString {
    public String minWindow(String s, String t) {
        int left = 0;
        int ans = Integer.MAX_VALUE;
        int need[] = new int[128];
        int window[] = new int[128];

        for (char ch : t.toCharArray()) {
            need[ch]++;
        }

        int matched = 0, start = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            window[ch]++;

            if (window[ch] <= need[ch]) {
                matched++;
            }

            while (matched == t.length()) {
                if (i - left + 1 < ans) {
                    ans = i - left + 1;
                    start = left;
                }
                char leftChar = s.charAt(left);

                window[leftChar]--;

                if (window[leftChar] < need[leftChar]) {
                    matched--;
                }
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? "" : s.substring(start, start + ans);
    }

    public static void main(String[] args) {
        LC76_MinWindowSubString solution = new LC76_MinWindowSubString();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println(solution.minWindow(s, t)); // Output: "BANC"
    }
}
