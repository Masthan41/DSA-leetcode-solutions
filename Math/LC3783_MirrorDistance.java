class LC3783_MirrorDistance {
    public int reverse(int n) {
        int rev = 0;
        while (n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }
        return rev;
    }

    public int mirrorDistance(int n) {
        return Math.abs(n - reverse(n));
    }

    public static void main(String[] args) {
        LC3783_MirrorDistance obj = new LC3783_MirrorDistance();
        int n = 123;
        System.out.println("Mirror Distance: " + obj.mirrorDistance(n));
    }
}