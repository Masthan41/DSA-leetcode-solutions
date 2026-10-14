class LC3723_MaximizeSum {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > num * 9) {
            return "";
        }

        int nines = sum / 9;
        int rem = sum % 9;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nines; i++) {
            sb.append('9');
        }
        if (rem > 0) {
            sb.append((char) (rem + '0'));
        }

        while (sb.length() < num) {
            sb.append('0');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC3723_MaximizeSum solution = new LC3723_MaximizeSum();
        System.out.println(solution.maxSumOfSquares(3, 20)); // Output: "992"
        System.out.println(solution.maxSumOfSquares(2, 18)); // Output: "99"
        System.out.println(solution.maxSumOfSquares(4, 36)); // Output: "9999"
        System.out.println(solution.maxSumOfSquares(5, 45)); // Output: "99999"
        System.out.println(solution.maxSumOfSquares(3, 30)); // Output: ""
    }
}
