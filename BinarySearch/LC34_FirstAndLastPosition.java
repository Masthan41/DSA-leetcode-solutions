/*
LeetCode 34 - Find First and Last Position of Element in Sorted Array
Pattern: Binary Search on Monotonic Condition
Approach: Narrow search space to find first and last occurrence

Time Complexity: O(log n) because of binary search
Space Complexity: O(1) for iterative approach and no extra space used
*/

class LC34_FirstAndLastPosition {
    public int[] searchRange(int[] nums, int target) {
        int getfirst = first(nums, target);
        int getlast = last(nums, target);

        return new int[] { getfirst, getlast };
    }

    public int first(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                ans = mid;
                h = mid - 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    public int last(int[] nums, int target) {
        int l = 0, h = nums.length - 1;
        int ans = -1;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                ans = mid;
                l = mid + 1;
            } else if (nums[mid] < target) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC34_FirstAndLastPosition obj = new LC34_FirstAndLastPosition();
        int[] res1 = obj.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8);
        System.out.println(res1[0] + " " + res1[1]);
        int[] res2 = obj.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 6);
        System.out.println(res2[0] + " " + res2[1]);
    }
}
