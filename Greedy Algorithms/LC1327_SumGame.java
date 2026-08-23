class LC1327_SumGame {
    public boolean sumGame(String num) {
        int n = num.length();
        int leftKnownSum = 0, rightKnowmSum = 0;
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
                    rightKnowmSum += num.charAt(i) - '0';
                }
            }
        }

        if ((leftQuestionMarks + rightQuestionMarks) % 2 != 0) {
            return true;
        }

        int LEFT = 2 * leftKnownSum + 9 * leftQuestionMarks;
        int RIGHT = 2 * rightKnowmSum + 9 * rightQuestionMarks;

        if (LEFT == RIGHT) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        LC1327_SumGame solution = new LC1327_SumGame();
        String num = "25??";
        boolean result = solution.sumGame(num);
        System.out.println("Result: " + result); // Output: Result: true
    }
}
