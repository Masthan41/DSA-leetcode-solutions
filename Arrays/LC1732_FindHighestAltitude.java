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
    public static void main(String[] args) {
        LC1732_FindHighestAltitude obj = new LC1732_FindHighestAltitude();
        int[] gain = { -5, 1, 5, 0, -7 };
        System.out.println(obj.largestAltitude(gain)); // 1
    }
}