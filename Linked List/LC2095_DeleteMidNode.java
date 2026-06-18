/*
Leetcode - 2095 : Delete mid of a linked list
Approach: Traverse the linkedlist to find the middle node using the fast and slow pointer technique. Once the middle node is found, update the next pointer of the previous node to skip the middle node, effectively deleting it from the linked list.
Time Complexity: O(n) as we traverse the linked list once to find the middle node.
Space Complexity: O(1) for the pointers used in the algorithm.
*/

class ListNode {
   int val;
   ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class LC2095_DeleteMidNode {
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;

        return head;
    }
    public static void main(String[] args){
        LC2095_DeleteMidNode solution = new LC2095_DeleteMidNode();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        
        System.out.print(head.val+" -> "); // Output: 1
        System.out.print(head.next.val+" -> "); // Output: 2
        System.out.print(head.next.next.val+" -> "); // Output: 4
        System.out.print(head.next.next.next.val); // Output: 5
    }
}
