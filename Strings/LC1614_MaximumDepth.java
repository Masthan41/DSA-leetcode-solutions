/*
LeetCode 1614 - Maximum Nesting Depth of the Parentheses
Approach: Simple Iteration and checking for opening and closing parentheses

Time Complexity: O(n) where n is the length of the input string.
Space Complexity: O(1) since we are modifying the input String in place.
*/

class LC1614_MaximumDepth {
    public int maxDepth(String s) {
        int res = 0;
        int open = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (s.charAt(i) == ')') {
                open--;
            }
            res = Math.max(res, open);
        }
        return res;
    }

    public static void main(String[] args) {
        LC1614_MaximumDepth s = new LC1614_MaximumDepth();
        String str = "(1+(2*3)+((8)/4))+1";
        System.out.println(s.maxDepth(str)); // Output: 3

        String str2 = "(1)+((2))+((((3))))";
        System.out.println(s.maxDepth(str2)); // Output: 4
    }
}
