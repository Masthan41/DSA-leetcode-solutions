/*
LeetCode 101 - Symmetric Tree
Approach: Use a queue to perform a breadth-first traversal of the tree, comparing nodes in pairs to check for symmetry. For each pair of nodes, we check if they are both null (in which case we continue), if one is null and the other is not (in which case we return false), or if their values are different (in which case we also return false). If they are equal, we enqueue their children in the order that maintains symmetry: left child of the left node with right child of the right node, and right child of the left node with left child of the right node.

Time Complexity: O(n) as we visit each node once, where n is the number of nodes in the tree.
Space Complexity: O(h) as we store nodes in the queue, where h is the height of the tree.
*/

import java.util.*;

class LC101_SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);

        while (!q.isEmpty()) {
            TreeNode l = q.remove();
            TreeNode r = q.remove();

            if (l == null && r == null) {
                continue;
            }
            if ((l == null || r == null) || (l.val != r.val)) {
                return false;
            }

            q.add(l.left);
            q.add(r.right);

            q.add(l.right);
            q.add(r.left);
        }
        return true;
    }

    public static void main(String[] args) {
        LC101_SymmetricTree solution = new LC101_SymmetricTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(solution.isSymmetric(root)); // Output: true
    }
}
