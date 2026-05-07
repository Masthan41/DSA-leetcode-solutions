class LC3660_JumpingGameIX{
    public int[] maxValue(int[] nums) {
        int n = nums.length;

        int[] maxLeft = new int[n]; // maxLeft[i] = max element from index 0 to i
        int[] minRight = new int[n]; // minRight[i] = min element from i to n-1

        maxLeft[0] = nums[0];
        minRight[n - 1] = nums[n - 1];

        for(int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(nums[i], maxLeft[i - 1]);
        }

        for(int i = n - 2; i >= 0; i--) {
            minRight[i] = Math.min(nums[i], minRight[i + 1]);
        }

        int[] result = new int[n];

        result[n - 1] = maxLeft[n - 1];

        for(int i = n - 2; i >= 0; i--) {
            if(maxLeft[i] <= minRight[i + 1]) { // can't go to right at all
                result[i] = maxLeft[i];
            } else {
                result[i] = result[i + 1];
            }
        }

        return result;
    }
    public static void main(String[] args) {
        LC3660_JumpingGameIX solution = new LC3660_JumpingGameIX();
        int[] nums = {5, 2, 3, 1, 4};
        int[] result = solution.maxValue(nums);
        System.out.println(Arrays.toString(result));
    }
}