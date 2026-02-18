/*
LeetCode 572 - Subtree of Another Tree
Approach: DFS Recursion
Time Complexity: O(n × m)
Space Complexity: O(h)
*/

public class LC572_SubtreeOfAnotherTree {
    public boolean isIdentical(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }
        if (!isIdentical(root.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(root.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null) {
            return false;
        }
        if (root.val == subRoot.val) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public static void main(String[] args) {
        LC572_SubtreeOfAnotherTree solution = new LC572_SubtreeOfAnotherTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        TreeNode subRoot = new TreeNode(4);
        subRoot.left = new TreeNode(1);
        subRoot.right = new TreeNode(2);

        boolean result = solution.isSubtree(root, subRoot);
        System.out.println(result); // Output: true
    }
}
