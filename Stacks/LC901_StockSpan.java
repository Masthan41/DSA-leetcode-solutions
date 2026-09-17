/*
LeetCode 901 - Online Stock Span
Approach: Use a stack and a pair of price and span in this just calculate the span and return it.
Time complexity: O(n) as each element is pushed and popped from the stack at most once.
Space complexity: O(n) as we are using a stack and 2 length of fixed array.
*/
import java.util.*;

class LC901_StockSpan {
    Stack<int[]> s;

    public LC901_StockSpan() {
        s = new Stack<>();
    }

    public int next(int price) {
        int span = 1;

        while (!s.isEmpty() && s.peek()[0] <= price) {
            span += s.peek()[1];
            s.pop();
        }
        s.push(new int[] { price, span });
        return span;
    }

    public static void main(String[] a) {
        LC901_StockSpan obj = new LC901_StockSpan();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}