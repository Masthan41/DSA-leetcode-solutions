/*
LeetCode 1861 - Rotating the Box
Approach - Simulating gravity on stones after rotating a matrix using transpose-reverse and two-pointer techniques.
Time Complexity - O(m * n) for transposing and applying gravity
Space Complexity - O(m * n) for the result matrix
*/

import java.util.Arrays;

class LC1861_RotatingBox {
    private void reverse(char row[]) {
        int left = 0, right = row.length - 1;
        while (left <= right) {
            char temp = row[left];
            row[left] = row[right];
            row[right] = temp;

            left++;
            right--;
        }
    }

    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;
        char result[][] = new char[n][m];

        // transpose
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                result[i][j] = boxGrid[j][i];
            }
        }

        // revrse rows
        for (int i = 0; i < n; i++) {
            reverse(result[i]);
        }

        // apply gravity
        for (int j = 0; j < m; j++) {
            int spaceBottomRow = n - 1;
            for (int i = n - 1; i >= 0; i--) {
                if (result[i][j] == '*') {
                    spaceBottomRow = i - 1;
                    continue;
                }

                if (result[i][j] == '#') {
                    result[i][j] = '.';
                    result[spaceBottomRow][j] = '#';
                    spaceBottomRow--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC1861_RotatingBox solution = new LC1861_RotatingBox();
        char[][] boxGrid = {
                { '#', '.', '#' },
                { '#', '*', '.' },
                { '#', '.', '.' }
        };
        char[][] result = solution.rotateTheBox(boxGrid);
        for (char[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}
