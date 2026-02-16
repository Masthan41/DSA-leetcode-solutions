/*
LeetCode 455 - Assign Cookies
Approach: Greedy + Sorting
Sort both arrays and assign smallest valid cookie to each child.

Time Complexity: O(n log n + m log m)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class LC455_AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if(s[j]>=g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
    public static void main(String[] args) {
        LC455_AssignCookies s = new LC455_AssignCookies();
        int[] g = {1,2,3};
        int[] s1 = {1,1};
        System.out.println(s.findContentChildren(g, s1)); // 1
    }
}
