/*
Leetcode 3120 - Number of Special Characters in a String
Appraoch : To count the number of special characters in a string, we can use two boolean arrays to track the presence of uppercase and lowercase letters. We iterate through the string and mark the presence of each character in the respective array. Finally, we count how many characters are present in both arrays, which indicates that they are special characters.
Time Complexity: O(n) for iterating through the string.
Space Complexity: O(1) for the boolean arrays, as they have a fixed size of 26.
*/

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