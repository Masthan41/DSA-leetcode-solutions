/*
Leetcode 424 - Longest Repeating Character Replacement
Appraoch : Use sliding window technique to find the length of the longest substring with at most k different characters.
Time Complexity: O(n) where n is the length of the input string s.
Space Complexity: O(1) for the frequency array.
*/

class LC424_LongestChar {
    public int characterReplacement(String s, int k) {
        int freq[] = new int[26];
        int left = 0;
        int maxFreq = 0;
        int ans = 0;

        for (int right = 0; right < s.length(); right++) {
            int ch = s.charAt(right) - 'A';
            freq[ch]++;

            // update maxFreq
            maxFreq = Math.max(maxFreq, freq[ch]);

            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            // update answer
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC424_LongestChar solution = new LC424_LongestChar();
        String s = "AABABBA";
        int k = 1;
        int result = solution.characterReplacement(s, k);
        System.out.println("Length of the longest substring: " + result);
    }
}
