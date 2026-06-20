/*
LeetCode 344 - Reverse String
Approach: Use two pointers to swap characters from both ends towards the center.
Time Complexity: O(n) where n is the length of the string.
Space Complexity: O(1) as we modify the array in place.
*/

class LC344_ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left <= right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        LC344_ReverseString solution = new LC344_ReverseString();
        char[] s = { 'h', 'e', 'l', 'l', 'o' };
        solution.reverseString(s);
        System.out.println(s); // Output: "olleh"
    }
}
