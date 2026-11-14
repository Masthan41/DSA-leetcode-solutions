/*
LeetCode 113 - Path Sum II
Approach: Use Depth-First Search (DFS) to traverse the binary tree. We maintain a running sum of the node values along the current path and a temporary list to store the current path. When we reach a leaf node (a node with no children), we check if the running sum equals the target sum. If it does, we add a copy of the temporary list to the result list. After exploring both left and right subtrees, we backtrack by removing the last added node from the temporary list.

Time Complexity: O(n) as we visit each node exactly once, where n is the number of nodes in the binary tree. 
Space Complexity: O(h) where h is the height of the binary tree, which is the maximum depth of the recursion stack. In the worst case, this can be equal to the number of nodes in a skewed tree. Additionally, we may store up to O(n) paths in the result list in the worst case.
*/

import java.util.*;

class LC113_PathSumII {
    List<List<Integer>> list = new ArrayList<>();

    public void fill(TreeNode root, int sum, int target, List<Integer> temp) {
        if (root == null) {
            return;
        }

        sum += root.val;
        temp.add(root.val);

        if (root.left == null && root.right == null) {
            if (sum == target) {
                list.add(new ArrayList<>(temp));
            }
        } else {
            fill(root.left, sum, target, temp);
            fill(root.right, sum, target, temp);
        }

        temp.remove(temp.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        fill(root, 0, targetSum, new ArrayList<>());
        return list;
    }

    public static void main(String[] args) {
        LC113_PathSumII solution = new LC113_PathSumII();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> result = solution.pathSum(root, targetSum);
        System.out.println(result); // Output: [[5, 4, 11, 2], [5, 8, 4, 5]]
    }
}
