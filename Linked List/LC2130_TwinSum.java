/*
Leetcode - 2130 : Maximum Twin Sum of a Linked List
Approach: Use the fast and slow pointer technique to find the middle of the linked list. Then reverse the second half of the linked list. Finally, iterate through both halves of the linked list simultaneously to calculate the twin sums and keep track of the maximum twin sum.
Time Complexity: O(n) as we traverse the linked list a few times (finding the middle, reversing the second half, and calculating twin sums).
Space Complexity: O(1) for the pointers used in reversing the second half.
*/

import java.util.*;

class ListNode {
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
        ListNode mid = null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        mid = slow;

        //reverse the second half
        ListNode nextNode = null;
        ListNode prev = null;

        while (mid != null) {
            nextNode = mid.next;
            mid.next = prev;
            prev = mid;
            mid = nextNode;
        }

        ListNode curr = head;
        int result = 0;
        while (prev != null) {
            result = Math.max(result, (curr.val + prev.val));
            curr = curr.next;
            prev = prev.next;
        }
        return result;
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
