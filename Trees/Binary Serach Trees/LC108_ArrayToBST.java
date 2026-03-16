/*
LeetCode 108 - Sorted Array to Binary Search Tree
Approach: We can use a recursive approach to build the BST. We find the middle element of the current subarray to be the root of the subtree, and then recursively build the left and right subtrees using the left and right halves of the array, respectively.

Time Complexity: O(n) where n is the number of elements in the input array, since we need to visit each element once to construct the tree.

Space Complexity: O(log n) on average for the recursive stack space, where n is the number of elements in the input array. In the worst case (when the tree is skewed), it can go up to O(n).
*/

class ArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int st, int end) {
        if (st > end)
            return null;

        int mid = st + (end - st) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = build(nums, st, mid - 1);
        root.right = build(nums, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        ArrayToBST sol = new ArrayToBST();
        int[] nums = { -10, -3, 0, 5, 9 };
        TreeNode root = sol.sortedArrayToBST(nums);
        // You can add code here to print the tree or verify the structure
    }
}