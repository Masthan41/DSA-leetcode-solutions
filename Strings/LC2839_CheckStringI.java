/*
LeetCode 2839 - Check if Strings Can be Made Equal I
Approach: Characters at even and odd indices form independent groups that can be freely permuted within their parity. We can count the frequency of characters at even and odd indices for both strings and compare them.

Time Complexity: O(1) since the length of the strings is fixed at 4, we are effectively doing a constant amount of work.
Space Complexity: O(1) since we are using fixed-size arrays of length 26 to count character frequencies, which does not grow with the input size.
*/

/*this problem is same as leetcode - 2840 
though a brute force approach exists for this as the length of string is upto 4 */

class LC2840_CheckStringI {
    public boolean canBeEqual(String s1, String s2) {

        // even index
        boolean condtion1 = (s1.charAt(0) == s2.charAt(0) && s1.charAt(2) == s2.charAt(2))
                || (s1.charAt(0) == s2.charAt(2) && s1.charAt(2) == s2.charAt(0));

        // odd index
        boolean condtion2 = (s1.charAt(1) == s2.charAt(1) && s1.charAt(3) == s2.charAt(3))
                || (s1.charAt(1) == s2.charAt(3) && s1.charAt(3) == s2.charAt(1));

        return condtion1 && condtion2;
    }

    public static void main(String[] args) {
        LC2840_CheckStringI obj = new LC2840_CheckStringI();
        String s1 = "abcd";
        String s2 = "cdab";
        boolean res = obj.canBeEqual(s1, s2);
        System.out.println(res);
    }
}