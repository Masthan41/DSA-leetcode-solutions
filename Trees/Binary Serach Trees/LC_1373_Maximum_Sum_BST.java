/*
LeetCode 1373 - Maximum Sum BST in Binary Tree
Approach: Post-order traversal + Info class to track min, max, sum, and isBST status
Time Complexity: O(n)
Space Complexity: O(h) where h is the height of the tree
*/
class LC_1373_Maximum_Sum_BST {
    class Info {
        int min, max, sum;
        boolean isBST;

        Info(int min, int max, int sum, boolean isBST) {
            this.min = min;
            this.max = max;
            this.sum = sum;
            this.isBST = isBST;
        }
    }

    int maxSum = 0;

    public int maxSumBST(TreeNode root) {
        helper(root);
        return maxSum;
    }

    private Info helper(TreeNode root) {
        if (root == null)
            return new Info(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);

        Info left = helper(root.left);
        Info right = helper(root.right);

        if (left.isBST && right.isBST && root.val > left.max && root.val < right.min) {
            int curr = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, curr);

            int min = Math.min(root.val, left.min);
            int max = Math.max(root.val, right.max);

            return new Info(min, max, curr, true);
        }
        return new Info(0, 0, 0, false);
    }
    public static void main(String[] args) {
        LC_1373_Maximum_Sum_BST solution = new LC_1373_Maximum_Sum_BST();

        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        int result = solution.maxSumBST(root);
        System.out.println("Maximum Sum BST in the Binary Tree: " + result);
    }
}
