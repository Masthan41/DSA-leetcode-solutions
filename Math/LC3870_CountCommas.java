/*
LeetCode 3870 - Count commas in range
Approach: Use a simple mathematical formula to count the number of commas in the range from 1 to n. which is equal to n - 999 for n >= 1000, otherwise return 0.
Time complexity: O(1) because we are performing a constant time operation.
Space complexity: O(1) because we are using a constant amount of space.
*/

class LC3870_CountCommas {
    public int countCommas(int n) {
        if (n < 1000) {
            return 0;
        }
        return n - 999;
    }

    public static void main(String[] a) {
        LC3870_CountCommas solution = new LC3870_CountCommas();
        System.out.println(solution.countCommas(1000)); // Output: 1
        System.out.println(solution.countCommas(999)); // Output: 0
        System.out.println(solution.countCommas(1500)); // Output: 501
    }
}
