/*
Leetcode 709: To Lower Case
Approach: Convert each uppercase character to lowercase without using built-in functions
Time Complexity: O(n) - where n is the length of the string
Space Complexity: O(n) - we are using a StringBuilder to store the result
*/

class LC709_toLowerCase {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                ch = (char) (ch + 32);
                sb.append(ch);
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LC709_toLowerCase obj = new LC709_toLowerCase();
        System.out.println(obj.toLowerCase("Hello")); // "hello"
        System.out.println(obj.toLowerCase("here")); // "here"
        System.out.println(obj.toLowerCase("LOVELY")); // "lovely"
    }
}
