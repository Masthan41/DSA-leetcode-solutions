class LC836_RectangleOverlap {
    public boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        return rec1[0] < rec2[2] && rec2[0] < rec1[2] &&
                rec1[1] < rec2[3] && rec2[1] < rec1[3];
    }

    public static void main(String[] args) {
        LC836_RectangleOverlap solution = new LC836_RectangleOverlap();
        int[] rec1 = { 0, 0, 2, 2 };
        int[] rec2 = { 1, 1, 3, 3 };
        System.out.println(solution.isRectangleOverlap(rec1, rec2)); // Output: true

        int[] rec3 = { 0, 0, 1, 1 };
        int[] rec4 = { 1, 0, 2, 1 };
        System.out.println(solution.isRectangleOverlap(rec3, rec4)); // Output: false
    }
}
