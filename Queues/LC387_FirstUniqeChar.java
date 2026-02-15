/*
Leetcode 387: First Unique Character in a String
Approach: Frequency counting with queue for unique character indices
Time Complexity: O(n)
Space Complexity: O(1) - since we are only storing frequency of 26 lowercase letters and indices in queue
*/


//An alternate approach to the two-pass solution is there in Strings folder - LC387_FirstUniqChar.java, which uses a two-pass approach without a queue. Both approaches have the same time and space complexity, but the two-pass approach is simpler and more efficient in terms of space since it doesn't require a queue to store indices. The two-pass approach is generally recommended for this problem due to its simplicity and efficiency.

import java.util.*;

public class LC387_FirstUniqeChar {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'a']++;
            q.add(i);

            while (!q.isEmpty() && freq[s.charAt(q.peek()) - 'a'] > 1) {
                q.remove();
            }

        }
        if (q.isEmpty()) {
            return -1;
        }
        return q.peek();
    }
    public static void main(String[] args) {
        LC387_FirstUniqeChar solution = new LC387_FirstUniqeChar();
        System.out.println(solution.firstUniqChar("leetcode")); // Output: 0
        System.out.println(solution.firstUniqChar("loveleetcode")); // Output: 2
        System.out.println(solution.firstUniqChar("aabb")); // Output: -1
    }
}
