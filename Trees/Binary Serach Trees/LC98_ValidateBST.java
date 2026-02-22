/*
LeetCode 98 - Validate Binary Search Tree
Approach: Inorder traversal to check if the values are in strictly increasing order
Time Complexity: O(n)
Space Complexity: O(h) where h is the height of the tree
*/

class LC98_ValidateBST {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (prev != null && root.val <= prev.val) {
            return false;
        }
        prev = root;

        return isValidBST(root.right);
    }

    public static void main(String[] args) {
        LC98_ValidateBST obj = new LC98_ValidateBST();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        System.out.println(obj.isValidBST(root)); // true
    }
}
