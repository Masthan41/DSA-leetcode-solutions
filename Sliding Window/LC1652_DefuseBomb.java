/*
LeetCode 1652 - Defuse the Bomb
Approach: Sliding Window with two pointers
Time Complexity: O(n) for iterating through the array once
Space Complexity: O(n) for the output array
*/

class LC1652_DefuseBomb {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int ans[] = new int[n];

        if (k == 0)
            return ans;

        int left, right;
        if (k > 0) {
            left = 1;
            right = k;
        } else {
            left = n + k;
            right = n - 1;
        }
        int sum = 0;

        for (int i = left; i <= right; i++) {
            sum += code[i % n];
        }

        for (int i = 0; i < n; i++) {
            ans[i] = sum;

            sum -= code[left % n];
            left++;

            right++;
            sum += code[right % n];
        }
        return ans;
    }

    public static void main(String[] args) {
        LC1652_DefuseBomb ob = new LC1652_DefuseBomb();
        int code[] = { 5, 7, 1, 4 };
        int k = 3;
        int ans[] = ob.decrypt(code, k);
        for (int i : ans) {
            System.out.print(i + " ");
        }
    }
}