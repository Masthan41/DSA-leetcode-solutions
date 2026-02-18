/*
LeetCode 94 - Binary Tree Inorder Traversal
Approach: Inorder traversal (Left → Root → Right)
Time Complexity: O(n)
Space Complexity: O(h) where h is the height of the tree
*/

import java.util.*;

class LC94_BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        inorder(root, result);

        return result;
    }

    private void inorder(TreeNode root, List<Integer> result) {

        if (root == null)
            return;

        inorder(root.left, result);

        result.add(root.val);

        inorder(root.right, result);
    }
    public static void main(String[] args){
        LC94_BinaryTreeInorderTraversal solution = new LC94_BinaryTreeInorderTraversal();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = solution.inorderTraversal(root);
        System.out.println(result); // Output: [1, 3, 2]
    }
}
