/* LeetCode 3751 - Total Waviness
Approach: Check Each Digit for Waviness using a Helper Function. We can define a helper function that calculates the waviness of a single number by checking each digit (except the first and last) to see if it is greater than both its neighbors or less than both its neighbors. Then, we can iterate through all numbers from num1 to num2 and sum up their waviness.
Time Complexity: O(n * d) where n is the number of integers between num1 and num2, and d is the number of digits in the largest number (which is at most 10 for 32-bit integers).
Space Complexity: O(1) as we only use a constant amount of extra space for the helper function and the main function.
*/

class LC_3751TotalWaviness {
    private int waviness(int x) {
        if (x < 100) {
            return 0;
        }
        String s = String.valueOf(x);
        int count = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            int left = s.charAt(i - 1) - '0';
            int curr = s.charAt(i) - '0';
            int right = s.charAt(i + 1) - '0';

            if ((curr > left && curr > right) || (curr < left && curr < right)) {
                count++;
            }
        }
        return count;
    }

    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for (int i = num1; i <= num2; i++) {
            ans += waviness(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC_3751TotalWaviness obj = new LC_3751TotalWaviness();
        int num1 = 100, num2 = 200;
        int res = obj.totalWaviness(num1, num2);
        System.out.println(res);
    }
}
