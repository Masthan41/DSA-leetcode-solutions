import java.util.*;

class LC907_SumOfMinimums {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        // Find the index of the next smaller element to the left (NSL)
        Stack<Integer> left = new Stack<>();
        int NSL[] = new int[n];
        for (int i = 0; i < n; i++) {
            while (!left.isEmpty() && arr[left.peek()] >= arr[i]) {
                left.pop();
            }
            NSL[i] = left.isEmpty() ? -1 : left.peek();
            left.push(i);
        }
        
        // Find the index of the next smaller element to the right (NSR)
        Stack<Integer> right = new Stack<>();
        int NSR[] = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while (!right.isEmpty() && arr[right.peek()] > arr[i]) {
                right.pop();
            }
            NSR[i] = right.isEmpty() ? n : right.peek();
            right.push(i);
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            long ls = i - NSL[i];
            long rs = NSR[i] - i;

            long totalWays = ls * rs;

            long totalSum = arr[i] * totalWays;

            sum = (sum + totalSum) % 1000000007;
        }
        return (int) sum;
    }

    public static void main(String[] a) {
        LC907_SumOfMinimums obj = new LC907_SumOfMinimums();
        int[] arr = { 5, 4, 3, 2, 1 };
        System.out.println(obj.sumSubarrayMins(arr));
    }
}
