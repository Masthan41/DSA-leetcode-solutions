/*
LeetCode 921 - Minimum Add to Make Parentheses Valid
Approach: Greedy counting of unmatched brackets
Time complexity: O(n)
Space complexity: O(1)
*/

class LC921_MinAddToMakeValid {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int add = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else {
                if (open > 0) {
                    open--;
                } else {
                    add++;
                }
            }
        }
        return add + open;
    }
    public static void main(String[] args) {
        LC921_MinAddToMakeValid solution = new LC921_MinAddToMakeValid();
        String s = "())";
        System.out.println(solution.minAddToMakeValid(s)); // Output: 1
    }
}
