/*
LeetCode 110 - Balanced Binary Tree
Approach: Postorder traversal
Time Complexity: O(n)
Space Complexity: O(h)
*/

class LC110_BalancedBinaryTree {
    public int height(TreeNode root) {
        if (root == null)
            return 0;

        int lh = height(root.left);
        if (lh == -1)
            return -1;

        int rh = height(root.right);
        if (rh == -1)
            return -1;

        if (Math.abs(lh - rh) > 1)
            return -1;

        return Math.max(lh, rh) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public static void main(String[] args) {
        LC110_BalancedBinaryTree solution = new LC110_BalancedBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        boolean result = solution.isBalanced(root);
        System.out.println(result); // Output: true
    }
}
