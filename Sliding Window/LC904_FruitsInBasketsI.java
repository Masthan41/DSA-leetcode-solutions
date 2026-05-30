/*
LeetCode 904 - Fruits in Baskets I
Approach: Sliding Window with two pointers and HashMap to track fruit counts
Time Complexity: O(n) for iterating through the array once
Space Complexity: O(1) for the HashMap since it can only contain at most 2 types of fruits
*/

import java.util.*;

class LC904_FruitsInBasketsI {
    public int totalFruit(int[] fruits) {
        int count = 0, left = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], map.getOrDefault(fruits[i], 0) + 1);
            while (map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);

                if (map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }

                left++;
            }
            count = Math.max(count, i - left + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        LC904_FruitsInBasketsI solution = new LC904_FruitsInBasketsI();
        int[] fruits = { 1, 2, 1, 3, 3, 5 };
        System.out.println(solution.totalFruit(fruits)); // Output: 3
    }
}