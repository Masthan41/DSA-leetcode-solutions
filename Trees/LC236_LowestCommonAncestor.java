/*
LeetCode 236 - Lowest Common Ancestor of Binary Tree
Approach: Recursive LCA
Time Complexity: O(n)
Space Complexity: O(h)
*/

class LC236_LowestCommonAncestor {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }
    public static void main(String[] args) {
        LC236_LowestCommonAncestor solution = new LC236_LowestCommonAncestor();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode p = root.left; // Node with value 5
        TreeNode q = root.right; // Node with value 1

        TreeNode lca = solution.lowestCommonAncestor(root, p, q);
        System.out.println(lca.val); // Output: 3
    }
}
