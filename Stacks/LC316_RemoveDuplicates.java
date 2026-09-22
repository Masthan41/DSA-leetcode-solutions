/*
LeetCode 316 - Remove Duplicate Letters
Approach: Using a stack to maintain the result. For each character, if it's already in the result, we skip it. Otherwise, we pop characters from the stack if they are greater than the current character and will appear later in the string.
Time complexity: O(n) as each element is pushed and popped from the stack at most once.
Space complexity: O(n) as we are using a stack and additional arrays to store the last occurrence of each character.
*/

//this question is same as leetcode 1081 - Smallest Subsequence of Distinct Characters
import java.util.Stack;

class LC316_RemoveDuplicates {
    public String removeDuplicateLetters(String str) {
        int n = str.length();
        Stack<Character> s = new Stack<>();

        int last[] = new int[26];
        boolean taken[] = new boolean[26];

        for (int i = 0; i < n; i++) {
            last[str.charAt(i) - 'a'] = i;
        }

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            int idx = ch - 'a';

            if (taken[idx])
                continue;

            while (!s.isEmpty() && ch < s.peek() && last[s.peek() - 'a'] > i) {
                taken[s.pop() - 'a'] = false;
            }
            s.push(ch);
            taken[idx] = true;
        }

        StringBuilder sb = new StringBuilder();
        while (!s.isEmpty()) {
            sb.append(s.pop());
        }
        return sb.reverse().toString();
    }

    public static void mian(String[] a) {
        LC316_RemoveDuplicates obj = new LC316_RemoveDuplicates();
        String str = "bcabc";
        String result = obj.removeDuplicateLetters(str);
        System.out.println(result);
    }
}
