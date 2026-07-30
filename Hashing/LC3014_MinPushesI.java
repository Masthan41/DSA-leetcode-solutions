/*
LeetCode 3014 - Minimum Number of Pushes to Type a String I
Approach: HashMap Frequency Counting through assigning each character to a number from 2 to 9 and counting the total pushes required.
Time Complexity: O(n) as we iterate through the string once and perform constant time operations for each character.
Space Complexity: O(1) since the HashMap will have at most 8 entries (for digits 2 to 9).
*/

import java.util.*;

class LC3014_MinPushesI {
    public int minimumPushes(String word) {
        int n = word.length();
        if (n <= 8) {
            return n;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int assign = 2;

        int count = 0;
        for (char ch : word.toCharArray()) {
            if (assign > 9) {
                assign = 2;
            }

            map.put(assign, map.getOrDefault(assign, 0) + 1);
            count += map.get(assign);
            assign++;
        }
        return count;
    }

    public static void main(String[] args) {
        LC3014_MinPushesI solution = new LC3014_MinPushesI();
        String word = "abcdefghijklmno";
        int result = solution.minimumPushes(word);
        System.out.println("Minimum pushes for the word '" + word + "': " + result);
    }
}
