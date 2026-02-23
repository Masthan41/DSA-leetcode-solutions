class LC1545_KthBitInNthBinary{
    public char findKthBit(int n, int k) {
        if (n == 1) {
            return '0';
        }

        int midIdx = 1 << (n - 1);

        if (k == midIdx) {
            return '1';
        }

        if (k < midIdx) {
            return findKthBit(n - 1, k);
        }

        char ch = findKthBit(n - 1, midIdx * 2 - k);
        return ch == '0' ? '1' : '0';
    }
    public static void main(String[] args) {
        LC1545_KthBitInNthBinary obj = new LC1545_KthBitInNthBinary();
        int n = 3, k = 1;
        System.out.println(obj.findKthBit(n, k)); // Output: '0'
        System.out.println(obj.findKthBit(4, 2)); // Output: '1'
    }
}