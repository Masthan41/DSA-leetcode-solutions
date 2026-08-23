/*
LeetCode 1927 - Sum Game
Approach : Use a Greedy approach how many questions marks are there and what is the known sum on both sides. After that use math derivation to solve the problem further
Time Complexity: O(n) as we iterate over the string only once
Space Complexity: O(1) as we use only varaibles
*/


class LC1927_SumGame {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftKnownSum = 0, rightKnownSum = 0;
        int leftQuestionMarks = 0, rightQuestionMarks = 0;

        for (int i = 0; i < n; i++) {
            if (num.charAt(i) == '?') {
                if (i < n / 2) {
                    leftQuestionMarks++;
                } else {
                    rightQuestionMarks++;
                }
            } else {
                if (i < n / 2) {
                    leftKnownSum += num.charAt(i) - '0';
                } else {
                    rightKnownSum += num.charAt(i) - '0';
                }
            }
        }

        if ((leftQuestionMarks + rightQuestionMarks) % 2 != 0) {
            return true;
        }

        int LEFT = 2 * leftKnownSum + 9 * leftQuestionMarks;
        int RIGHT = 2 * rightKnownSum + 9 * rightQuestionMarks;

        if (LEFT == RIGHT) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LC1927_SumGame solution = new LC1927_SumGame();
        String num = "25??";
        boolean result = solution.sumGame(num);
        System.out.println("Result: " + result); // Output: Result: true
    }
}
