/*
LeetCode 986 - Interval list intersection
Approach: Two Pointers using two pointers to traverse both lists and find the intersection intervals.
Time Complexity: O(m+n) where m is the length of firstList and n is the length of secondList
Space Complexity: O(min(m,n)) for the result list
*/

class LC986_ListIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> res = new ArrayList<>();

        while (i < firstList.length && j < secondList.length) {
            int start = Math.max(firstList[i][0], secondList[j][0]);
            int end = Math.min(firstList[i][1], secondList[j][1]);

            if (start <= end) {
                res.add(new int[] { start, end });
            }
            if (end == firstList[i][1]) {
                i++;
            }
            if (end == secondList[j][1]) {
                j++;
            }
        }
        return res.toArray(new int[res.size()][2]);
    }

    public static void main(String[] args) {
        LC986_ListIntersection obj = new LC986_ListIntersection();
        int[][] firstList = { { 0, 2 }, { 5, 10 }, { 13, 23 }, { 24, 25 } };
        int[][] secondList = { { 1, 5 }, { 8, 12 }, { 15, 24 }, { 25, 26 } };
        int[][] res = obj.intervalIntersection(firstList, secondList);
        for (int[] interval : res) {
            System.out.println(Arrays.toString(interval));
        }
    }
}