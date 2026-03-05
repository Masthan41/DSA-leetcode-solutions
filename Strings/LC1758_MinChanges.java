/*
LeetCode 1758 - Minimum Changes to Make Alternating Binary String
Approach: Count the number of operations needed to make the string alternate starting with '0' and '1', then return the minimum.
Time Complexity: O(n)
Space Complexity: O(1)
*/

class LC1758_MinChanges {
    public int minOperations(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') != (i % 2)) {
                c++;
            }
        }
        return Math.min(c, s.length() - c);
    }

    public static void main(String[] args) {
        LC1758_MinChanges obj = new LC1758_MinChanges();
        String s1 = "0100";
        String s2 = "10000";

        System.out.println(obj.minOperations(s1));
        System.out.println(obj.minOperations(s2));
    }
}
