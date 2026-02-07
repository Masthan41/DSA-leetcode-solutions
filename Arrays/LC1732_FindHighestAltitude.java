/*
LeetCode 1732 - Find the Highest Altitude
Approach: Prefix Sum (running altitude)
Time complexity: O(n)
Space complexity: O(1)
*/

class LC1732_FindHighestAltitude {
    public int largestAltitude(int[] gain) {
        int sum = 0;
        int maxAlt = 0;

        for (int i = 0; i < gain.length; i++) {
            sum += gain[i];
            maxAlt = Math.max(maxAlt, sum);
        }

        return maxAlt;
    }
}