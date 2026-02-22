/*
LeetCode 222 - Count Complete Tree Nodes
Approach: Recursion
Time Complexity: O(n)
Space Complexity: O(h)
*/

class LC222_CountCompleteTreeNodes {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lc = countNodes(root.left);
        int rc = countNodes(root.right);

        return lc + rc + 1;
    }

    public static void main(String[] args) {
        LC222_CountCompleteTreeNodes solution = new LC222_CountCompleteTreeNodes();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        int result = solution.countNodes(root);
        System.out.println(result); // Output: 6
    }
}
