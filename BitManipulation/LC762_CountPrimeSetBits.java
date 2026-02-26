/*
LeetCode 762 - Count Prime Set Bits in Binary Representation
Approach: Iterate and updae count
Time Complexity: O(n*sqrt(m)) where n is the number of integers in the range [left, right] and m is the maximum number of set bits in any integer in that range. The prime checking function runs in O(sqrt(m)).
Space Complexity: O(1)
*/

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
            //Inbuilt function to count the number of set bits in the binary representation of i
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