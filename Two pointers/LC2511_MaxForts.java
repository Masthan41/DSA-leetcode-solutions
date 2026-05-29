/*
LeetCode 2511 - Maximum forts that can be captures
Approach: We can use a single pass to find the maximum number of forts that can be captured. We keep track of the last non-zero fort and whenever we encounter a new non-zero fort, we check if it is different from the last one. If it is, we calculate the number of forts that can be captured between them and update our answer accordingly.

Time Complexity: O(n) where n is the length of the forts array
Space Complexity: O(1) since we are using only a constant amount of extra space
*/

class LC2511_MaxForts {
    public int captureForts(int[] forts) {
        int prevNonZero = -1, ans = 0;
        for (int i = 0; i < forts.length; i++) {

            if (forts[i] != 0) {
                if (prevNonZero != -1 && forts[prevNonZero] != forts[i]) {
                    ans = Math.max(ans, i - prevNonZero - 1);
                }
                prevNonZero = i;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC2511_MaxForts obj = new LC2511_MaxForts();
        int[] forts = { 1, 0, 0, -1, 0, 0, 0 };
        int res = obj.captureForts(forts);
        System.out.println(res);
    }
}