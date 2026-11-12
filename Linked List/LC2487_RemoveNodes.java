/*
LeetCode 2487 - Remove Nodes From Linked List
Approach: Reverse the linked list, then remove nodes that are smaller than the maximum value seen so far from the left. Finally, reverse the list again to get the desired result.

Time Complexity: O(n) as we visit each node exactly once, where n is the number of nodes in the linked list.
Space Complexity: O(1) as we use a constant amount of extra space for the pointers.
*/

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class LC2487_RemoveNodes {
    public ListNode reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);

        ListNode curr = head;
        int max = curr.val;
        while (curr.next != null) {
            if (curr.next.val < max) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
                max = curr.val;
            }
        }
        return reverseList(head);
    }

    public static void main(String[] args) {
        LC2487_RemoveNodes solution = new LC2487_RemoveNodes();
        ListNode head = new ListNode(5);
        head.next = new ListNode(2);
        head.next.next = new ListNode(13);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(8);

        ListNode result = solution.removeNodes(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
