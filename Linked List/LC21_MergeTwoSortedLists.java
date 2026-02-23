/*
Leetcode - 21 : Merge Two sorted linked lists
Approach:
Use a dummy node to build the merged list.
Compare nodes from both lists and attach the smaller one.
Move pointers accordingly.
Finally, attach the remaining part of the non-empty list.

Time Complexity: O(n + m)
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

class LC21_MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }

        temp.next = (list1 != null) ? list1 : list2;

        return dummy.next;
    }
    public static void main(String[] args) {
        LC21_MergeTwoSortedLists solution = new LC21_MergeTwoSortedLists();

        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // Print the merged list
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
        // Output: 1 1 2 3 4 4
    }
}
