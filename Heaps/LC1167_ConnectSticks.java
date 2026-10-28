import java.util.PriorityQueue;

public class LC1167_ConnectSticks {

    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int stick : sticks) {
            pq.add(stick);
        }

        int cost = 0;

        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();

            int sum = first + second;
            cost += sum;

            pq.add(sum);
        }

        return cost;
    }

    public static void main(String[] args) {
        LC1167_ConnectSticks sol = new LC1167_ConnectSticks();

        // Test 1: Single stick
        System.out.println(sol.connectSticks(new int[] { 5 }));
        // Expected: 0

        // Test 2: Two sticks
        System.out.println(sol.connectSticks(new int[] { 7, 7 }));
        // Expected: 14

        // Test 3: Unsorted input
        System.out.println(sol.connectSticks(new int[] { 2, 4, 3 }));
        // Expected: 14

        // Test 4: Already sorted input
        System.out.println(sol.connectSticks(new int[] { 1, 2, 3, 4, 5 }));
        // Expected: 33

        // Test 5: Reverse sorted input
        System.out.println(sol.connectSticks(new int[] { 5, 4, 3, 2, 1 }));
        // Expected: 33

        // Test 6: All equal lengths
        System.out.println(sol.connectSticks(new int[] { 10, 10, 10 }));
        // Expected: 50

        // Test 7: Contains a zero
        System.out.println(sol.connectSticks(new int[] { 0, 2, 3 }));
        // Expected: 5

        // Test 8: One very large stick and small sticks
        System.out.println(sol.connectSticks(new int[] { 1, 2, 100 }));
        // Expected: 106

        // Test 9: Many sticks
        System.out.println(sol.connectSticks(
                new int[] { 1, 2, 3, 4, 5, 6, 7, 8 }));
        // Expected: 88

        // Test 10: Different lengths
        System.out.println(sol.connectSticks(new int[] { 8, 4, 6, 12 }));
        // Expected: 58
    }
}