/*
Leetcode 3532 - path existence queries in a graph I
Appraoch : We can preprocess the nums array to identify connected components based on the maxDiff constraint. We assign a component ID to each index in the nums array. If the difference between consecutive elements exceeds maxDiff, we increment the component ID. After preprocessing, we can answer each query by checking if both indices belong to the same component.

Time Complexity: O(n + q) for preprocessing the nums array and answering each query, where n is the length of the nums array and q is the number of queries.
Space Complexity: O(n) for storing the component IDs for each index in the nums array.
*/

class LC3532_PathExistenceI {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int component[] = new int[n];
        int compId = 0;
        component[0] = compId;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] > maxDiff) {
                compId++;
            }
            component[i] = compId;
        }

        boolean[] result = new boolean[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = (component[queries[j][0]] == component[queries[j][1]]);
        }
        return result;
    }

    public static void main(String[] args) {
        LC3532_PathExistenceI solution = new LC3532_PathExistenceI();
        // Example usage
        int n = 5;
        int[] nums = { 1, 3, 6, 10, 15 };
        int maxDiff = 3;
        int[][] queries = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 0, 4 } };
        boolean[] results = solution.pathExistenceQueries(n, nums, maxDiff, queries);
        for (boolean res : results) {
            System.out.println(res);
        }
    }
}