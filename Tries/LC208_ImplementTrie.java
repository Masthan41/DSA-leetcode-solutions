/*
LeetCode 208 - Implement Trie (Prefix Tree)
Approach: Use a Trie data structure with Node class
Time Complexity: O(n) for insert, search, and startsWith operations where n is the length of the word
Space Complexity: O(N * M) where N is the number of words and M is the average length of each word
*/

class LC208_ImplementTrie {
    class Node {
        Node[] children;
        boolean eow;

        Node() {
            children = new Node[26];
            eow = false;
        }
    }

    private Node root;

    public LC208_ImplementTrie() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public boolean search(String word) {
        Node curr = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return curr.eow;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for (int i = 0; i < prefix.length(); i++) {
            int idx = prefix.charAt(i) - 'a';
            if (curr.children[idx] == null) {
                return false;
            }
            curr = curr.children[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        LC208_ImplementTrie solution = new LC208_ImplementTrie();
        solution.insert("apple");
        System.out.println(solution.search("apple")); // Output: true
        System.out.println(solution.search("app")); // Output: false
        System.out.println(solution.startsWith("app")); // Output: true
        solution.insert("app");
        System.out.println(solution.search("app")); // Output: true
    }
}