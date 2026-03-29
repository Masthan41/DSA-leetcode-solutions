/*
LeetCode 2840 - Check if Strings Can be Made Equal II
Approach: Characters at even and odd indices form independent groups that can be freely permuted within their parity. We can count the frequency of characters at even and odd indices for both strings and compare them.

Time Complexity: O(n) where n is the length of the strings, since we need to iterate through both strings once to count the frequencies.
Space Complexity: O(1) since we are using fixed-size arrays of length 26 to count character frequencies, which does not grow with the input size.
*/

class LC2840_CheckStringII{
    public boolean checkStrings(String s1, String s2) {
        int even[] = new int[26];
        int odd[] = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            if (i % 2 == 0) {
                even[s1.charAt(i) - 'a']++;
                even[s2.charAt(i) - 'a']--;
            } else {
                odd[s1.charAt(i) - 'a']++;
                odd[s2.charAt(i) - 'a']--;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (even[i] != 0 || odd[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args){
        LC2840_CheckStringII obj = new LC2840_CheckStringII();
        String s1 = "abcd";
        String s2 = "cdab";
        boolean res = obj.checkStrings(s1, s2);
        System.out.println(res);
    }
}