/*
LeetCode 1763 - Longest Nice Substring
Approach: Divide and Conquer with recursion
Time Complexity: O(n^2) in the worst case due to substring creation and recursive calls
Space Complexity: O(n) for the recursion stack in the worst case
*/

import java.util.HashSet;

class LC1763_NiceSubstring {
    public String longestNiceSubstring(String s) {
        if (s.length() <= 1) {
            return "";
        }

        HashSet<Character> set = new HashSet<>();

        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (set.contains(Character.toUpperCase(ch)) && set.contains(Character.toLowerCase(ch))) {
                continue;
            }
            String left = longestNiceSubstring(s.substring(0, i));
            String right = longestNiceSubstring(s.substring(i + 1));

            return left.length() >= right.length() ? left : right;
        }
        return s;
    }

    public static void main(String[] args) {
        LC1763_NiceSubstring ob = new LC1763_NiceSubstring();
        String s = "YazaAay";
        String ans = ob.longestNiceSubstring(s);
        System.out.println(ans); // Output: "aAa"
    }
}
