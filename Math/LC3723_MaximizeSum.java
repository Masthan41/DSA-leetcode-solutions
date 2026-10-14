/*
LeetCode 3723 - Maximize sum of squares of digits 
Approach: To maximize the sum of squares of digits for a given number of digits `num` and a total sum `sum`, we can use a greedy approach. The idea is to fill the number with the largest possible digits starting from the leftmost position. Since the digit '9' contributes the most to the sum of squares, we will use as many '9's as possible until we reach the required sum. If there is any remaining sum after using '9's, we will place that remaining value in the next position. Finally, if there are still positions left, we will fill them with '0's.

Time Complexity: O(num) where num is the number of digits, as we need to construct
Space Complexity: O(num) where num is the number of digits, as we need to store the resulting string.
*/

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
