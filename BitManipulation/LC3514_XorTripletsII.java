class LC3514_XorTripletsII {
    ublic int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        int maxEle = 0;
        for (int num : nums) {
            maxEle = Math.max(num, maxEle);
        }

        int T = 1;
        while (T <= maxEle) {
            T <<= 1;
        }

        boolean s1[] = new boolean[T];
        boolean s2[] = new boolean[T];

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                s1[nums[i] ^ nums[j]] = true;
            }
        }

        for (int i = 0; i < T; i++) {
            if (s1[i] == true) {
                for (int num : nums) {
                    s2[i ^ num] = true;
                }
            }
        }

        int count = 0;
        for (int i = 0; i < T; i++) {
            if (s2[i] == true) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] a) {
        LC3514_XorTripletsII s = new LC3514_XorTripletsII();
        int[] nums = { 1, 2, 3 };
        System.out.println(s.uniqueXorTriplets(nums));
    }
}
