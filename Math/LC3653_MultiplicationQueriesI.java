/*
LeetCode 3653 - XOR after Multiplication Queries I
Approach: Iterate through each query and perform the multiplication on the specified range of indices in the nums array. After processing all queries, compute the XOR of all elements in the nums array to get the final result.

Time Complexity: O(m * n) where m is the number of queries and n is the length of the nums array, as we may need to iterate through a portion of the nums array for each query.

Space Complexity: O(1) as we are modifying the nums array in place and using a constant amount of extra space for variables and the result.
*/

class LC3653_MultiplicationQueriesI {
    final int M = 1000000007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int i[] : queries) {
            int l = i[0];
            int r = i[1];
            int k = i[2];
            int v = i[3];

            while (l <= r) {
                nums[l] = (int) ((1L * nums[l] * v) % M);
                l += k;
            }
        }
        int res = 0;
        for (int i : nums) {
            res = res ^ i;
        }
        return res;
    }

    public static void main(String[] args) {
        LC3653_MultiplicationQueriesI lc = new LC3653_MultiplicationQueriesI();
        System.out.println(lc.xorAfterQueries(new int[] { 1, 2, 3, 4, 5 },
                new int[][] { { 0, 4, 1, 2 }, { 0, 3, 2, 2 }, { 0, 1, 1, 2 } }));
    }
}
