class LC304_RangeSumQueries2D {
    int prefix[][];

    public NumMatrix(int[][] matrix) {
        prefix = new int[matrix.length + 1][matrix[0].length + 1];

        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                prefix[i][j] = matrix[i - 1][j - 1] + prefix[i - 1][j] + prefix[i][j - 1] - prefix[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1]
                - prefix[row1][col2 + 1]
                - prefix[row2 + 1][col1]
                + prefix[row1][col1];

    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 3, 0, 1, 4, 2 },
                { 5, 6, 3, 2, 1 },
                { 1, 2, 0, 1, 5 },
                { 4, 1, 0, 1, 7 },
                { 1, 0, 3, 0, 5 }
        };

        LC304_RangeSumQueries2D obj = new LC304_RangeSumQueries2D(matrix);
        System.out.println(obj.sumRegion(2, 1, 4, 3)); // Output: 8
        System.out.println(obj.sumRegion(1, 1, 2, 2)); // Output: 11
        System.out.println(obj.sumRegion(1, 2, 2, 4)); // Output: 12
    }
}
