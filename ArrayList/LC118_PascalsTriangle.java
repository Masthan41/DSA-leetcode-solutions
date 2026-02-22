/*
LeetCode 118 - Pascal's Triangle
Approach: Build each row using previous row.
Time Complexity: O(n^2)
Space Complexity: O(n^2)
*/

import java.util.*;

class LC118_PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    List<Integer> prev = result.get(i - 1);
                    row.add(prev.get(j - 1) + prev.get(j));
                }
            }

            result.add(row);
        }

        return result;
    }
    public static void main(String[] args) {
        LC118_PascalsTriangle solution = new LC118_PascalsTriangle();
        int numRows = 5;
        List<List<Integer>> pascalTriangle = solution.generate(numRows);
        System.out.println(pascalTriangle);
    }
}
