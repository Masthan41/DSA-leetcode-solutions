/*
Leetcode 438 - Find All Anagrams in a String
Appraoch : Use sliding window technique to find all starting indices of substrings in s that are anagrams of p.
Time Complexity: O(n) where n is the length of the input string s.
Space Complexity: O(1) as the frequency arrays are of fixed size.
*/

import java.util.*;

class LC438_AllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int arr[] = new int[26];
        int window[] = new int[26];
        int left = 0;
        int k = p.length();

        if (s.length() < p.length()) {
            return list;
        }
        for (int i = 0; i < k; i++) {
            arr[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            window[s.charAt(i) - 'a']++;
            if (i - left + 1 > k) {
                window[s.charAt(left) - 'a']--;
                left++;
            }
            if (i - left + 1 == k) {
                if (Arrays.equals(window, arr)) {
                    list.add(left);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LC438_AllAnagrams solution = new LC438_AllAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = solution.findAnagrams(s, p);
        System.out.println("Starting indices of anagrams: " + result); // Output: Starting indices of anagrams
    }
}