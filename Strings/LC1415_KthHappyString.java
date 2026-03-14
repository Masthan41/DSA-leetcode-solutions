/*
LeetCode 1415 - kth lexicographically smallest happy string of length n
Approach: Backtracking and counting the number of happy strings generated until we reach the k-th one.

Time complexity: O(2^n) - In the worst case, we may generate all possible happy strings of length n.
Space complexity: O(n) - The space used by the recursion stack and the current string being built.
*/

class LC1415_KthHappyString {
    public void solve(int n, StringBuilder curr, int count[], int k, String res[]) {
        if (curr.length() == n) {
            count[0]++;
            if (count[0] == k) {
                res[0] = curr.toString(); // Store only the k-th string
            }
            return;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (curr.length() > 0 && curr.charAt(curr.length() - 1) == ch) {
                continue;
            }
            // Backtracking
            curr.append(ch);

            solve(n, curr, count, k, res);

            if (!res[0].isEmpty())
                return;

            curr.deleteCharAt(curr.length() - 1);
        }
    }

    public String getHappyString(int n, int k) {
        StringBuilder curr = new StringBuilder();
        String res[] = { "" };
        int count[] = { 0 };

        solve(n, curr, count, k, res);

        return res[0];
    }

    public static void main(String[] args) {
        LC1415_KthHappyString obj = new LC1415_KthHappyString();
        int n = 3, k = 9;
        String ans = obj.getHappyString(n, k);
        System.out.println(ans); // Output: "cab"
    }
}
