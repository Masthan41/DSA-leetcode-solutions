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
