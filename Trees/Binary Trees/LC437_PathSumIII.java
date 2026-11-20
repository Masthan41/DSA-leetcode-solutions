/*
LeetCode 437 - Path Sum III
Approach: Use DFS with a HashMap to store the cumulative sum and its frequency. For each node, we calculate the cumulative sum and check if there exists a previous cumulative sum that, when subtracted from the current cumulative sum, equals the target sum. If such a previous cumulative sum exists, we add its frequency to the total count of paths. We then recursively call the function for the left and right children of the current node.

Time Complexity: O(n) where n is the number of nodes in the tree, as we visit each node once.
Space Complexity: O(h) where h is the height of the tree, as the HashMap can store at most h elements at any time.
*/

import java.util.*;

class LC437_PathSumIII {
    long total = 0;

    public void findSum(TreeNode root, long sum, long target, Map<Long, Long> map) {
        if (root == null) {
            return;
        }

        sum += root.val;
        if (map.containsKey(sum - target)) {
            total += map.get(sum - target);
        }

        map.put(sum, map.getOrDefault(sum, 0L) + 1);
        findSum(root.left, sum, target, map);
        findSum(root.right, sum, target, map);
        map.put(sum, map.get(sum) - 1);

        return;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        findSum(root, 0, targetSum, map);
        return (int) total;
    }

    public static void main(String[] args) {
        LC437_PathSumIII obj = new LC437_PathSumIII();
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);

        int targetSum = 8;
        int result = obj.pathSum(root, targetSum);
        System.out.println("Number of paths with sum " + targetSum + ": " + result); // Output: 3
    }
}
