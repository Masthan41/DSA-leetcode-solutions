/*
LeetCode 761 - Special Binary String
Approach: Recursion + Greedy + Sorting special substrings
Time Complexity: O(n log n)
Space Complexity: O(n)
*/

import java.util.*;

class LC761_SpecialBinaryString {

    public String makeLargestSpecial(String s) {
        List<String> l = new ArrayList<>();

        int c = 0, st = 0;
        // Split the string into special substrings
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                c++;
            } else {
                c--;
            }
            if (c == 0) {
                String inner = s.substring(st + 1, i);

                String pr = makeLargestSpecial(inner);
                l.add("1" + pr + "0");

                st = i + 1;
            }
        }
        Collections.sort(l, Collections.reverseOrder());

        //join
        StringBuilder res = new StringBuilder();

        for (String str : l) {
            res.append(str);
        }
        return res.toString();
    }
    public static void main(String[] args) {
        LC761_SpecialBinaryString solution = new LC761_SpecialBinaryString();
        String s = "11011000";
        System.out.println(solution.makeLargestSpecial(s)); // Output: "11100100"
    }
}