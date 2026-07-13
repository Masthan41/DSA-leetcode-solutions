/*
LeetCode 875 - Koko Eating Bananas
Approach: Use binary search to find the minimum eating speed. The search space is between 1 and the maximum number of bananas in a pile. For each mid value, check if Koko can eat all bananas within h hours using a helper function.
Time Complexity: O(n log m), where n is the number of piles and m is the maximum number of bananas in a pile.
Space Complexity: O(1) - For storing variables and no additional data structures are used.
*/

class LC875_KokoEatingBananas {
    public boolean canEatAll(int piles[], int mid, int h) {
        int actualHours = 0;

        for (int i : piles) {
            actualHours += i / mid;

            if (i % mid != 0) {
                actualHours++;
            }
        }
        return actualHours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;
        for (int i : piles) {
            right = Math.max(right, i);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canEatAll(piles, mid, h)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        LC875_KokoEatingBananas obj = new LC875_KokoEatingBananas();
        int piles[] = { 3, 6, 7, 11 };
        int h = 8;
        System.out.println(obj.minEatingSpeed(piles, h));
    }
}
