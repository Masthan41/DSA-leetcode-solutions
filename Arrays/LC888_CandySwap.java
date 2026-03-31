/*
LeetCode 888 - Fair Candy Swap
Approach: Use a HashSet to store Bob's candy sizes and calculate the difference needed for a fair swap
Time complexity: O(n) where n is the length of the longer array (Alice's or Bob's)
Space complexity: O(n) for the HashSet
*/

import java.util.*;

class LC888_CandySwap {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {

        int sumA = 0, sumB = 0;

        for (int a : aliceSizes)
            sumA += a;
        for (int b : bobSizes)
            sumB += b;

        int diff = (sumB - sumA) / 2;

        Set<Integer> setB = new HashSet<>();
        for (int b : bobSizes) {
            setB.add(b);
        }

        for (int a : aliceSizes) {
            int y = a + diff;
            if (setB.contains(y)) {
                return new int[] { a, y };
            }
        }

        return new int[0];
    }

    public static void main(String[] args) {
        LC888_CandySwap obj = new LC888_CandySwap();
        int[] aliceSizes = { 1, 2, 5 };
        int[] bobSizes = { 2, 4 };
        int[] result = obj.fairCandySwap(aliceSizes, bobSizes);
        System.out.println(Arrays.toString(result)); // Output: [5, 4]
    }
}