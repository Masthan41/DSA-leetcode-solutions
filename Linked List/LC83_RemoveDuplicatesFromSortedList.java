/*
LeetCode 83 - Remove Duplicates from Sorted List
Approach: Traverse list and skip duplicate nodes
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

class LC83_RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode curr = head;

        while (curr != null && curr.next != null) {

            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }

        return head;
    }
    public static void main(String[] args) {
        LC83_RemoveDuplicatesFromSortedList solution = new LC83_RemoveDuplicatesFromSortedList();

        ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));

        ListNode result = solution.deleteDuplicates(head);

        // Print the result
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
        // Output: 1 2 3
    }
}
