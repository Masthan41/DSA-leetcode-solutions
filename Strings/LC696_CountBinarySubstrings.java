/*
LeetCode 696 - Count Binary Substrings
Approach: Group counting
Time Complexity: O(n)
Space Complexity: O(1)
*/

class LC696_CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int prevCount = 0, curr = 1;
        int res = 0;

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;
            } else {
                res += Math.min(prevCount, curr);
                prevCount = curr;
                curr = 1;
            }
        }
        res += Math.min(prevCount, curr);
        return res;
    }

    public static void main(String[] args) {
        LC696_CountBinarySubstrings obj = new LC696_CountBinarySubstrings();
        System.out.println(obj.countBinarySubstrings("00110011")); // 6
        System.out.println(obj.countBinarySubstrings("10101")); // 4
    }
}
