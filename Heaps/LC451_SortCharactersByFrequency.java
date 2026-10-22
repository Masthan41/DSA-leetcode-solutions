/*
LeetCode 451 - Sort Characters By Frequency
Approach: HashMap Frequency Counting + Max Heap
Time Complexity: O(n log n)
Space Complexity: O(n)
*/

import java.util.*;

class LC451_SortCharactersByFrequency {
    public String frequencySort(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> temp = pq.remove();
            for (int i = 0; i < temp.getValue(); i++) {
                sb.append(temp.getKey());
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
