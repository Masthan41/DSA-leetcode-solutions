
import java.util.*;

class LC2657_CommonPrefixArray {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;

        int result[] = new int[n];

        HashMap<Integer, Integer> mp = new HashMap();

        int count = 0;

        for (int i = 0; i < n; i++) {
            mp.put(A[i], mp.getOrDefault(A[i], 0) + 1); // mp[A[i]]++ ;
            if (mp.get(A[i]) == 2) {
                count++;
            }

            mp.put(B[i], mp.getOrDefault(B[i], 0) + 1); // mp[B[i]]++ ;
            if (mp.get(B[i]) == 2) {
                count++;
            }

            result[i] = count;

        }
        return result;
    }

    public static void main(String[] args) {
        LC2657_CommonPrefixArray obj = new LC2657_CommonPrefixArray();
        int[] A = { 1, 3, 2, 4 };
        int[] B = { 3, 1, 2, 4 };
        int[] result = obj.findThePrefixCommonArray(A, B);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
