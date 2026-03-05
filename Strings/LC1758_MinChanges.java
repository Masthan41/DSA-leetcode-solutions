class LC1758_MinChanges {
    public int minOperations(String s) {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            if ((s.charAt(i) - '0') != (i % 2)) {
                c++;
            }
        }
        return Math.min(c, s.length() - c);
    }

    public static void main(String[] args) {
        LC1758_MinChanges obj = new LC1758_MinChanges();
        String s1 = "0100";
        String s2 = "10000";

        System.out.println(obj.minOperations(s1));
        System.out.println(obj.minOperations(s2));
    }
}
