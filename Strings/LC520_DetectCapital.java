/*
Leetcode 520: Detect Capital
Approach: Count the number of uppercase letters and check the conditions
Time Complexity: O(n) - where n is the length of the word
Space Complexity: O(1) - we are using a constant amount of space to track the count
*/

class LC520_DetectCapital {
    public boolean detectCapitalUse(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isUpperCase(ch)) {
                count++;
            }
        }
        return (count == word.length() || (count == 1 && Character.isUpperCase(word.charAt(0))) || count == 0);
    }

    public static void main(String[] args) {
        LC520_DetectCapital obj = new LC520_DetectCapital();
        System.out.println(obj.detectCapitalUse("USA")); // true
        System.out.println(obj.detectCapitalUse("leetcode")); // true
        System.out.println(obj.detectCapitalUse("Google")); // true
        System.out.println(obj.detectCapitalUse("FlaG")); // false
    }
}