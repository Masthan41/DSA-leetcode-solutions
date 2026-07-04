/*
LeetCode 392 - Is Subsequence
Approach: Two Pointers on each string, incrementing the pointer of s when a match is found and always incrementing the pointer of t
Time Complexity: O(n) where n is the length of string t
Space Complexity: O(1) as we are using constant space for the pointers
*/

class LC392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        LC392_IsSubsequence obj = new LC392_IsSubsequence();
        String s = "abc";
        String t = "ahbgdc";
        boolean res = obj.isSubsequence(s, t);
        System.out.println(res);
    }
}
