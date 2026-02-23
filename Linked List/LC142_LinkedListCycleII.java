/*
Leetcode - 142 : Linked list Cycle 2
Approach:
1. Detect cycle using slow & fast pointers.
2. After meeting, place one pointer at head.
3. Move both one step; meeting point is cycle start.

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

class LC142_LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LC142_LinkedListCycleII solution = new LC142_LinkedListCycleII();

        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        head.next = node2;
        node2.next = node0;
        node0.next = node4;
        node4.next = node2; // Creates a cycle

        ListNode cycleStart = solution.detectCycle(head);
        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val); // Output: 2
        } else {
            System.out.println("No cycle detected.");
        }
    }
}
