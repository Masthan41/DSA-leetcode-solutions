/*
LeetCode 1382 - Balance BST
Approach: Inorder traversal + Create balanced BST from sorted array
Time Complexity: O(n)
Space Complexity: O(n)
*/
import java.util.*;

public class LC_1382_Balance_BST {
    public void getInorder(TreeNode root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        getInorder(root.left, list);
        list.add(root.val);
        getInorder(root.right, list);
    }

    public static TreeNode createBST(ArrayList<Integer> list, int st, int end) {
        if (st > end) {
            return null;
        }
        int mid = st + (end - st) / 2;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = createBST(list, st, mid - 1);
        root.right = createBST(list, mid + 1, end);
        return root;
    }

    public TreeNode balanceBST(TreeNode root) {
        // calc inorder seq
        ArrayList<Integer> list = new ArrayList<>();
        getInorder(root, list);

        // sorted inorder -> balanced BST
        return createBST(list, 0, list.size() - 1);
    }
    public static void main(String[] args) {
        LC_1382_Balance_BST obj = new LC_1382_Balance_BST();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        TreeNode ans = obj.balanceBST(root);
        System.out.println(ans.val); // 2
    }
}
