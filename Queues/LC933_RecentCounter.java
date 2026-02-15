/*
LeetCode 933 - Number of Recent Calls
Approach: Queue sliding window

Time Complexity: O(1) amortized per call
Space Complexity: O(n)
*/

import java.util.*;

class LC933_RecentCounter {
Queue<Integer> q;

    public LC933_RecentCounter() {
        q = new LinkedList<>();
    }

    public int ping(int t) {
        q.add(t);

        while (!q.isEmpty() && q.peek() < t - 3000) {
            q.remove();
        }
        return q.size();
    }
    public static void main(String[] args) {
        LC933_RecentCounter recentCounter = new LC933_RecentCounter();
        System.out.println(recentCounter.ping(1));    // returns 1
        System.out.println(recentCounter.ping(100));  // returns 2
        System.out.println(recentCounter.ping(3001)); // returns 3
        System.out.println(recentCounter.ping(3002)); // returns 3
    }
}
