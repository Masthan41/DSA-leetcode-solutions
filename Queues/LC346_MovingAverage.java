/*
LeetCode 346 - Moving Average from Data Stream
Approach: Queue sliding window

Time Complexity: O(1)
Space Complexity: O(size)
*/

import java.util.*;

public class LC346_MovingAverage {
    Queue<Integer> q = new LinkedList<>();
    int size;
    double sum;

    public LC346_MovingAverage(int size) {
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        sum += val;
        q.add(val);

        // remove oldest element if the size of the queue exceeds the window size
        if (q.size() > size) {
            sum -= q.remove();
        }
        return sum / q.size();
    }

    public static void main(String[] args) {
        LC346_MovingAverage m = new LC346_MovingAverage(4);
        System.out.println(m.next(1)); // 1.0
        System.out.println(m.next(10)); // (1 + 10) / 2 = 5.5
        System.out.println(m.next(3)); // (1 + 10 + 3) / 3 = 4.66667
        System.out.println(m.next(5)); // (1 + 10 + 3 + 5) / 4 = 4.75
        System.out.println(m.next(8)); // (10 + 3 + 5 + 8) / 4 = 5.5
    }
}
