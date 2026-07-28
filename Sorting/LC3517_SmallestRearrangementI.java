import java.util.Arrays;

class LC3517_SmallestRearrangementI {
    public String smallestPalindrome(String s) {
        int n = s.length();
        int mid = n / 2;

        char arr[] = s.toCharArray();
        Arrays.sort(arr, 0, mid);

        for (int i = 0; i < mid; i++) {
            arr[n - 1 - i] = arr[i];
        }
        return new String(arr);
    }

    public static void main(String[] args) {
        LC3517_SmallestRearrangementI solution = new LC3517_SmallestRearrangementI();
        String s = "bca";
        String result = solution.smallestPalindrome(s);
        System.out.println(result);
    }
}