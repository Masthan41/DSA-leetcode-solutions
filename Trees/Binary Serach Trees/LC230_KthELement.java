/*
LeetCode 230 - Kth Smallest Element in a BST
Approach: Perform an in-order traversal of the BST and return the kth element.
Time Complexity: O(h + k) where h is the height of the tree
Space Complexity: O(h) for the recursion stack in the worst case (skewed tree)
*/

import java.util.*;

class LC230_KthELement {
    public void inOrder(TreeNode root, List<Integer> res){
        if(root==null){
            return;
        }
        inOrder(root.left,res);
        res.add(root.val);
        inOrder(root.right,res);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res=new ArrayList<>();
        inOrder(root,res);
        return res.get(k-1);
    }
    public static void main(String[] args) {
        LC230_KthELement obj = new LC230_KthELement();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        int k = 1;
        System.out.println(obj.kthSmallest(root, k)); // Output: 1
    }
}
