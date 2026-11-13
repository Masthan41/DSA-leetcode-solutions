/*
LeetCode 257 - Binary Tree Paths
Approach: Use a recursive depth-first search (DFS) approach to traverse the binary tree. For each node, we maintain the current path as a string. When we reach a leaf node, we add the complete path to the result list. The recursion continues until all paths from the root to the leaves are explored.
Time Complexity: O(n) as we visit each node once, where n is the number of nodes in the binary tree
Space Complexity: O(h) as the maximum depth of the recursion stack, where h is the height of the binary tree
*/

import java.util.*;

class LC257_BinaryTreePaths {
    public void allPaths(TreeNode root, String path, List<String> list) {
        if (root.left == null && root.right == null) {
            list.add(path);
            return;
        }

        if (root.left != null) {
            allPaths(root.left, path + "->" + root.left.val, list);
        }
        if (root.right != null) {
            allPaths(root.right, path + "->" + root.right.val, list);
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        String path = String.valueOf(root.val);

        allPaths(root, path, list);
        return list;
    }

    public static void main(String[] args) {
        LC257_BinaryTreePaths solution = new LC257_BinaryTreePaths();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> paths = solution.binaryTreePaths(root);
        System.out.println(paths); // Output: [1->2->5, 1->3]
    }
}
