/*
LeetCode 232 - Implement Queue using Stacks
Approach: Two stacks (input and output)
Time Complexity:
push  -> O(1)
pop   -> O(1) amortized
peek  -> O(1) amortized
empty -> O(1)

Space Complexity: O(n)
*/

import java.util.*;

class LC232_QueueFromStacks {

    Stack<Integer> input;
    Stack<Integer> output;

    public LC232_QueueFromStacks() {
        input = new Stack<>();
        output = new Stack<>();
    }

    // push element to back of queue
    public void push(int x) {
        input.push(x);
    }

    // removes front element
    public int pop() {

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.pop();
    }

    // get front element
    public int peek() {

        if (output.isEmpty()) {
            while (!input.isEmpty()) {
                output.push(input.pop());
            }
        }

        return output.peek();
    }

    // check if empty
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
    public static void main(String[] args) {
        LC232_QueueFromStacks queue = new LC232_QueueFromStacks();
        queue.push(1);
        queue.push(2);
        System.out.println(queue.peek());  // returns 1
        System.out.println(queue.pop());   // returns 1
        System.out.println(queue.empty()); // returns false
    }
}
