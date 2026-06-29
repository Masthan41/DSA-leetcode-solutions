/*
LeetCode 1967 - Number of Strings That Appear as Substrings in Word
Approach: Iterate through the patterns array and check if each pattern is a substring of the word.
Time Complexity: O(m * n) where m is the number of patterns and n is the length of the word, since we check each pattern against the word.
Space Complexity: O(1) since we are only using a constant amount of extra space.
*/

class LC1967_NoOfStrings {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String str : patterns) {
            if (word.contains(str)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC1967_NoOfStrings solution = new LC1967_NoOfStrings();
        String[] patterns = { "a", "abc", "bc", "d" };
        String word = "abc";
        int result = solution.numOfStrings(patterns, word);
        System.out.println("Number of Strings: " + result);
    }
}
