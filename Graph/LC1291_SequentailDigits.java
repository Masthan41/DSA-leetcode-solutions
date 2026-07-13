/*
LeetCode 1291 - Sequential Digits
Approach: Use BFS to generate all possible sequential digits and check if they fall within the given range.
Time Complexity: O(1) - Since there are only a limited number of sequential digits
Space Complexity: O(1) - For storing the result list
*/

import java.util.*;

class LC1291_SequentailDigits {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        for (int i = 1; i <= 8; i++) {
            que.add(i);
        }

        while (!que.isEmpty()) {
            int temp = que.poll();

            if (temp >= low && temp <= high) {
                list.add(temp);
            }

            int lastDigit = temp % 10;
            if (lastDigit + 1 <= 9) {
                que.add(temp * 10 + (lastDigit + 1));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LC1291_SequentailDigits obj = new LC1291_SequentailDigits();
        System.out.println(obj.sequentialDigits(100, 300));
    }
}
