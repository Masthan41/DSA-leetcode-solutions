/*
LeetCode 144 - Binary Tree Preorder Traversal
Approach: Recursive traversal (Root → Left → Right)
Time Complexity: O(n)
Space Complexity: O(h)
*/

import java.util.*;

class LC144_BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();

        preorder(root, result);

        return result;
    }

    private void preorder(TreeNode root, List<Integer> result) {

        if (root == null)
            return;

        result.add(root.val);

        preorder(root.left, result);

        preorder(root.right, result);
    }
    public static void main(String[] args) {
        LC144_BinaryTreePreorderTraversal solution = new LC144_BinaryTreePreorderTraversal();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = solution.preorderTraversal(root);
        System.out.println(result); // Output: [1, 2, 3]
    }
}
