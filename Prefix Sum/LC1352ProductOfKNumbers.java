import java.util.ArrayList;
import java.util.List;

class LC1352ProductOfKNumbers {
    private List<Integer> nums;
    private int n;

    public LC1352ProductOfKNumbers() {
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
        LC1352ProductOfKNumbers productOfNumbers = new LC1352ProductOfKNumbers();
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
