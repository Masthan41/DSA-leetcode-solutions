/* LeetCode 1026 - Maximum Difference Between Node and Ancestor
Approach: Use DFS to traverse the tree, keeping track of the maximum and minimum values encountered so far. At each node, calculate the difference between the current maximum and minimum values, and return the maximum difference found.

Time Complexity: O(n) as we visit each node once
Space Complexity: O(h) where h is the height of the tree (recursion stack)
*/

class LC1026_MaxDifference {
    public int findMaxDiff(TreeNode root, int max, int min) {
        if (root == null) {
            return Math.abs(min - max);
        }

        max = Math.max(max, root.val);
        min = Math.min(min, root.val);

        int left = findMaxDiff(root.left, max, min);
        int right = findMaxDiff(root.right, max, min);

        return Math.max(left, right);
    }

    public int maxAncestorDiff(TreeNode root) {
        return findMaxDiff(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        LC1026_MaxDifference sol = new LC1026_MaxDifference();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);

        int result = sol.maxAncestorDiff(root);
        System.out.println(result); // Output: 7
    }
}
