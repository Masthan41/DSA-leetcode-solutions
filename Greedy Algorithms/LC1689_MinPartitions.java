/*
LeetCode 1689 - Minimum Partitions
Approach: Find the maximum digit in the string, as each partition can contribute at most 1 to the sum.
Time Complexity: O(n)
Space Complexity: O(1)
*/

class LC1689_MinPartitions {
    public int minPartitions(String n) {
        int maxDig = 0;
        for (char c : n.toCharArray()) {
            maxDig = Math.max(maxDig, c - '0');
        }
        if (maxDig > 9) { // cant go higher
            return 9;
        }
        return maxDig;
    }

    public static void main(String[] args) {
        LC1689_MinPartitions obj = new LC1689_MinPartitions();
        String n = "32";
        System.out.println(obj.minPartitions(n)); // Output: 3
    }
}
