/* 
67. Add Binary 
Approach: Simulate binary addition from right to left
Time Complexity: O(max(m, n)) where m and n are the lengths of the input strings
Space Complexity: O(max(m, n)) for the result string
*/

public class LC67_AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder res = new StringBuilder();

        int i = a.length() - 1;
        int j = b.length() - 1;
        int ca = 0;

        while (i >= 0 || j >= 0 || ca != 0) {
            int sum = ca;
            if (i >= 0) {
                sum += a.charAt(i) - '0';
                i--;
            }
            if (j >= 0) {
                sum += b.charAt(j) - '0';
                j--;
            }
            res.append(sum % 2);
            ca = sum / 2;
        }
        return res.reverse().toString();
    }
}
