/*
LeetCode 1356 - Sort Integers by The Number of 1 Bits
Approach: Sort with custom comparator
Time complexity: O(n log n)
Space complexity: O(n)
*/

import java.util.*;

class LC1356_SortByBits {
    public int[] sortByBits(int[] arr) {
        Integer nums[] = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }
        Arrays.sort(nums, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                int bita = Integer.bitCount(a);
                int bitb = Integer.bitCount(b);

                if (bita == bitb) {
                    return a - b;
                }
                return bita - bitb;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }
        return arr;
    }
    public static void main(String[] args) {
        LC1356_SortByBits s = new LC1356_SortByBits();
        int[] arr = {0,1,2,3,4,5,6,7,8};
        System.out.println(Arrays.toString(s.sortByBits(arr)));
    }
}