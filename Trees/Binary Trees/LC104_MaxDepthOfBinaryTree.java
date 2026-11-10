/*
LeetCode 104 - Maximum Depth of Binary Tree
Approach: Use Breadth-First Search (BFS) to traverse the binary tree level by level. We maintain a queue to keep track of the nodes at the current level. For each level, we increment the depth counter and add the child nodes of the current level's nodes to the queue for processing in the next iteration.

Time Complexity: O(n) as we visit each node exactly once, where n is the number of nodes in the binary tree.
Space Complexity: O(h) where h is the height of the binary tree, which is the maximum number of nodes that can be stored in the queue at any time (in the worst case, this can be equal to the height of the tree).
*/

import java.util.*;

class LC104_MaxDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int depth = 0;

        while (!q.isEmpty()) {
            int n = q.size();

            while (n-- > 0) {
                TreeNode temp = q.remove();

                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            depth++;
        }
        return depth;
    }

    public static void main(String[] args) {
        LC104_MaxDepthOfBinaryTree solution = new LC104_MaxDepthOfBinaryTree();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int result = solution.maxDepth(root);
        System.out.println(result); // Output: 3
    }
}
