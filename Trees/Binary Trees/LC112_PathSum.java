/*
LeetCode 112 - Path Sum
Approach: Use Depth-First Search (DFS) to traverse the binary tree. We maintain a running sum of the node values along the current path. When we reach a leaf node (a node with no children), we check if the running sum equals the target sum. If it does, we return true. If we finish traversing all paths without finding a valid path, we return false.

Time Complexity: O(n) as we visit each node exactly once, where n is the number of nodes in the binary tree.
Space Complexity: O(h) where h is the height of the binary tree, which is the maximum depth of the recursion stack. In the worst case, this can be equal to the number of nodes in a skewed tree.
*/

class LC112_PathSum {
    public boolean inOrder(TreeNode root, int sum, int target) {
        if (root == null) {
            return false;
        }

        sum += root.val;
        // leaf nodes
        if (root.left == null && root.right == null) {
            if (sum == target) {
                return true;
            }
            return false;
        }

        boolean left = inOrder(root.left, sum, target);
        boolean right = inOrder(root.right, sum, target);

        return left || right;
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        boolean res = inOrder(root, sum, targetSum);
        return res;
    }

    public static void main(String[] args) {
        LC112_PathSum solution = new LC112_PathSum();
        // Test cases
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(8);
        root1.left.left = new TreeNode(11);
        root1.left.left.left = new TreeNode(7);
        root1.left.left.right = new TreeNode(2);
        root1.right.left = new TreeNode(13);
        root1.right.right = new TreeNode(4);
        root1.right.right.right = new TreeNode(1);

        System.out.println(solution.hasPathSum(root1, 22)); // true
    }
}