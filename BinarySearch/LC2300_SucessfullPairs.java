/*
LeetCode 2300 - Successful Pairs of Spells and Potions
Approach: To solve the problem of finding the number of successful pairs of spells and potions, we can use a binary search approach. First, we sort the potions array. For each spell, we calculate the minimum potion value required to achieve the desired success threshold. We then use binary search to find the index of the first potion that meets or exceeds this minimum value. The number of successful pairs for that spell is then the total number of potions minus the index found.

Time Complexity: O(n log m) where n is the number of spells and m is the number of potions. The log m factor comes from the binary search for each spell.
Space Complexity: O(1) as we are using a constant amount of extra space.    
*/

import java.util.*;

class LC2300_SucessfullPairs {
    public int findElement(int arr[], long target) {
        int PossibleIdx = -1;
        int low = 0, high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= target) {
                PossibleIdx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return PossibleIdx;
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int m = potions.length;
        int n = spells.length;
        int result[] = new int[n];
        Arrays.sort(potions);

        int maxPotion = potions[m - 1];

        for (int i = 0; i < n; i++) {
            long minPotion = (long) Math.ceil((1.0 * success) / spells[i]);

            if (minPotion > maxPotion) {
                result[i] = 0;
                continue;
            }
            result[i] = m - findElement(potions, minPotion);
        }
        return result;
    }

    public static void main(String[] a) {
        LC2300_SucessfullPairs obj = new LC2300_SucessfullPairs();
        int[] spells = { 10, 20, 30 };
        int[] potions = { 1, 2, 3, 4, 5 };
        long success = 100;
        int[] result = obj.successfulPairs(spells, potions, success);
        System.out.println(Arrays.toString(result));
    }
}
