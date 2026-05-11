

class LC485_MaxConsecutiveOnesI {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentCount = 0, MaxCount = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentCount++;
            }
            MaxCount = Math.max(MaxCount, currentCount);
            if (nums[i] == 0) {
                currentCount = 0;
            }
        }
        return MaxCount;
    }

    public static void main(String[] args) {
        LC485_MaxConsecutiveOnesI solution = new LC485_MaxConsecutiveOnesI();
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        int result = solution.findMaxConsecutiveOnes(nums);
        System.out.println("Maximum number of consecutive 1's: " + result);
    }
}
