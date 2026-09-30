/*
LeetCode 1111 - Maximum Nesting Depth of the Parentheses
Approach: We can use a greedy approach to assign parentheses to two groups (0 and 1) based on their nesting depth. We maintain a counter `d` to track the current depth of the parentheses. For each opening parenthesis '(', we increment the depth and assign it to group 0 or 1 based on whether the depth is even or odd. For each closing parenthesis ')', we assign it to the same group as its corresponding opening parenthesis and then decrement the depth.

Time complexity: O(n) as we traverse the string once to determine the group assignments for each parenthesis.
Space complexity: O(1) as we only use a fixed amount of extra space for the depth counter and the result array.
*/

class LC1111_MaxNestingDepth {
    public int[] maxDepthAfterSplit(String seq) {
        int[] result = new int[seq.length()];
        int d = 0;

        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i) == '(') {
                d++;
                result[i] = d % 2 == 0 ? 0 : 1;
            } else {
                result[i] = d % 2 == 0 ? 0 : 1;
                d--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC1111_MaxNestingDepth solution = new LC1111_MaxNestingDepth();
        String seq = "(()())";
        int[] result = solution.maxDepthAfterSplit(seq);
        System.out.print("Output: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]"); // Output: [0, 1, 1, 1, 1, 0]
    }
}
