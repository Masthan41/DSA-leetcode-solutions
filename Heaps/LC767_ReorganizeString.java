/*
LeetCode 767 - Reorganize String
Approach: Use a max-heap to keep track of the characters with the highest frequencies.
Time Complexity: O(n log m) as we may need to add n elements to the heap, and each insertion takes O(log m) time, where m is the number of unique characters.
Space Complexity: O(m) as we are storing at most m elements in the heap.
*/

import java.util.*;

class LC767_ReorganizeString {
    public String reorganizeString(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);

            if (map.get(s.charAt(i)) > (n + 1) / 2) {
                return "";
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        for (char c : map.keySet()) {
            pq.add(new int[] { map.get(c), c });
        }

        StringBuilder sb = new StringBuilder();
        while (pq.size() >= 2) {
            int first[] = pq.remove();
            int second[] = pq.remove();

            sb.append((char) first[1]);
            sb.append((char) second[1]);

            first[0]--;
            second[0]--;

            if (first[0] > 0) {
                pq.add(first);
            }
            if (second[0] > 0) {
                pq.add(second);
            }
        }

        if (!pq.isEmpty()) {
            int first[] = pq.remove();

            sb.append((char) first[1]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC767_ReorganizeString reorganizer = new LC767_ReorganizeString();
        String input = "aab";
        String result = reorganizer.reorganizeString(input);
        System.out.println("Reorganized String: " + result); // Output: "aba"
    }
}
