/*
LeetCode 3525 - Find X Value in array II
Approach: We use a segment tree to maintain the counts of subarrays with specific remainders and the product of elements in each segment. Each node in the segment tree stores an array of counts for each possible remainder (from 0 to k-1) and the product of the elements in that segment modulo k. When processing queries, we update the segment tree with new values and query for the count of subarrays with a specific remainder in a given range.

Time Complexity: O(q * log n) for processing all queries, O(n) for initialization
Space Complexity: O(n) for segment tree and auxiliary arrays
*/

class Node {
    int[] cnt = new int[5];
    int prod = 0;
}

class SegmentTree {
    int n, k;
    Node[] segTree;

    SegmentTree(int[] nums, int k) {
        this.k = k;
        this.n = nums.length;
        segTree = new Node[4 * n];
        for (int i = 0; i < 4 * n; i++) {
            segTree[i] = new Node();
        }
        build(0, 0, n - 1, nums);
    }

    void build(int i, int l, int r, int[] nums) {
        if (l == r) {
            leafNode(i, nums[l]);
            return;
        }

        int mid = l + (r - l) / 2;
        build(2 * i + 1, l, mid, nums);
        build(2 * i + 2, mid + 1, r, nums);
        segTree[i] = mergeNodes(segTree[2 * i + 1], segTree[2 * i + 2]);
    }

    void leafNode(int i, int value) { // represents 1 element nums[i];
        for (int x = 0; x < k; x++) {
            segTree[i].cnt[x] = 0;
        }

        int r = value % k;
        segTree[i].cnt[r] = 1;
        segTree[i].prod = r;
    }

    Node mergeNodes(Node left, Node right) {
        Node result = new Node();
        result.prod = (left.prod * right.prod) % k;

        for (int x = 0; x < k; x++) {
            result.cnt[x] = left.cnt[x];
        }
        for (int x = 0; x < k; x++) {
            int newRem = (left.prod * x) % k;
            result.cnt[newRem] += right.cnt[x];
        }

        return result;
    }

    void segTreeUpdate(int i, int l, int r, int index, int value) {
        if (l == r) {
            leafNode(i, value);
            return;
        }

        int mid = l + (r - l) / 2;
        if (index <= mid) {
            segTreeUpdate(2 * i + 1, l, mid, index, value);
        } else {
            segTreeUpdate(2 * i + 2, mid + 1, r, index, value);
        }

        segTree[i] = mergeNodes(segTree[2 * i + 1], segTree[2 * i + 2]);
    }

    void update(int index, int value) {
        segTreeUpdate(0, 0, n - 1, index, value);
    }

    Node segTreeQuery(int start, int end, int i, int l, int r) {
        if (l >= start && r <= end) {
            return segTree[i];
        }

        int mid = l + (r - l) / 2;
        if (end <= mid) {
            return segTreeQuery(start, end, 2 * i + 1, l, mid);
        }
        if (start > mid) {
            return segTreeQuery(start, end, 2 * i + 2, mid + 1, r);
        }

        Node left = segTreeQuery(start, end, 2 * i + 1, l, mid);
        Node right = segTreeQuery(start, end, 2 * i + 2, mid + 1, r);

        return mergeNodes(left, right);
    }

    Node query(int start, int end) {
        // range is [start, end]
        // i = 0 -> index of root node of segment tree which covers the range of 0...n-1
        // of nums
        return segTreeQuery(start, end, 0, 0, n - 1);
    }
}

class LC3525_FindXValueII {
    public int[] resultArray(int[] nums, int k, int[][] queries) {
        int n = nums.length;
        SegmentTree segTree = new SegmentTree(nums, k);
        int[] result = new int[queries.length];

        for (int idx = 0; idx < queries.length; idx++) {
            int index = queries[idx][0];
            int value = queries[idx][1];
            int start = queries[idx][2];
            int x = queries[idx][3];

            segTree.update(index, value);

            Node node = segTree.query(start, n - 1);

            result[idx] = node.cnt[x];
        }
        return result;
    }

    public static void main(String[] a) {
        LC3525_FindXValueII obj = new LC3525_FindXValueII();
        int[] nums = { 1, 2, 3 };
        int k = 2;
        int[][] queries = { { 0, 3, 0, 1 }, { 1, 4, 1, 0 } };
        int[] result = obj.resultArray(nums, k, queries);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}