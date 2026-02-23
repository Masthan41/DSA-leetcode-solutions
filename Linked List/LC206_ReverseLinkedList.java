/*
Leetcode - 206 : Reverse Linked list
Approach:
Iteratively reverse pointers using three nodes: prev, curr, next.
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

class LC206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void main(String[] args) {
        LC206_ReverseLinkedList solution = new LC206_ReverseLinkedList();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        ListNode result = solution.reverseList(head);

        // Print the reversed list
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output: 5 4 3 2 1
    }
}