/*
LeetCode 1358 - Number of Substrings Containing All Three Characters
Approach: Use a sliding window technique to count substrings that contain all three characters.
Time Complexity: O(n) where n is the length of the string.
Space Complexity: O(1) since we are only using a constant amount of extra space.
*/

class LC1358_NoOfSubstrings {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int arr[] = new int[3];
        int result = 0;

        int i = 0, j = 0;
        while (j < n) {
            char ch = s.charAt(j);
            arr[ch - 'a']++;

            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                result += (n - j);

                arr[s.charAt(i) - 'a']--;
                i++;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        LC1358_NoOfSubstrings solution = new LC1358_NoOfSubstrings();
        String s = "abcabc";
        int result = solution.numberOfSubstrings(s);
        System.out.println("Number of substrings containing all three characters: " + result);
    }
}
