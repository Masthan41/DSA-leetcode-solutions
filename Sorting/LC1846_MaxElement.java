import java.util.Arrays;

class LC1846_MaxElement {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        int maxEl = 1;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[i] = 1;
            } else if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }

            maxEl = Math.max(maxEl, arr[i]);
        }
        return maxEl;
    }

    public static void main(String[] args) {
        LC1846_MaxElement solution = new LC1846_MaxElement();
        int[] arr = { 2, 2, 1, 2, 1 };
        int result = solution.maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println("Maximum Element After Decrementing and Rearranging: " + result);
    }
}
