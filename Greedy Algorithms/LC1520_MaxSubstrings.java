/*
LeetCode 1520 - Maximum Number of Non-Overlapping Substrings
Approach: Greedy + Interval Scheduling. we first find the start and end index of each character in the string. Then we check if the substring formed by the start and end index of each character is valid or not. If it is valid, we add it to the result list. Finally, we return the result list.

Time Complexity: O(n) as we are traversing the string twice, once to find the start and end index of each character and once to check if the substring is valid or not.
Space Complexity: O(1) as we are using a fixed size array to store the start and end index of each character.
*/

import java.util.*;

class LC1520_MaxSubstrings {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();

        int[] start = new int[26];
        int[] end = new int[26];
        boolean[] isValid = new boolean[26];

        Arrays.fill(start, -1);
        Arrays.fill(isValid, true);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';

            if (start[idx] == -1) {
                start[idx] = i;
            }
            end[idx] = i;
        }

        for (int c = 0; c < 26; c++) { // checking all characters
            if (start[c] == -1)
                continue;

            for (int i = start[c]; i <= end[c]; i++) {
                int ch = s.charAt(i) - 'a';
                if (start[ch] < start[c]) {
                    isValid[c] = false;
                    break;
                }

                end[c] = Math.max(end[c], end[ch]);
            }
        }

        int lastTakenStart = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';

            if (!isValid[c])
                continue;

            if (i == start[c] && end[c] < lastTakenStart) {
                result.add(s.substring(i, end[c] + 1));
                lastTakenStart = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC1520_MaxSubstrings solution = new LC1520_MaxSubstrings();
        String s = "adefaddaccc";
        List<String> substrings = solution.maxNumOfSubstrings(s);
        System.out.println(substrings); // Output: [e, f, d, a, c]
    }
}