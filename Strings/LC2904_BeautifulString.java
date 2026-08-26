/*
LeetCode 2904 - Length of lexicographically smallest beautiful string
Approach: We use nested loops for checking each substring since the constraints are small
          (optimized version will be uploadled soon)
Time Complexity: O(n^2) because of nested loops
Space Complexity: O(n) beacuse of temp string creation
*/

class LC2904_BeautifulString {
    public String shortestBeautifulSubstring(String s, int k) {
        int n = s.length();

        for (int len = k; len <= n; len++) {
            String result = "";
            for (int start = 0; start + len <= n; start++) { // trying all possible substr of len
                String temp = s.substring(start, start + len); // [start ... start+len)
                int ones = 0;
                for (char ch : temp.toCharArray()) {
                    ones += (ch == '1') ? 1 : 0;
                }
                // Keep it if it's beautiful and smaller than current best.
                if (ones == k) {
                    if (result.isEmpty() || temp.compareTo(result) < 0)
                        result = temp;
                }
            }

            // if we find result of len size, then it's smallest, no need to move to len++
            if (!result.isEmpty())
                return result;
        }
        return "";
    }

    public static void main(String[] a) {
        LC2904_BeautifulString s = new LC2904_BeautifulString();
        System.out.println(s.shortestBeautifulSubstring("001101", 2));
    }
}
