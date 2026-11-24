/*
LeetCode 988 - Smallest String Starting From Leaf
Approach: Use a StringBuilder to build the string from leaf to root, and backtrack to explore all paths using DFS. Compare the strings to find the smallest one.
Time Complexity: O(n) as we visit each node once
Space Complexity: O(n) as we use a StringBuilder to store the current path and the recursion stack can go up to the height of the tree.
*/

//it can be solved using BFS as well, but DFS is more straightforward for this problem.

class LC988_SmallestString {
    String res = "";

    public void getString(TreeNode root, StringBuilder curr) {
        if (root == null) {
            return;
        }

        curr.insert(0, (char) (root.val + 'a'));
        if (root.left == null && root.right == null) {
            String str = curr.toString();
            if (res.equals("") || res.compareTo(str) > 0) {
                res = str;
            }
        }

        getString(root.left, curr);
        getString(root.right, curr);

        // backtracking
        curr.deleteCharAt(0);
    }

    public String smallestFromLeaf(TreeNode root) {
        getString(root, new StringBuilder());
        return res;
    }

    public static void main(String[] args) {
        LC988_SmallestString obj = new LC988_SmallestString();
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(2);
        System.out.println(obj.smallestFromLeaf(root));
    }
}