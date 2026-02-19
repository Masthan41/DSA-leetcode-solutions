/*
LeetCode 863 - All Nodes Distance K in Binary Tree
Approach: Parent map + BFS
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

class LC863_AllNodesDistanceK {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        // store parent map
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, null, parent);

        // BFS from target
        Queue<TreeNode> q = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        q.add(target);
        visited.add(target);

        int dist = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            if (dist == k) {
                List<Integer> result = new ArrayList<>();
                for (TreeNode node : q)
                    result.add(node.val);
                return result;
            }

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.remove();

                // left
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    q.add(curr.left);
                }

                // right
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    q.add(curr.right);
                }

                // parent
                if (parent.get(curr) != null && !visited.contains(parent.get(curr))) {
                    visited.add(parent.get(curr));
                    q.add(parent.get(curr));
                }
            }

            dist++;
        }

        return new ArrayList<>();
    }

    private void buildParent(TreeNode node, TreeNode par,
            HashMap<TreeNode, TreeNode> parent) {

        if (node == null)
            return;

        parent.put(node, par);

        buildParent(node.left, node, parent);
        buildParent(node.right, node, parent);
    }

    public static void main(String[] args) {
        LC863_AllNodesDistanceK solution = new LC863_AllNodesDistanceK();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        TreeNode target = root.left; // Node with value 5
        int k = 2;

        List<Integer> result = solution.distanceK(root, target, k);
        System.out.println(result); // Output: [7, 4, 1]
    }
}
