/*
LeetCode 2916 - Subarrays with Distinct Elements sum of squares II
Approach: Use a segment tree with lazy propagation to efficiently calculate the sum of squares of distinct elements in all subarrays. The segment tree will maintain two arrays: one for the sum of elements and another for the sum of squares. For each element in the input array, we will update the segment tree to reflect the addition of that element to all subarrays that include it, while also keeping track of the last seen index of each element to ensure we only count distinct elements.

Time Complexity: O(n log n) for processing all elements, where n is the length of the input array
Space Complexity: O(n) for the segment tree and auxiliary arrays
*/

class LC2916_DistinctSubarraysII {
    static final long MOD = 1_000_000_007L;
    int n;

    long[] sqSumSegTree;
    long[] sumSegTree;
    long[] lazyTree;

    void lazyAddition(int i, int l, int r, long val) {
        long len = r - l + 1;

        sqSumSegTree[i] += 2 * val * sumSegTree[i] + len * val * val;
        sumSegTree[i] += len * val;
    }

    void updateRange(int start, int end, int i, int l, int r, long val) {
        if (lazyTree[i] != 0) {
            lazyAddition(i, l, r, lazyTree[i]);

            if (l != r) {
                lazyTree[2 * i + 1] += lazyTree[i];
                lazyTree[2 * i + 2] += lazyTree[i];
            }
            lazyTree[i] = 0;
        }

        // out of range
        if (l > end || r < start || l > r) {
            return;
        }

        // completely within range
        if (l >= start && r <= end) {
            lazyAddition(i, l, r, val);

            if (l != r) {
                lazyTree[2 * i + 1] += val;
                lazyTree[2 * i + 2] += val;
            }
            return;
        }

        int mid = l + (r - l) / 2;
        updateRange(start, end, 2 * i + 1, l, mid, val);
        updateRange(start, end, 2 * i + 2, mid + 1, r, val);

        sumSegTree[i] = sumSegTree[2 * i + 1] + sumSegTree[2 * i + 2];
        sqSumSegTree[i] = sqSumSegTree[2 * i + 1] + sqSumSegTree[2 * i + 2];
    }

    public int sumCounts(int[] nums) {
        n = nums.length;

        sqSumSegTree = new long[4 * n];
        sumSegTree = new long[4 * n];
        lazyTree = new long[4 * n];

        int[] lastSeenIdx = new int[100001];
        java.util.Arrays.fill(lastSeenIdx, -1);
        long result = 0;

        for (int i = 0; i < n; i++) {
            int start = lastSeenIdx[nums[i]] + 1;
            int end = i;

            updateRange(start, end, 0, 0, n - 1, 1);

            result = (result + sqSumSegTree[0]) % MOD;

            lastSeenIdx[nums[i]] = i;
        }

        return (int) result;
    }

    public static void main(String[] args) {
        LC2916_DistinctSubarraysII obj = new LC2916_DistinctSubarraysII();
        int[] nums = { 1, 2, 3 };
        System.out.println(obj.sumCounts(nums));
    }
}
