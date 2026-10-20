/*
LeetCode 3886 - Sum of Sortable Integers
Approach: Use knuth-morris-pratt (KMP) algorithm to check if a subarray is a cyclic rotation of the corresponding sorted subarray. For each divisor k of n, we check if all subarrays of length k are cyclic rotations of their sorted counterparts. If they are, we add k to the result.

Time Complexity: O(n log n) for sorting the array and checking all divisors, where n is the length of the input array
Space Complexity: O(n) for storing the sorted array and auxiliary arrays used in KMP
*/

class LC3886_SumOfSortableIntegers {
    void computeLPS(int[] pattern, int[] lps) {
        int M = pattern.length;
        int len = 0;
        lps[0] = 0;

        int i = 1;
        while (i < M) {
            if (pattern[i] == pattern[len]) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
    }

    boolean search(int[] pat, int[] txt) {
        int N = txt.length;
        int M = pat.length;

        int[] lps = new int[M];
        computeLPS(pat, lps);

        int i = 0; // index for text
        int j = 0; // index for pattern

        while (i < N) {
            if (pat[j] == txt[i]) {
                i++;
                j++;
            }

            if (j == M) {
                return true; // pattern found , return true
            } else if (i < N && pat[j] != txt[i]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return false;
    }
    // KMP End

    // Is vec1 a cyclic rotation of vec2 , then, vec1 occurs in vec2+vec2
    boolean isRotation(int[] vec1, int[] vec2) {
        int[] txt = new int[vec2.length * 2];
        System.arraycopy(vec2, 0, txt, 0, vec2.length);
        System.arraycopy(vec2, 0, txt, vec2.length, vec2.length); // vec2 + vec2
        return search(vec1, txt);
    }

    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        java.util.Arrays.sort(sorted);

        int result = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0)
                continue;

            boolean valid = true;
            for (int start = 0; start < n; start += k) {
                int[] vec1 = java.util.Arrays.copyOfRange(nums, start, start + k);
                int[] vec2 = java.util.Arrays.copyOfRange(sorted, start, start + k);

                if (!isRotation(vec1, vec2)) {
                    valid = false;
                    break;
                }
            }
            if (valid)
                result += k;
        }
        return result;
    }

    public static void main(String[] args) {
        LC3886_SumOfSortableIntegers obj = new LC3886_SumOfSortableIntegers();
        // example test cases
        int[] nums1 = { 1, 2, 3, 4 };
        System.out.println(obj.sortableIntegers(nums1)); // Output: 4

        int[] nums2 = { 3, 1, 2, 5, 4, 6 };
        System.out.println(obj.sortableIntegers(nums2)); // Output: 6

        int[] nums3 = { 1, 2, 3, 4, 5 };
        System.out.println(obj.sortableIntegers(nums3)); // Output: 5
    }
}