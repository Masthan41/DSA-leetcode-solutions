/*
LeetCode 437 - Path Sum III
Approach: Use DFS based recursion to traverse the tree and check for paths that sum up to the target value. For each node, we check if the current path sum equals the target sum and recursively check its left and right children.
Time Complexity: O(n^2) in the worst case for a skewed tree, as we may visit each node and for each node, we may traverse all its descendants.
Space Complexity: O(h) as the recursion stack can go as deep as the height of the tree.
*/

class LC437_PathSumIII {
    public int findSum(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }

        long res = 0;
        if (root.val == targetSum) {
            res++;
        }

        res += findSum(root.left, targetSum - root.val);
        res += findSum(root.right, targetSum - root.val);

        return (int) res;
    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        return findSum(root, targetSum) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
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
