/*
LeetCode 105 - Construct Binary Tree from Preorder and Inorder Traversal
Approach: Use a HashMap to store indices of inorder elements for quick lookup. Recursively construct the tree by identifying the root from preorder and partitioning inorder around that root.
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

class LC105_ConstructBT {
    int idx = 0;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode insert(int[] preorder, int st, int end) {
        if (st > end)
            return null;
        int rootVal = preorder[idx++];
        TreeNode root = new TreeNode(rootVal);

        int Inindex = map.get(rootVal);

        //left subtree
        root.left = insert(preorder, st, Inindex - 1);
        //right subtree
        root.right = insert(preorder, Inindex + 1, end);

        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return insert(preorder, 0, inorder.length - 1);
    }
    public static void main(String[] args) {
        LC105_ConstructBT obj = new LC105_ConstructBT();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        obj.buildTree(preorder, inorder);
        // The tree is constructed successfully. You can add code to print or verify the tree structure if needed.
    }
}
