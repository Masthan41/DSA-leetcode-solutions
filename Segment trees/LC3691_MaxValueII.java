/*
LeetCode 3691 - Max Value of K Subsequences
Approach: Segment Tree + Priority Queue
Time Complexity: O(n*logn + k*logn) where n is the length of the input array and k is the number of subsequences to find.
Space Complexity: O(n) for the segment trees and O(k) for the priority queue.
*/

import java.util.*;

class SegmentTree {
    int[] segmentTree;
    boolean isMinTree;

    SegmentTree(int[] nums, boolean flag) {
        int n = nums.length;
        this.isMinTree = flag;
        segmentTree = new int[4 * n];
        buildSegmentTree(0, 0, n - 1, nums);
    }

    void buildSegmentTree(int i, int l, int r, int[] nums) {
        if (l == r) {
            segmentTree[i] = nums[l];
            return;
        }

        int mid = l + (r - l) / 2;

        buildSegmentTree(2 * i + 1, l, mid, nums);
        buildSegmentTree(2 * i + 2, mid + 1, r, nums);

        if (isMinTree) {
            segmentTree[i] = Math.min(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
        } else {
            segmentTree[i] = Math.max(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
        }
    }

    int querySegmentTree(int start, int end, int i, int l, int r) {
        // No overlap
        if (l > end || r < start) {
            return isMinTree ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        // Complete Overlap
        if (l >= start && r <= end) {
            return segmentTree[i];
        }

        int mid = l + (r - l) / 2;

        int a = querySegmentTree(start, end, 2 * i + 1, l, mid);
        int b = querySegmentTree(start, end, 2 * i + 2, mid + 1, r);

        if (isMinTree) {
            return Math.min(a, b);
        }

        return Math.max(a, b);
    }

    int query(int l, int r, int n) {
        return querySegmentTree(l, r, 0, 0, n - 1);
    }
}

class LC3691_MaxValueII {
    long getValue(int l, int r, SegmentTree minST, SegmentTree maxST, int n) {
        int minEl = minST.query(l, r, n);
        int maxEl = maxST.query(l, r, n);
        return (long) maxEl - minEl;
    }

    public long maxTotalValue(int[] nums, int k) {
        int n = nums.length;

        SegmentTree minST = new SegmentTree(nums, true); // true is for minimum
        SegmentTree maxST = new SegmentTree(nums, false); // false is for maximum

        // {val, l, r} max. heap
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        // Step-1 (Initialize the heap with best value)
        // O(n*logn)
        for (int l = 0; l < n; l++) {
            long value = getValue(l, n - 1, minST, maxST, n); // log(n)
            pq.offer(new long[] { value, l, n - 1 });
        }

        // Step-2 Find top k
        long result = 0;
        // O(k * log(n))
        while (k-- > 0) {
            long[] top = pq.poll();
            long value = top[0];
            int l = (int) top[1];
            int r = (int) top[2];

            result += value;

            long nextBestValue = getValue(l, r - 1, minST, maxST, n); // log(n)

            pq.offer(new long[] { nextBestValue, l, r - 1 }); // log(n)
        }
        return result;
    }

    public static void main(String[] args) {
        LC3691_MaxValueII obj = new LC3691_MaxValueII();
        int[] nums = { 1, 2, 3, 4 };
        int k = 3;
        System.out.println(obj.maxTotalValue(nums, k));
    }
}
