/*
LeetCode 771 - Jewels in Stones
Approach: Brute force (nested loops)
Time complexity: O(n * m)
Space complexity: O(1)
*/

class LC771_JewelsInStones {
    public int numJewelsInStones(String jewels, String stones) {
        int c = 0;

        for (int i = 0; i < stones.length(); i++) {
            for (int j = 0; j < jewels.length(); j++) {
                if (stones.charAt(i) == jewels.charAt(j)) {
                    c++;
                    break;
                }
            }
        }
        return c;
    }
}