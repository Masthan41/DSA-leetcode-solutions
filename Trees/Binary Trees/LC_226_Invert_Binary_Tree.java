/*
LeetCode 226 - Invert Binary Tree
Approach: Swap using recusrive approach
Time Complexity: O(n)
Space Complexity: O(h) where h is the height of the tree
*/

class LC_226_Invert_Binary_Tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode leftMirror = invertTree(root.left);
        TreeNode rightMirror = invertTree(root.right);

        root.left = rightMirror;
        root.right = leftMirror;

        return root;
    }

    public static void main(String[] args) {
        LC_226_Invert_Binary_Tree solution = new LC_226_Invert_Binary_Tree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode invertedRoot = solution.invertTree(root);
        // You can add code here to print the inverted tree to verify the result
    }
}