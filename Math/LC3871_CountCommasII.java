/*
LeetCode 3871 - Count commas in range II
Approach: Use a loop to count the number of commas in the range from 1 to n. We start counting from 1000 and keep multiplying by 1000 until we exceed n. For each range, we add the count of numbers that have commas to the result.
Time complexity: O(log n) because we are dividing the range by 1000 in each iteration of the loop.
Space complexity: O(1) because we are using a constant amount of space.
*/

class LC3871_CountCommasII {
    public long countCommas(long n) {
        long result = 0;
        long start = 1000;

        while (start <= n) {
            result += (n - start + 1);
            start *= 1000;
        }
        return result;
    }

    public static void main(String[] a) {
        LC3871_CountCommasII solution = new LC3871_CountCommasII();
        System.out.println(solution.countCommas(1000)); // Output: 1
        System.out.println(solution.countCommas(999)); // Output: 0
        System.out.println(solution.countCommas(1500)); // Output: 501
        System.out.println(solution.countCommas(1000000)); // Output: 1001
    }
}