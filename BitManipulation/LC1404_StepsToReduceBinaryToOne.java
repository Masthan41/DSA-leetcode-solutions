class LC1404_StepsToReduceBinaryToOne{
    public int numSteps(String s) {
        int steps = 0, carry = 0;
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = s.charAt(i) - '0';
            //odd
            if (bit + carry == 1) {
                steps = steps + 2;
                carry = 1;
            }
            //even
            else {
                steps = steps + 1;
            }
        }
        return steps + carry;
    }
    public static void main(String[] args) {
        LC1404_StepsToReduceBinaryToOne obj = new LC1404_StepsToReduceBinaryToOne();
        String s = "1101";
        System.out.println(obj.numSteps(s));
    }
}