/*
LeetCode 345 - Reverse Vowels of a String
Approach: Use two pointers to identify and swap vowels from both ends towards the center.
Time Complexity: O(n) where n is the length of the string.
Space Complexity: O(n) for the character array.
*/

class LC345_ReverseVowels {
    private boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }

    public String reverseVowels(String s) {
        char arr[] = s.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            if (!isVowel(arr[left])) {
                left++;
            } else if (!isVowel(arr[right])) {
                right--;
            } else {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;

                left++;
                right--;
            }
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        LC345_ReverseVowels solution = new LC345_ReverseVowels();
        String input = "hello";
        String output = solution.reverseVowels(input);
        System.out.println(output); // Output: "holle"
    }
}
