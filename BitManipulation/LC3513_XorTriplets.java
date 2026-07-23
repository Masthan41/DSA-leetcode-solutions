class LC3513_XorTriplets {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n == 1 || n == 2) {
            return n;
        }

        int ans = 1;
        while (ans <= n) {
            ans *= 2;
        }
        return ans;
    }

    public static void main(String[] a) {
        LC3513_XorTriplets s = new LC3513_XorTriplets();
        int[] nums = { 1, 2, 3 };
        System.out.println(s.uniqueXorTriplets(nums));
        
    }  
}