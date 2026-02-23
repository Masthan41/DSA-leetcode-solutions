/*
LeetCode 912 - Sort an Array
Pattern: Divide and Conquer (Merge Sort)
Approach: Recursively divide array and merge sorted halves
Time Complexity: O(n log n)
Space Complexity: O(n)
*/


class LC912_SortArray_MergeSort {
    public int[] sortArray(int[] nums) {
        mergesort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergesort(int arr[], int si, int ei) {
        if (si >= ei) {
            return;
        }
        int mid = si + (ei - si) / 2;
        mergesort(arr, si, mid);
        mergesort(arr, mid + 1, ei);

        merge(arr, si, mid, ei);
    }

    public static void merge(int arr[], int si, int mid, int ei) {
        int temp[] = new int[ei - si + 1];
        int i = si;
        int j = mid+1;
        int k = 0;

        while (i <= mid && j <= ei) {
            if (arr[i] < arr[j]) {
                temp[k] = arr[i];
                i++;
            } else {
                temp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i <= mid) {
            temp[k] = arr[i];
            i++;
            k++;
        }
        while (j <= ei) {
            temp[k] = arr[j];
            j++;
            k++;
        }
        for (k = 0, i = si; k < temp.length; k++, i++) {
            arr[i] = temp[k];
        }
    }
    public static void main(String[] args) {
        LC912_SortArray_MergeSort solution = new LC912_SortArray_MergeSort();
        int[] nums = { 5, 2, 3, 1 };
        int[] sorted = solution.sortArray(nums);
        System.out.print("Sorted Array: ");
        for (int num : sorted) {
            System.out.print(num + " ");
        }
        // Sorted Array: 1 2 3 5
    }
}