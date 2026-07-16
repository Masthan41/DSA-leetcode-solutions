/*
LeetCode 2226 - Maximum Candies Allocated to K Children
Approach: Binary search on the answer. For each mid value, check if it's possible to allocate at least k candies to each child.
Time Complexity: O(n * log(max(candies))) where n is the length of the candies array and max(candies) is the maximum number of candies.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/

class LC226_MaxCandies {
    public boolean isPossible(int candies[], int mid, long k) {
        long total = 0;
        for (int i = 0; i < candies.length; i++) {
            total += candies[i] / mid;

            if (total >= k) {
                return true;
            }
        }
        return total >= k;
    }

    public int maximumCandies(int[] candies, long k) {
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(candy, maxCandies);
        }
        int low = 1, high = maxCandies;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(candies, mid, k)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC226_MaxCandies obj = new LC226_MaxCandies();
        int[] candies = { 5, 8, 6 };
        long k = 3;
        int result = obj.maximumCandies(candies, k);
        System.out.println("Maximum Candies: " + result);
    }
}
