/*
LeetCode 226 - Invert Binary Tree
Approach: Swap the left and right children of each node using a breadth-first search (BFS) approach.
Time Complexity: O(n) as we visit each node exactly once, where n is the number of nodes in the binary tree.
Space Complexity: O(w) where w is the maximum width of the tree
*/

//Although it can be solved using DFS, BFS is more efficient in this case as it finds the maximum depth without traversing the entire tree.

import java.util.*;

class LC226_InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return root;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) {
                q.add(node.left);
            }
            if (node.right != null) {
                q.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        LC226_InvertBinaryTree solution = new LC226_InvertBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        TreeNode invertedRoot = solution.invertTree(root);
        // You can add code here to print the inverted tree to verify the result
    }
}