/*
Leetcode - 2130 : Maximum Twin Sum of a Linked List
Approach: Use a stack to store the values of the first half of the linked list. Then, iterate through the second half and calculate the sum of each twin with the corresponding value from the stack.

Time Complexity: O(n) as we traverse the linked list twice, once to push values onto the stack and once to calculate the twin sums.
Space Complexity: O(n/2) = O(n) for the stack.
*/

import java.util.*;

public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LC2130_TwinSum {
    public int pairSum(ListNode head) {
        Stack<Integer> st = new Stack<>();
        ListNode curr = head;

        while (curr != null) {
            st.push(curr.val);
            curr = curr.next;
        }

        int maxSum = Integer.MIN_VALUE;
        curr = head;
        int count = 0;
        int n = st.size();
        while (count < n / 2) {
            maxSum = Math.max(maxSum, (curr.val + st.pop()));
            curr = curr.next;
            count++;
        }
        return maxSum;
    }

    public static void main(String[] args) {
        LC2130_TwinSum solution = new LC2130_TwinSum();
        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        int result = solution.pairSum(head);
        System.out.println("Maximum twin sum: " + result); // Output: Maximum twin sum
    }
}
