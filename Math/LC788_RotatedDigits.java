class LC788_RotatedDigits {
    private boolean isGood(int num) {
        boolean changed = false;

        while (num > 0) {
            int digit = num % 10;

            if (digit == 3 || digit == 4 || digit == 7)
                return false;
            if (digit == 2 || digit == 5 || digit == 6 || digit == 9)
                changed = true;

            num /= 10;
        }
        return changed;
    }

    public int rotatedDigits(int n) {
        int count = 0;

        for (int i = 1; i <= n; i++) {
            if (isGood(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC788_RotatedDigits solution = new LC788_RotatedDigits();
        int n = 10;
        int result = solution.rotatedDigits(n);
        System.out.println("Number of good integers from 1 to " + n + ": " + result);
    }
}
