/*
LeetCode 162 - Find Peak element
Approach: Use Binary search to find the peak as left side and right side of the peak will be sorted and we can find the peak by comparing mid with its neighbors.
This works if the array has multiple peaks as well, as we are only looking for one peak.
Time Complexity: O(log n) due to binary search
Space Complexity: O(1) as we are using constant space
*/
class LC162_PeakElement {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int low = 1, high = n - 2;
        if (n == 1)
            return 0;

        if (nums[0] > nums[1])
            return 0;

        if (nums[n - 1] > nums[n - 2])
            return n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            } else if (nums[mid] < nums[mid + 1]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC162_PeakElement obj = new LC162_PeakElement();
        int[] nums = { 1, 2, 3, 1 };
        int peakIndex = obj.findPeakElement(nums);
        System.out.println(peakIndex);
    }
}
