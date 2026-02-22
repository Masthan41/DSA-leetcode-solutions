/*
LeetCode 868 - Binary Gap
Approach: Iterate through bits and comapre with lasst seen 1 bit index to calculate gap
Time Complexity: O(log n)
Space Complexity: O(1)
*/
class LC_868_Binary_Gap {
    public int binaryGap(int n) {
        int last = -1;
        int maxGap = 0, i = 0;
        while (n > 0) {
            if ((n & 1) == 1) {
                if (last != -1) {
                    maxGap = Math.max(maxGap, i - last);
                }
                last = i;
            }
            n = n >> 1;
            i++;
        }
        return maxGap;
    }

    public static void main(String[] args) {
        LC_868_Binary_Gap obj = new LC_868_Binary_Gap();
        System.out.println(obj.binaryGap(22)); // Output: 2
        System.out.println(obj.binaryGap(5)); // Output: 2
        System.out.println(obj.binaryGap(6)); // Output: 1
    }
}
