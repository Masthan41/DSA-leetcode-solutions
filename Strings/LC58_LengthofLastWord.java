/*
LeetCode 58 - Length of Last Word
Approach: Traverse from end and count characters
Time Complexity: O(n)
Space Complexity: O(1)
*/

class LC58_LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int c = 0;
        int i = s.length() - 1;
        // skip trailing spaces
        while (i >= 0 && s.charAt(i) == ' ') {
            i--;
        }

        // count last word length
        while (i >= 0 && s.charAt(i) != ' ') {
            c++;
            i--;
        }
        return c;
    }

    public static void main(String[] args) {
        LC58_LengthOfLastWord solution = new LC58_LengthOfLastWord();
        String s = "Hello World";
        System.out.println(solution.lengthOfLastWord(s)); // Output: 5
    }
}