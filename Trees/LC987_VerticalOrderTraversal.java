/*
LeetCode 987 - Vertical Order Traversal
Approach: BFS + TreeMap + PriorityQueue
Time Complexity: O(n log n)
Space Complexity: O(n)
*/

import java.util.*;

class LC987_VerticalOrderTraversal {

    static class Info {
        TreeNode node;
        int row, col;

        Info(TreeNode n, int r, int c) {
            node = n;
            row = r;
            col = c;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(root, 0, 0));

        while (!queue.isEmpty()) {

            Info curr = queue.poll();

            map.putIfAbsent(curr.col, new TreeMap<>());
            map.get(curr.col).putIfAbsent(curr.row, new PriorityQueue<>());

            map.get(curr.col).get(curr.row).add(curr.node.val);

            if (curr.node.left != null)
                queue.add(new Info(curr.node.left, curr.row + 1, curr.col - 1));

            if (curr.node.right != null)
                queue.add(new Info(curr.node.right, curr.row + 1, curr.col + 1));
        }

        List<List<Integer>> result = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> rows : map.values()) {

            List<Integer> list = new ArrayList<>();

            for (PriorityQueue<Integer> pq : rows.values())
                while (!pq.isEmpty())
                    list.add(pq.poll());

            result.add(list);
        }

        return result;
    }

    public static void main(String[] args) {
        LC987_VerticalOrderTraversal obj = new LC987_VerticalOrderTraversal();

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(obj.verticalTraversal(root));
    }
}
