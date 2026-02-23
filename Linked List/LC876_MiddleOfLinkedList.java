/*
Leetcode - 876 : Mid of Linked List
Approach:
Use slow and fast pointers.
Slow moves 1 step, fast moves 2 steps.
When fast reaches the end, slow will be at the middle.
For even length, this returns the second middle.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class ListNode {
    int val;
    ListNode next;

    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class LC876_MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }
    public static void main(String[] args) {
        LC876_MiddleOfLinkedList solution = new LC876_MiddleOfLinkedList();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode middle = solution.middleNode(head);
        System.out.println(middle.val); // Output: 3
    }
}
