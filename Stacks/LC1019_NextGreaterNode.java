/*
LeetCode 1019 - Next Greater Node In Linked List
Approach: reverse the linked list and use a stack to find the next greater node for each node in the reversed list. Then reverse the result array to get the final answer.
Time complexity: O(n) as we traverse the linked list twice and use a stack for the next greater node calculation
Space complexity: O(n) as we are using a stack to store the elements, which requires a linear amount of space for the variables
*/

import java.util.*;
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
class LC1019_NextGreaterNode {
    public int[] nextLargerNodes(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        int n = 0;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            n++;
        }

        int res[] = new int[n];
        Stack<Integer> s = new Stack<>();
        int i = n - 1;

        curr = prev;
        while (curr != null) {
            while (!s.isEmpty() && s.peek() <= curr.val) {
                s.pop();
            }

            res[i] = s.isEmpty() ? 0 : s.peek();
            s.push(curr.val);

            curr = curr.next;
            i--;
        }
        return res;
    }

    public static void main(String[] a) {
        LC1019_NextGreaterNode solution = new LC1019_NextGreaterNode();
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(5);
        int[] result = solution.nextLargerNodes(head);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
