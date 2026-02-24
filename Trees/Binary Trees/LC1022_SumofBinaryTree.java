/* LeetCode 1022 - Sum of Root To Leaf Binary Numbers
Approach: Use DFS to traverse the tree, maintaining a running binary number. When a leaf is reached, return the accumulated value. Sum all such values.

Time Complexity: O(n)
Space Complexity: O(h) where h is the height of the tree (recursion stack)
*/

class LC43_MultiplyStrings {
    public String multiply(String n, String m) {
        int res[] = new int[n.length() + m.length()];
        if (n.equals("0") || m.equals("0"))
            return "0";
        for (int i = n.length() - 1; i >= 0; i--) {
            for (int j = m.length() - 1; j >= 0; j--) {
                int dig1 = n.charAt(i) - '0';
                int dig2 = m.charAt(j) - '0';

                int mul = dig1 * dig2;
                int sum = mul + res[1 + i + j];

                res[1 + i + j] = sum % 10;
                res[i + j] += sum / 10;

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC43_MultiplyStrings solution = new LC43_MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        String result = solution.multiply(num1, num2);
        System.out.println("Product: " + result);
    }
}

class LC1022_SumofBinaryTree {
    private int dfs(TreeNode root, int curr) {
        if (root == null)
            return 0;

        curr = (curr << 1) | root.val;

        if (root.left == null && root.right == null) {
            return curr;
        }
        return dfs(root.left, curr) + dfs(root.right, curr);
    }

    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    public static void main(String[] args) {
        LC1022_SumofBinaryTree solution = new LC1022_SumofBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        int result = solution.sumRootToLeaf(root);
        System.out.println("Sum of Root to Leaf Binary Numbers: " + result); // Output: 22
    }
}
