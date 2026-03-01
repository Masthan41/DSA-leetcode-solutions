/*
LeetCode 451 - Sort Characters By Frequency
Approach: HashMap Frequency Counting + Max Heap
Time Complexity: O(n log n)
Space Complexity: O(n)
*/

import java.util.*;

class LC451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Step 2: Max heap based on freq
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        //Step 3: result
        StringBuilder sb = new StringBuilder();

        while (!pq.isEmpty()) {
            char ch = pq.poll();
            int freq = map.get(ch);

            while (freq-- > 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LC451_SortCharactersByFrequency obj = new LC451_SortCharactersByFrequency();
        String s = "tree";
        System.out.println(obj.frequencySort(s)); // Output: "eert" or "eetr"
    }
}
