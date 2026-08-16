/*
LeetCode 2029 - Stone Game IX
Approach: Maintain a coutn array of size 3 to count the number of stones with remainder 0, 1, and 2 when divided by 3. Then check the conditions for winning based on the counts.
Time Complexity: O(n) as we iterate through the stones array once.
Space Complexity: O(1) as we use a fixed size array of size 3.
*/

class LC2029_StoneGameIX {
    public boolean stoneGameIX(int[] stones) {
        int[] cnt = new int[3];

        for (int stone : stones) {
            cnt[stone % 3]++;
        }

        if ((cnt[0] & 1) == 0) {
            return cnt[1] > 0 && cnt[2] > 0;
        }

        return Math.abs(cnt[1] - cnt[2]) > 2;
    }

    public static void main(String[] a) {
        LC2029_StoneGameIX solution = new LC2029_StoneGameIX();
        int[] stones = { 2, 1 };
        boolean result = solution.stoneGameIX(stones);
        System.out.println(result);
    }
}