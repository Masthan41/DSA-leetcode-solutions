/*
LeetCode 145 - Binary Tree Postorder Traversal
Approach: Recursive traversal (Left → Right → Root)
Time Complexity: O(n)
Space Complexity: O(h)
*/

import java.util.*;

class LC145_PostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        postorder(root, res);
        return res;
    }

    public void postorder(TreeNode root, List<Integer> res) {
        //left -> right -> root

        if (root == null) {
            return;
        }
        postorder(root.left, res);
        postorder(root.right, res);
        res.add(root.val);
    }
    public static void main(String[] args) {
        LC145_PostorderTraversal solution = new LC145_PostorderTraversal();

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = solution.postorderTraversal(root);
        System.out.println(result); // Output: [3, 2, 1]
    }
}
