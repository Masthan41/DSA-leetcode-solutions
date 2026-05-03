class LC303_RangeSum {
    class NumArray {
        int prefix[];

        public NumArray(int[] nums) {
            prefix = new int[nums.length + 1];

            for (int i = 0; i < nums.length; i++) {
                prefix[i + 1] = prefix[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            return prefix[right + 1] - prefix[left];
        }
    }

    public static void main(String[] args) {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        NumArray numArray = new LC303_RangeSum().new NumArray(nums);
        System.out.println(numArray.sumRange(0, 2)); // Output: 1
        System.out.println(numArray.sumRange(2, 5)); // Output: -1
        System.out.println(numArray.sumRange(0, 5)); // Output: -3
    }
}