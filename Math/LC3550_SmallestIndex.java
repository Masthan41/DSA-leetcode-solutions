class LC3550_SmallestIndex{
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            while (nums[i] != 0) {
                int digit = nums[i] % 10;
                sum += digit;
                nums[i] /= 10;

            }
            if (sum == i) {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] a){
        LC3550_SmallestIndex s = new LC3550_SmallestIndex();
        int[] nums = {18, 29, 38, 47, 56};
        System.out.println(s.smallestIndex(nums));
    }
}