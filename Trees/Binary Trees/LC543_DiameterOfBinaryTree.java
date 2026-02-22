/*
LeetCode 543 - Diameter of Binary Tree
Approach: Postorder traversal
Time Complexity: O(n)
Space Complexity: O(h)
*/

class LC543_DiameterOfBinaryTree {
    int diameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return diameter;
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);

        diameter = Math.max(diameter, lh + rh);
        return Math.max(lh, rh) + 1;
    }

    public static void main(String[] args) {
        LC543_DiameterOfBinaryTree solution = new LC543_DiameterOfBinaryTree();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int result = solution.diameterOfBinaryTree(root);
        System.out.println(result); // Output: 3
    }
}
