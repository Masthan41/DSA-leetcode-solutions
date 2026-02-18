/*
LeetCode 404 - Sum of Left Leaves
Approach: DFS Recursion
Time Complexity: O(n)
Space Complexity: O(h)
*/

public class LC404_SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null) {
            return 0;
        }
        int sum = 0;
        // check if left child is a leaf
        if (root.left != null &&
                root.left.left == null &&
                root.left.right == null) {

            sum += root.left.val;
        }

        // recurse on left and right subtree
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);

        return sum;
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
