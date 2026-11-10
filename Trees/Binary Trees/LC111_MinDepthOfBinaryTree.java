/*
LeetCode 111 - Minimum Depth of Binary Tree
Approach: Use Breadth-First Search (BFS) to traverse the binary tree level by level. We maintain a queue to keep track of the nodes at the current level. For each level, we increment the depth counter and add the child nodes of the current level's nodes to the queue for processing in the next iteration. The first time we encounter a leaf node (a node with no children), we return the current depth as the minimum depth of the binary tree.

Time Complexity: O(n) as we visit each node exactly once, where n is the number of nodes in the binary tree.
Space Complexity: O(w) where w is the maximum width of the binary tree, which is the maximum number of nodes that can be stored in the queue at any time (in the worst case, this can be equal to the maximum number of nodes at any level of the tree).
*/

//Althought it can be solved using DFS, BFS is more efficient in this case as it finds the minimum depth without traversing the entire tree.

import java.util.*;

class LC111_MinDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 1;

        while (!q.isEmpty()) {
            int n = q.size();

            while (n-- > 0) {
                TreeNode temp = q.remove();

                if (temp.left == null && temp.right == null) {
                    return depth;
                }

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            depth++;
        }
        return -1;
    }

    public static void main(String[] args) {
        LC111_MinDepthOfBinaryTree solution = new LC111_MinDepthOfBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = solution.minDepth(root);
        System.out.println(result); // Output: 2
    }
}
