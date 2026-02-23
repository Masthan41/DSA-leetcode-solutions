/*
Leetcode - 234 : Palindromic Linked List
Approach:
1. Find end of first half using slow & fast pointers.
2. Reverse second half.
3. Compare both halves.

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

class LC234_PalindromeLinkedList {

    // find mid
    public ListNode findMid (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // find mid
        ListNode mid = findMid(head);

        // reverse the 2nd half
        ListNode prev = null;
        ListNode curr = mid.next;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        ListNode right = prev;
        ListNode left = head;

        // check left == right
        while (right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }
    public static void main(String[] args) {
        LC234_PalindromeLinkedList solution = new LC234_PalindromeLinkedList();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));

        System.out.println(solution.isPalindrome(head)); // Output: true
    }
}
