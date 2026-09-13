/*
Leetcode 835 - Image Overlap
Approach - We can fix one image and move the other image in all possible directions. For each shift, we can count the number of overlapping 1s.
Time Complexity - O(n^4) where n is the dimension of the image (since we are shifting in both x and y directions and counting overlaps)
Space Complexity - O(1) since we are using a constant amount of extra space
*/

class LC835_ImageOverlap {
    public int shiftAndCount(int[][] A, int[][] B, int x_shift, int y_shift) {
        int n = A.length;
        int leftShiftCount = 0;
        int rightShiftCount = 0;

        int A_row = 0;

        for (int B_row = x_shift; B_row < n; B_row++) {
            int A_col = 0;
            for (int B_col = y_shift; B_col < n; B_col++) {
                if (B[B_row][B_col] == 1 && B[B_row][B_col] == A[A_row][A_col])
                    leftShiftCount++;
                if (B[B_row][A_col] == 1 && B[B_row][A_col] == A[A_row][B_col])
                    rightShiftCount++;
                A_col++;
            }
            A_row++;
        }
        return Math.max(leftShiftCount, rightShiftCount);
    }

    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        int maxOverlap = 0;
        for (int x_shift = 0; x_shift < n; x_shift++) {
            for (int y_shift = 0; y_shift < n; y_shift++) {
                // Fix A, move B left and right
                maxOverlap = Math.max(maxOverlap, shiftAndCount(img1, img2, x_shift, y_shift));
                // Fix B, move A
                maxOverlap = Math.max(maxOverlap, shiftAndCount(img2, img1, x_shift, y_shift));
            }
        }
        return maxOverlap;
    }

    public static void main(String[] args) {
        LC835_ImageOverlap obj = new LC835_ImageOverlap();
        int[][] img1 = { { 1, 1, 0 }, { 0, 1, 0 }, { 0, 1, 0 } };
        int[][] img2 = { { 0, 0, 0 }, { 0, 1, 1 }, { 0, 0, 1 } };
        System.out.println(obj.largestOverlap(img1, img2));
    }
}
