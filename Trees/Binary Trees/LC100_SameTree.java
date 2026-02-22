/*
LeetCode 100 - Same Tree
Approach: Recursive tree comparison
Time Complexity: O(n)
Space Complexity: O(h)
*/

class LC100_SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
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
