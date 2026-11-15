/*
LeetCode 129 - Sum Root to Leaf Numbers
Approach: Use a recursive approach to traverse the tree and calculate the sum of all root-to-leaf paths.
Time complexity: O(n) where n is the number of nodes in the tree
Space complexity: O(h) where h is the height of the tree (due to the recursive call stack)
*/

class LC129_RootToLeaf {
    public int findSum(TreeNode root, int curr) {
        if (root == null) {
            return 0;
        }
        curr = (curr * 10) + root.val;

        if (root.left == null && root.right == null) {
            return curr;
        }

        int left = findSum(root.left, curr);
        int right = findSum(root.right, curr);

        return left + right;
    }

    public int sumNumbers(TreeNode root) {
        return findSum(root, 0);
    }

    public static void main(String[] args) {
        LC129_RootToLeaf obj = new LC129_RootToLeaf();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(obj.sumNumbers(root));
    }
}
