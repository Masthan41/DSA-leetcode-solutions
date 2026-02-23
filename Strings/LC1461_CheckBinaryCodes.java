/*
LeetCode 1461 - Check If a String Contains All Binary Codes of Size K
Approach: Use a sliding window to generate all substrings of size k and store them in a HashSet.
Time Complexity: O(n*k)
Space Complexity: O(2^k * k)
*/
import java.util.*;

class LC1461_CheckBinaryCodes {
    public boolean hasAllCodes(String s, int k) {
        int total = 1 << k;
        if (s.length() - k + 1 < total) {
            return false;
        }
        HashSet<Integer> seen = new HashSet<>();
        int mask = total - 1, wind = 0;
        for (int i = 0; i < s.length(); i++) {
            wind = ((wind << 1) & mask) | (s.charAt(i) - '0');

            if (i >= k - 1) {
                seen.add(wind);

                if (seen.size() == total) {
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        LC1461_CheckBinaryCodes obj = new LC1461_CheckBinaryCodes();
        String s = "00110110";
        int k = 2;
        System.out.println(obj.hasAllCodes(s, k)); // Output: true
    }
}
