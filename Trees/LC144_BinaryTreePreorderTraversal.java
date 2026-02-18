/*
LeetCode 144 - Binary Tree Preorder Traversal
Approach: Recursive traversal (Root → Left → Right)
Time Complexity: O(n)
Space Complexity: O(h)
*/

import java.util.*;

public class LC144_BinaryTreePreorderTraversal {

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
}
