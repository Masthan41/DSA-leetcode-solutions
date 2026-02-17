public class LC3136_ValidWord {
    public boolean isValid(String word) {
        return word.length() >= 3 && word.chars().allMatch(Character::isLetterOrDigit) &&
                word.chars().anyMatch(c -> isVowel((char) c)) &&
                word.chars().anyMatch(c -> isConsonant((char) c));
    }

    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    private boolean isConsonant(char c) {
        return Character.isLetter(c) && !isVowel(c);
    }
    public static void main(String[] args) {
        LC3136_ValidWord solution = new LC3136_ValidWord();
        String word = "hello";
        System.out.println(solution.isValid(word)); // true
    }
}
