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

public class LC2058_MinAndMax {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head;
        ListNode curr = head.next;
        int i = 1;
        int prevPos = 0;
        int firstPos = 0;

        int minDist = Integer.MAX_VALUE;

        while (curr.next != null) {
            if ((curr.val > prev.val && curr.val > curr.next.val)
                    || (curr.val < prev.val && curr.val < curr.next.val)) {

                if (prevPos == 0) {
                    prevPos = i;
                    firstPos = i;
                } else {
                    minDist = Math.min(minDist, i - prevPos);
                    prevPos = i;
                }
            }
            i++;
            prev = curr;
            curr = curr.next;
        }
        return minDist == Integer.MAX_VALUE ? new int[] { -1, -1 } : new int[] { minDist, prevPos - firstPos };
    }

    public static void main(String[] a) {
        LC2058_MinAndMax solution = new LC2058_MinAndMax();
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        int[] result = solution.nodesBetweenCriticalPoints(head);
        System.out.println(result[0] + " " + result[1]); // Output: 3 4
    }
}
