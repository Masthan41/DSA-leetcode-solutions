class LC3876_UniformParityII {
    public boolean uniformArray(int[] nums1) {
        int minEl = Integer.MAX_VALUE;
        for (int num : nums1) {
            minEl = Math.min(minEl, num);
        }

        if (minEl % 2 == 1) { // odd - then we can convert all even to odd
            return true; // all nums2 will be odd
        }

        // check if we can make all even in nums2
        for (int num : nums1) {
            if (num % 2 == 1) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] a) {
        LC3876_UniformParityII solution = new LC3876_UniformParityII();
        int[] nums1 = { 1, 2, 3, 4 };
        System.out.println(solution.uniformArray(nums1));
    }
}
