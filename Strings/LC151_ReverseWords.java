/*
LeetCode 151 - Reverse Words in a String
Approach: Use two pointers to iterate through the string from the end. Skip trailing spaces, then find the start of each word and append it to a StringBuilder. Finally, trim the result to remove any extra spaces.

Time Complexity: O(n) where n is the length of the input string.
Space Complexity: O(n) for the StringBuilder that holds the reversed words.
*/

class LC151_ReverseWords {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int i = s.length() - 1;
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) == ' ')
                i--;
            if (i < 0)
                break;
            int j = i;
            while (i >= 0 && s.charAt(i) != ' ')
                i--;

            sb.append(s.substring(i + 1, j + 1)).append(" ");
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        LC151_ReverseWords solution = new LC151_ReverseWords();
        String s = "  hello world  ";
        System.out.println(solution.reverseWords(s)); // Output: "world hello"
    }
}
