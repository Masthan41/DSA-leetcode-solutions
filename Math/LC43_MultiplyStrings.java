/* LeetCode 43 - Multiply Strings
Approach: Simulate manual multiplication using an integer array of size n + m, multiply digits from right to left, place results at i + j + 1 and handle carry at i + j, then build the final string skipping leading zeros.
Time Complexity: O(n * m)
Space Complexity: O(n + m)
*/

class LC43_MultiplyStrings{
    public String multiply(String n, String m) {
        int res[] = new int[n.length() + m.length()];
        if (n.equals("0") || m.equals("0"))
            return "0";
        for (int i = n.length() - 1; i >= 0; i--) {
            for (int j = m.length() - 1; j >= 0; j--) {
                int dig1 = n.charAt(i) - '0';
                int dig2 = m.charAt(j) - '0';

                int mul = dig1 * dig2;
                int sum = mul + res[1 + i + j];

                res[1 + i + j] = sum % 10;
                res[i + j] += sum / 10;

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : res) {
            if (!(sb.length() == 0 && num == 0)) {
                sb.append(num);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        LC43_MultiplyStrings solution = new LC43_MultiplyStrings();
        String num1 = "123";
        String num2 = "456";
        String result = solution.multiply(num1, num2);
        System.out.println("Product: " + result);
    }
}