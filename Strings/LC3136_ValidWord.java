/*
Leetcode 3136 - Valid Word
Approach - Check if the word has at least 3 characters, contains at least one vowel and one consonant, and consists of only letters and digits.
Time Complexity - O(n)
Space Complexity - O(1)
*/

public class LC3136_ValidWord {
    public boolean isValid(String word) {

        if (word.length() < 3)
            return false;

        boolean hasVowel = false;
        boolean hasConsonant = false;

        for (char c : word.toCharArray()) {

            // letter or digit
            if (!Character.isLetterOrDigit(c))
                return false;

            // check vowel
            if ("aeiouAEIOU".indexOf(c) != -1)
                hasVowel = true;

            // check consonant
            else if (Character.isLetter(c))
                hasConsonant = true;
        }

        return hasVowel && hasConsonant;
    }
    public static void main(String[] args) {
        LC3136_ValidWord solution = new LC3136_ValidWord();
        String word = "hello";
        System.out.println(solution.isValid(word)); // true
    }
}
