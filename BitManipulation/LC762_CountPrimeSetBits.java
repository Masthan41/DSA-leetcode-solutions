class LC762_CountPrimeSetBits {
    public boolean prime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int countPrimeSetBits(int left, int right) {
        int c = 0;
        for (int i = left; i <= right; i++) {
            int Sb = Integer.bitCount(i);
            if (prime(Sb)) {
                c++;
            }
        }
        return c;
    }
    public static void main(String[] args) {
        LC762_CountPrimeSetBits obj = new LC762_CountPrimeSetBits();
        int left = 6, right = 10;
        System.out.println(obj.countPrimeSetBits(left, right)); // Output: 4
    }
}