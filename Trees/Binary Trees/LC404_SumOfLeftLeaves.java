/*
LeetCode 404 - Sum of Left Leaves
Approach: DFS Recursion
Time Complexity: O(n)
Space Complexity: O(h)
*/

class LC404_SumOfLeftLeaves {
    public int findSum(TreeNode curr, TreeNode parent) {

        if (curr == null) {
            return 0;
        }

        if (curr.left == null && curr.right == null) {
            if (parent != null && parent.left == curr) {
                return curr.val;
            }
        }
        int left = findSum(curr.left, curr);
        int right = findSum(curr.right, curr);

        return left + right;
    }

    public int sumOfLeftLeaves(TreeNode root) {
        return findSum(root, null);
    }

    public static void main(String[] args) {
        LC404_SumOfLeftLeaves solution = new LC404_SumOfLeftLeaves();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = solution.sumOfLeftLeaves(root);
        System.out.println(result); // Output: 24
    }
}
