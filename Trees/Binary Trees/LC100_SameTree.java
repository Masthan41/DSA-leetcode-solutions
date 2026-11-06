/*
LeetCode 100 - Same Tree
Approach: Use a breadth-first search (BFS) approach to traverse both trees simultaneously. Use two queues to store the nodes of each tree. At each step, compare the values of the nodes and enqueue their children for further comparison.
Time Complexity: O(n) as we need to visit each node in both trees once, where n is the number of nodes in the trees.
Space Complexity: O(w) where w is the maximum width of the trees, which is the maximum number of nodes at any level in the trees. This is due to the space used by the queues to store nodes at each level.
*/

//Though i can also use recursion(dfs) to solve this problem, i will use bfs approach to solve this problem.

import java.util.*;

class LC100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }

        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);

        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode first = q1.remove();
            TreeNode second = q2.remove();

            if (first.val != second.val) {
                return false;
            }

            if (first.left != null && second.left != null) {
                q1.add(first.left);
                q2.add(second.left);
            } else if (first.left != null || second.left != null) {
                return false;
            }

            if (first.right != null && second.right != null) {
                q1.add(first.right);
                q2.add(second.right);
            } else if (first.right != null || second.right != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC100_SameTree solution = new LC100_SameTree();
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(2);
        q.right = new TreeNode(3);

        System.out.println(solution.isSameTree(p, q)); // Output: true
    }
}
