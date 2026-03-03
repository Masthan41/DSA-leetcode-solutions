/*
LeetCode 760 - Longest Word in Dictionary
Approach: Build a Trie from the given list of words and perform DFS to find the longest word that can be built one character at a time
Time Complexity: O(N * M) where N is the number of words and M is the average length of each word
Space Complexity: O(N * M) for the Trie
*/

class LC760_LongestWord {
    class Node {
        Node[] children = new Node[26];
        boolean eow = false;
    }

    private Node root = new Node();
    private String ans = "";

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

    private void dfs(Node node, StringBuilder sb) {
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null && node.children[i].eow) {

                char ch = (char) (i + 'a');
                sb.append(ch);

                String current = sb.toString();
                if (current.length() > ans.length()) {
                    ans = current;
                }

                dfs(node.children[i], sb);

                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    public String longestWord(String[] words) {

        for (String word : words) {
            insert(word);
        }

        dfs(root, new StringBuilder());

        return ans;
    }

    public static void main(String[] args) {
        LC760_LongestWord solution = new LC760_LongestWord();
        String[] words = { "w", "wo", "wor", "worl", "world" };
        String result = solution.longestWord(words);
        System.out.println(result); // Output: "world"
    }
}
