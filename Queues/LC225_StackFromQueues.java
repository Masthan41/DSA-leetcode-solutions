/*
LeetCode 225 - Implement Stack using Queues
Approach: Single Queue Rotation

Time Complexity:
push  -> O(n)
pop   -> O(1)
top   -> O(1)
empty -> O(1)

Space Complexity: O(n)
*/

import java.util.*;

class LC225_StackFromQueues {

    Queue<Integer> q;

    public LC225_StackFromQueues() {
        q = new LinkedList<>();
    }

    public void push(int x) {

        q.add(x);

        // rotate queue
        for (int i = 0; i < q.size() - 1; i++) {
            q.add(q.remove());
        }
    }

    public int pop() {
        return q.remove();
    }

    public int top() {
        return q.peek();
    }

    public boolean empty() {
        return q.isEmpty();
    }
    public static void main(String[] args) {
        LC225_StackFromQueues stack = new LC225_StackFromQueues();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.top());   // returns 2
        System.out.println(stack.pop());   // returns 2
        System.out.println(stack.empty()); // returns false
    }
}
