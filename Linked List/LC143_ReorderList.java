/*
Leetcode - 143 : Reorder Linked list (zig zag order)
Approach:
1. Find the middle of the list using slow/fast pointers.
2. Reverse the second half of the list.
3. Merge the two halves alternately (zigzag fashion).

Time Complexity: O(n)
Space Complexity: O(1)
*/

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

class LC143_ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        // Step 1: Find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode curr = slow.next;
        slow.next = null;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Step 3: Merge zigzag
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode next1 = first.next;
            ListNode next2 = second.next;

            first.next = second;
            second.next = next1;

            first = next1;
            second = next2;
        }
    }

    public static void main(String[] args) {
        LC143_ReorderList solution = new LC143_ReorderList();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));

        solution.reorderList(head);

        // Print the result
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        // Output: 1 4 2 3
    }
}
