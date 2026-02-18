/*
LeetCode 104 - Maximum Depth of Binary Tree
Approach: Recursion (Height calculation)
Time Complexity: O(n)
Space Complexity: O(h)
*/

class LC104_MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ld = maxDepth(root.left);
        int rd = maxDepth(root.right);

        return Math.max(ld, rd) + 1;
    }

    public static void main(String[] args) {
        LC104_MaxDepthOfBinaryTree solution = new LC104_MaxDepthOfBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = solution.maxDepth(root);
        System.out.println(result); // Output: 3
    }
}
