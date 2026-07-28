/*
LeetCode 3517 - Smallest Palindromic Rearrangement I
Approach: Sort the characters in ascending order. Iterate through the sorted array and check if the current character is less than the character at the corresponding position from the end. If it is, return false. If the character is greater than or equal to 1e5, return true (since we won't encounter any larger characters). Otherwise, add the character's mass to the current mass and continue iterating.

Time complexity: O(n log n) due to sorting the characters array.
Space complexity: O(n) since we are using a new array to store the sorted characters.
*/

import java.util.*;

class LC3517_SmallestRearrangementI {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int mid = n / 2;

        char arr[] = s.toCharArray();
        Arrays.sort(arr, 0, mid);

        for (int i = 0; i < mid; i++) {
            arr[n - 1 - i] = arr[i];
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        LC3517_SmallestRearrangementI solution = new LC3517_SmallestRearrangementI();
        String s = "bca";
        String result = solution.smallestPalindrome(s);
        System.out.println(result);
    }
}