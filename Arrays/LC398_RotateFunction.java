class LC398_RotateFunction {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int F = 0;

        // Initial sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += i * nums[i];
        }

        int result = F;

        // Compute next rotations using recurrence
        for (int k = 0; k < n; k++) {
            int newF = F + sum - n * nums[n - 1 - k];
            result = Math.max(result, newF);
            F = newF;
        }

        return result;
    }

    public static void main(String[] args) {
        LC398_RotateFunction obj = new LC398_RotateFunction();
        int[] nums = { 4, 3, 2, 6 };
        int result = obj.maxRotateFunction(nums);
        System.out.println(result);
    }
}