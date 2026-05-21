/*
LeetCode 3043 - Length of longest common prefix
Approach: Build a Trie from the first array of numbers and then search for the longest common prefix for each number in the second array
Time Complexity: O(N * M) where N is the number of elements in arr1 and M is the average number of digits in each number
Space Complexity: O(N * M) for the Trie
*/

class TrieNode {
    TrieNode children[] = new TrieNode[10]; // 0, 1, 2...9
}

class LC3043_LongestCommonPrefix {
    public TrieNode getTrieNode() {
        return new TrieNode();
    }

    public void insert(int num, TrieNode root) {
        TrieNode crawl = root;
        String numStr = Integer.toString(num);

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';
            if (crawl.children[idx] == null) {
                crawl.children[idx] = getTrieNode();
            }
            crawl = crawl.children[idx];
        }
    }

    // Returns the length of the longest prefix
    public int search(int num, TrieNode root) {
        TrieNode crawl = root;
        String numStr = Integer.toString(num);
        int length = 0;

        for (char ch : numStr.toCharArray()) {
            int idx = ch - '0';
            if (crawl.children[idx] != null) {
                length++;
                crawl = crawl.children[idx];
            } else {
                break;
            }
        }

        return length;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        TrieNode root = getTrieNode(); // TRIE

        // Insert all elements of arr1 into the trie
        for (int num : arr1) {
            insert(num, root);
        }

        int result = 0;
        // Search for the longest common prefix in arr2
        for (int num : arr2) {
            result = Math.max(result, search(num, root));
        }
        return result;
    }

    public static void main(String[] args) {
        LC3043_LongestCommonPrefix solution = new LC3043_LongestCommonPrefix();
        int[] arr1 = { 123, 124, 125 };
        int[] arr2 = { 1234, 1245, 126 };
        int result = solution.longestCommonPrefix(arr1, arr2);
        System.out.println(result); // Output: 3 (common prefix is "123")
    }
}