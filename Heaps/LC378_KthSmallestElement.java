/*
Leetcode 378 - Kth Smallest Element in a Sorted Matrix
Approach - Use a max-heap to keep track of the k smallest elements. Iterate through the matrix and add each element to the heap. If the heap size exceeds k, remove the largest element. The top of the heap will be the kth smallest element.
Time Complexity - O(n * m * log(k)) where n is the number of rows, m is the number of columns, and k is the given value.
Space Complexity - O(k) for the heap.
*/

//it can be solved using binary search as well, but the above approach is more straightforward and easier to implement.

import java.util.*;

class LC378_KthSmallestElement {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pq.add(matrix[i][j]);
                if (pq.size() > k) {
                    pq.remove();
                }
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        LC378_KthSmallestElement solution = new LC378_KthSmallestElement();
        int[][] matrix1 = { { 1, 5, 9 }, { 10, 11, 13 }, { 12, 13, 15 } };
        int k = 8;
        int result = solution.kthSmallest(matrix1, k);
        System.out.println("The " + k + "th smallest element is: " + result);

        int[][] matrix2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        k = 5;
        result = solution.kthSmallest(matrix2, k);
        System.out.println("The " + k + "th smallest element is: " + result);
    }
}
