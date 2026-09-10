import javax.swing.tree.TreeNode;

class LC2265_CountNodes {
    private int result;

    private Pair<Integer, Integer> solve(TreeNode root) {
        if (root == null) {
            return new Pair<>(0, 0);
        }

        Pair<Integer, Integer> left = solve(root.left);
        Pair<Integer, Integer> right = solve(root.right);

        int leftSum = left.getKey();
        int leftCount = left.getValue();

        int rightSum = right.getKey();
        int rightCount = right.getValue();

        int SUM = leftSum + rightSum + root.val;
        int COUNT = leftCount + rightCount + 1;

        int avg = SUM / COUNT;

        if (avg == root.val) {
            result++;
        }

        return new Pair<>(SUM, COUNT);
    }

    public int averageOfSubtree(TreeNode root) {
        result = 0;

        solve(root);

        return result;
    }

    public static void main(String[] args) {
        LC2265_CountNodes solution = new LC2265_CountNodes();

        // Example usage:
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int count = solution.averageOfSubtree(root);
        System.out.println("Count of nodes where the average of the subtree equals the node's value: " + count);
    }
}