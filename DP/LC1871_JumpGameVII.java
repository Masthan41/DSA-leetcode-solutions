class LC1871_JumpGameVII{
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();

        int[] t = new int[n];
        //t[i] > 0 : possible to reach i
        // == 0 : not possible to reach i

        t[0] = 1;
        int count = 0;

        for (int j = 1; j <= n - 1; j++) {
            if (j - minJump >= 0) {
                count += t[j - minJump];
            }

            if (j - maxJump - 1 >= 0) {
                count -= t[j - maxJump - 1];
            }

            if (count > 0 && s.charAt(j) == '0') {
                t[j] = 1;
            }
        }
        return t[n - 1] > 0;
    }
    public static void main(String[] args){
        LC1871_JumpGameVII t = new LC1871_JumpGameVII();
        System.out.println(t.canReach("011010", 2, 3));
        System.out.println(t.canReach("01101110", 2, 3));
    }
}