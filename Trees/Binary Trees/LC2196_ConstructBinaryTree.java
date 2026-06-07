/* 
LeetCode 2196 - Construct Binary Tree From Descriptions
Approach: Use a HashMap to store the nodes and a HashSet to track child nodes. For each description, create or retrieve the parent and child nodes, and set the left or right child accordingly. Finally, identify the root node as the one that is not a child of any other node.

Time Complexity: O(n) where n is the number of descriptions
Space Complexity: O(n) for the HashMap and HashSet
*/

class LC2196_ConstructBinaryTree{
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> mp = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();

        // Create nodes and set up parent-child relationships
        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            boolean isLeft = description[2] == 1;

            mp.putIfAbsent(parent, new TreeNode(parent));
            mp.putIfAbsent(child, new TreeNode(child));

            if (isLeft) {
                mp.get(parent).left = mp.get(child);
            } else {
                mp.get(parent).right = mp.get(child);
            }

            childSet.add(child);
        }

        // Find the root node (which is not any child)
        for (int[] description : descriptions) {
            int parent = description[0];
            if (!childSet.contains(parent)) {
                return mp.get(parent);
            }
        }
        return null;
    }
    public static void main(String[] args){
        LC2196_ConstructBinaryTree obj = new LC2196_ConstructBinaryTree();
        int[][] descriptions = {{1, 2, 1}, {1, 3, 0}, {2, 4, 1}};
        TreeNode root = obj.createBinaryTree(descriptions);
        // The tree structure will be:
        //     1
        //    / \
        //   2   3
        //  /
        // 4
    }
}