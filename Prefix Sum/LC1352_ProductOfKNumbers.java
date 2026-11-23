/*
LeetCode 1352 - Product of the Last K Numbers
Approach: Use a prefix product array to efficiently calculate the product of the last k numbers. When a new number is added, we update the prefix product array. To get the product of the last k numbers, we divide the current prefix product by the prefix product k positions back.
Time Complexity: O(1) for each add and getProduct operation.
Space Complexity: O(n) where n is the number of elements added, as we store a prefix product for each element.
*/

import java.util.*;

class LC1352_ProductOfKNumbers {
    private List<Integer> nums;
    private int n;

    public LC1352_ProductOfKNumbers() {
        nums = new ArrayList<>();
        n = 0;
    }

    public void add(int num) {
        if (num == 0) {
            nums.clear();
            n = 0;
        } else {
            if (nums.isEmpty()) {
                nums.add(num);
            } else {
                nums.add(nums.get(n - 1) * num);
            }
            n++;
        }
    }

    public int getProduct(int k) {
        if (k > n) {
            return 0;
        }
        if (k == n) {
            return nums.get(n - 1);
        }
        return nums.get(n - 1) / nums.get(n - k - 1);
    }

    public static void main(String[] args) {
        LC1352_ProductOfKNumbers productOfNumbers = new LC1352_ProductOfKNumbers();
        productOfNumbers.add(3); // [3]
        productOfNumbers.add(0); // [3, 0]
        productOfNumbers.add(2); // [3, 0, 2]
        productOfNumbers.add(5); // [3, 0, 2, 5]
        productOfNumbers.add(4); // [3, 0, 2, 5, 4]

        System.out.println(productOfNumbers.getProduct(2)); // Output: 20 (5 * 4)
        System.out.println(productOfNumbers.getProduct(3)); // Output: 40 (2 * 5 * 4)
        System.out.println(productOfNumbers.getProduct(4)); // Output: 0 (contains a zero)

        productOfNumbers.add(8); // [3, 0, 2, 5, 4, 8]
        System.out.println(productOfNumbers.getProduct(2)); // Output: 32 (4 * 8)
    }
}
