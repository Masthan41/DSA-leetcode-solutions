/*
LeetCode 102 - Binary Tree Level Order Traversal
Approach: BFS using Queue
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

class LC102_LevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null)
            return res;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {

            int size = q.size(); // number of nodes in current level
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();
                level.add(curr.val);

                if (curr.left != null)
                    q.offer(curr.left);

                if (curr.right != null)
                    q.offer(curr.right);
            }

            res.add(level);
        }

        return res;
    }
    public static void main(String[] args) {
        LC102_LevelOrderTraversal solution = new LC102_LevelOrderTraversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = solution.levelOrder(root);
        System.out.println(result); // Output: [[3], [9, 20], [15, 7]]
    }
}
