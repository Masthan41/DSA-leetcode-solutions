/*
LeetCode 3783 - Mirror Distance
Approach: To calculate the mirror distance of a number, we first need to reverse the digits of the number and then find the absolute difference between the original number and its reversed version.

Time Complexity: O(log n) where n is the input number. The log(n) factor comes from reversing the digits.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/


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