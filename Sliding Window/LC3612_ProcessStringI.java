/*
LeetCode 3612 - Process String with special operations I
Approach: Use a StringBuilder to build the resulting string while iterating through the input string. Handle each character based on the specified operations.
Time Complexity: O(n) where n is the length of the input string s.
Space Complexity: O(n) for the StringBuilder (where n is the length of the input string s)
*/

class LC3612_ProcessStringI {
    public String processStr(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                sb.append(ch);
            } else if (ch == '*') {
                if (sb.length() >= 1) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else if (ch == '#') {
                sb.append(sb);
            } else {
                sb.reverse();
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC3612_ProcessStringI solution = new LC3612_ProcessStringI();
        String s = "abc*de#f";
        String result = solution.processStr(s);
        System.out.println("Processed string: " + result); // Output: Processed string
    }
}
