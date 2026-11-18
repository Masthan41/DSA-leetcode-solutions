/*
LeetCode 2914 - Minimum Number of Changes to Make Binary String beautiful
Approach: We iterate through the string and count consecutive characters. If we encounter a different character, we check if the count of the previous character is even or odd. If it's odd, we need to make a change to ensure that no two adjacent characters are the same. We keep track of the number of changes needed.

Time Complexity: O(n) because we iterate through the string once
Space Complexity: O(1) because we use a constant amount of space for variables
*/

class LC2914_MinNoOfChanges {
    public int minChanges(String s) {
        int n = s.length();
        char ch = s.charAt(0);

        int count = 0, changes = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ch) {
                count++;
                continue;
            }

            if (count % 2 == 0) {
                count = 1;
            } else {
                changes += 1;
                count = 0;
            }
            ch = s.charAt(i);
        }
        return changes;
    }

    public static void main(String[] args) {
        LC2914_MinNoOfChanges solution = new LC2914_MinNoOfChanges();
        String s = "aaabbb";
        int result = solution.minChanges(s);
        System.out.println("Minimum number of changes: " + result);
    }
}
