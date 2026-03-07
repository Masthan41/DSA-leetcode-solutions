class LC1888_MinFlips {
    public int minFlips(String s) {
        String str = s + s;

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for (int i = 0; i < 2 * s.length(); i++) {
            if (i % 2 == 0) {
                s1.append('0');
                s2.append('1');
            } else {
                s1.append('1');
                s2.append('0');
            }
        }
        int res = Integer.MAX_VALUE;
        int d1 = 0, d2 = 0;
        int l = 0;

        for (int j = 0; j < 2 * s.length(); j++) {
            if (str.charAt(j) != s1.charAt(j))
                d1++;
            if (str.charAt(j) != s2.charAt(j))
                d2++;

            if (j - l + 1 > s.length()) {
                if (str.charAt(l) != s1.charAt(l))
                    d1--;
                if (str.charAt(l) != s2.charAt(l))
                    d2--;
                l++;
            }
            if (j - l + 1 == s.length()) {
                res = Math.min(res, Math.min(d1, d2));
            }
        }
        return res;
    }
    public static void main(String[] args) {
        LC1888_MinFlips obj = new LC1888_MinFlips();
        System.out.println(obj.minFlips("111000")); //output : 2
        System.out.println(obj.minFlips("101")); //output : 0
    }
}