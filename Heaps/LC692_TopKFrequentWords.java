/*
LeetCode 692 - Top K Frequent Words
Approach: Use a min-heap to keep track of the top k frequent words. Add each word to the heap, and if the heap size exceeds k, remove the word with the lowest frequency.
Time Complexity: O(n+n log k) as we are adding all the scores to the heap and removing them one by one.
Space Complexity: O(n+k) for the heap and the result array.
*/

import java.util.*;

class LC692_TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String word = words[i];
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        List<String> list = new ArrayList<>(map.keySet());

        list.sort((a, b) -> {
            int freq = Integer.compare(map.get(b), map.get(a));

            if (freq != 0) {
                return freq;
            }
            return a.compareTo(b);
        });

        return list.subList(0, k);
    }

    public static void main(String[] args) {
        LC692_TopKFrequentWords solution = new LC692_TopKFrequentWords();
        String[] words = { "i", "love", "leetcode", "i", "love", "coding" };
        int k = 2;
        List<String> result = solution.topKFrequent(words, k);
        System.out.println(result); // Output: ["i", "love"]
    }
}
