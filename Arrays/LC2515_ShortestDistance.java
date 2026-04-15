/*
Leetcode 2515 - Shortest Distance to Target String in a Circular Array
Appraoch : Iterating through a circular array to find the minimum distance between indices using modular arithmetic logic.

Time Complexity: O(n*m) for traversing the array and comparing each element with the target string, where n is the length of the words array and m is the average length of the strings in the array.
Space Complexity: O(1) as we are only using a constant amount of extra space.
*/

class LC2515_ShortestDistance {
    public int closestTarget(String[] words, String target, int startIndex) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(target)) {
                int StraightDistance = Math.abs(i - startIndex);
                int CircularDistance = words.length - StraightDistance;
                result = Math.min(result, Math.min(StraightDistance, CircularDistance));
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        LC2515_ShortestDistance sol = new LC2515_ShortestDistance();
        String[] words = { "hello", "i", "am", "leetcode" };
        String target = "hello";
        int startIndex = 1;
        System.out.println(sol.closestTarget(words, target, startIndex));
    }
}
