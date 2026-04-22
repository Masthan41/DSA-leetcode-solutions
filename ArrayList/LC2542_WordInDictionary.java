/*
LeetCode 2542 - Word in Dictionary
Approach: Compare each query with each dictionary word and count differences.
Time Complexity: O(m * n * k)
Space Complexity: O(1)
*/

import java.util.*;

class LC2542_WordInDictionary {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> list = new ArrayList<>();

        for (String query : queries) {
            for (String s : dictionary) {
                int diff = 0;
                for (int i = 0; i < query.length(); i++) {
                    if (query.charAt(i) != s.charAt(i)) {
                        diff++;
                    }
                    if (diff > 2)
                        break;
                }
                if (diff <= 2) {
                    list.add(query);
                    break;
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LC2542_WordInDictionary solution = new LC2542_WordInDictionary();
        String[] queries = { "word", "note", "ants", "wood" };
        String[] dictionary = { "wood", "joke", "moat" };
        List<String> result = solution.twoEditWords(queries, dictionary);
        System.out.println(result);
    }
}