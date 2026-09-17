/*
LeetCode 496 - Next Greater Element I
Approach: Use a stack to store next greater element of nums2 array and map it with the element, after that directly return answer with O(1) average time complexity
Time complexity: O(n) as each element is pushed and popped from the stack at most once.
Space complexity: O(n) as we are using a stack and hashmap.
*/

import java.util.*;

public class LC496_NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> s = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Build NGE map from nums2
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums2[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], s.peek());
            }

            s.push(nums2[i]);
        }

        // Step 2: Fill result for nums1
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
    public static void main(String[] args) {
        LC496_NextGreaterElementI solution = new LC496_NextGreaterElementI();
        int[] nums1 = { 4, 1, 2 };
        int[] nums2 = { 1, 3, 4, 2 };
        int[] result = solution.nextGreaterElement(nums1, nums2);
        System.out.print("Next Greater Elements: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Next Greater Elements: -1 3 -1
    }
}
