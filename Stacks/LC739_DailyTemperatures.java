import java.util.*;

public class LC739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = s.peek() - i;
            }

            s.push(i);
        }
        return ans;
    }
}
