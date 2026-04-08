/*
LeetCode 1299 - Replace Elements with Greatest Element to Their Right
Approach: Iterate from right to left, keeping track of the maximum element seen so far
Time complexity: O(n) where n is the length of the array
Space complexity: O(1) for the in-place modification
*/

class LC1299_ReplaceElements {
    public int[] replaceElements(int[] arr) {
        int maxR = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            int curr = arr[i];
            arr[i] = maxR;
            maxR = Math.max(maxR, curr);
        }
        return arr;
    }

    public static void main(String[] args) {
        LC1299_ReplaceElements solution = new LC1299_ReplaceElements();
        int[] arr = { 17, 18, 5, 4, 6, 1 };
        System.out.println(solution.replaceElements(arr)); // Output: [18, 6, 6, 6, 1, -1]
    }
}
