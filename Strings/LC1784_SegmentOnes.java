/*
LeetCode 1784 - Check if Binary String Has at Most One Segment of Ones
Approach: Iterate through the string and check if there is a '1' after a '0'.
Time Complexity: O(n)
Space Complexity: O(1)
*/

class LC1784_SegmentOnes {
    public boolean checkOnesSegment(String s) {
        boolean zero = false;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                zero = true;
            }
            if (s.charAt(i) == '1' && zero) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC1784_SegmentOnes solution = new LC1784_SegmentOnes();
        String s1 = "1001";
        String s2 = "110";
        System.out.println(solution.checkOnesSegment(s1)); // Output: false
        System.out.println(solution.checkOnesSegment(s2)); // Output: true
    }
}