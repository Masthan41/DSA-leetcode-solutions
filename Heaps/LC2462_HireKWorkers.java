/*
LeetCode 2462 - Total Cost to Hire K Workers
Approach: Use two priority queues to maintain the minimum costs from both ends of the array. At each step, hire the worker with the lowest cost from either end, and refill the priority queues as needed.

Time complexity: O(k log candidates) where k is the number of workers to hire and candidates is the number of candidates considered from each end. Each insertion and removal from the priority queue takes O(log candidates), and we perform this operation k times.
Space complexity: O(candidates) for the two priority queues.
*/

import java.util.PriorityQueue;

class LC2462_HireKWorkers {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;
        long cost = 0;
        int i = 0, j = n - 1;

        PriorityQueue<Integer> left = new PriorityQueue<>();
        PriorityQueue<Integer> right = new PriorityQueue<>();

        while (k > 0) {
            while (left.size() < candidates && i <= j) {
                left.add(costs[i]);
                i++;
            }
            while (right.size() < candidates && j >= i) {
                right.add(costs[j]);
                j--;
            }

            int min1 = left.isEmpty() ? Integer.MAX_VALUE : left.peek();
            int min2 = right.isEmpty() ? Integer.MAX_VALUE : right.peek();

            if (min1 <= min2) {
                cost += min1;
                left.remove();
            } else {
                cost += min2;
                right.remove();
            }
            k--;
        }

        return cost;
    }

    public static void main(String[] args) {
        LC2462_HireKWorkers solution = new LC2462_HireKWorkers();
        int[] costs = { 10, 20, 30, 40, 50 };
        int k = 3;
        int candidates = 2;
        long result = solution.totalCost(costs, k, candidates);
        System.out.println("Total cost to hire " + k + " workers: " + result);
    }
}
