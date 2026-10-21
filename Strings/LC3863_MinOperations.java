/*
Leetcode 3863 - Minimum Operations to Make the String Sorted
Approach - Check if the string is already sorted. If it is, return 0. If the length of the string is 2 and it's not sorted, return -1. Find the minimum and maximum characters in the string. If the first character is the minimum or the last character is the maximum, return 1. Otherwise, find the minimum and maximum characters in the middle of the string (excluding the first and last characters). If the first character is greater than the maximum of the middle characters and the last character is less than the minimum of the middle characters, return 3. Otherwise, return 2.

Time Complexity - O(n) where n is the length of the string.
Space Complexity - O(1) since we are using a constant amount of space.
*/

class LC3863_MinOperations {
    public int minOperations(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();

        boolean sorted = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1]) {
                sorted = false;
                break;
            }
        }
        if (sorted) {
            return 0;
        }

        if (n == 2) {
            return -1;
        }

        char minChar = arr[0];
        char maxChar = arr[0];
        for (int i = 1; i < n; i++) {
            minChar = (char) Math.min(minChar, arr[i]);
            maxChar = (char) Math.max(maxChar, arr[i]);
        }

        if (arr[0] == minChar || arr[n - 1] == maxChar) {
            return 1;
        }

        char minMid = arr[1];
        char maxMid = arr[1];
        for (int i = 2; i < n - 1; i++) {
            minMid = (char) Math.min(minMid, arr[i]);
            maxMid = (char) Math.max(maxMid, arr[i]);
        }

        if (arr[0] > maxMid && arr[n - 1] < minMid) {
            return 3;
        }
        return 2;
    }

    public static void main(String[] args) {
        LC3863_MinOperations solution = new LC3863_MinOperations();
        String s = "cba";
        int result = solution.minOperations(s);
        System.out.println("Minimum operations: " + result);
    }
}