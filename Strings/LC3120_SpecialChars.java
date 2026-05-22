class LC3120_SpecialChars {
    public int numberOfSpecialChars(String word) {
        boolean capital[] = new boolean[26];
        boolean small[] = new boolean[26];

        for (int i = 0; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i))) {
                capital[word.charAt(i) - 'A'] = true;
            } else if (Character.isLowerCase(word.charAt(i))) {
                small[word.charAt(i) - 'a'] = true;
            }
        }

        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (capital[i] && small[i]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC3120_SpecialChars solution = new LC3120_SpecialChars();
        String word = "aAbBcC";
        int result = solution.numberOfSpecialChars(word);
        System.out.println("Number of special characters: " + result);
    }
}