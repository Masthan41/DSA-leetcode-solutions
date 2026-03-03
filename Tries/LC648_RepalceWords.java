/*
LeetCode 648 - Replace Words
Approach: Build a Trie from the dictionary and for each word in the sentence, find the shortest root in the Trie
Time Complexity: O(N * M + S * W) where N is the number of words in dictionary, M is average length of each word in dictionary, S is number of words in sentence, W is average length of each word in sentence
Space Complexity: O(N * M) for the Trie
*/

import java.util.*;

class LC648_RepalceWords {
    class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    private final Node root = new Node();

    private void insert(String word) {
        Node curr = root;
        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    private String getRoot(String word) {
        Node curr = root;
        StringBuilder sb = new StringBuilder();

        for (char ch : word.toCharArray()) {
            int idx = ch - 'a';

            if (curr.children[idx] == null) {
                return word; // no root found
            }

            sb.append(ch);
            curr = curr.children[idx];

            if (curr.eow) {
                return sb.toString(); // shortest root found
            }
        }
        return word;
    }

    public String replaceWords(List<String> dictionary, String sentence) {

        for (String rootWord : dictionary) {
            insert(rootWord);
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            result.append(getRoot(word)).append(" ");
        }

        return result.toString().trim();
    }

    public static void main(String[] args) {
        LC648_RepalceWords solution = new LC648_RepalceWords();
        List<String> dictionary = List.of("cat", "bat", "rat");
        String sentence = "the cattle was rattled by the battery";
        String replacedSentence = solution.replaceWords(dictionary, sentence);
        System.out.println(replacedSentence); // Output: "the cat was rat by the bat"
    }
}
