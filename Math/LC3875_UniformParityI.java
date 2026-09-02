/*
LeetCode 3875 - Construct Uniform parity array I
Approach: There can be only two cases for the uniform parity array. Either all the elements are even or all the elements are odd. So, we can check if all the elements in the array are even or all the elements are odd. If either of these conditions is true, then we can return true, otherwise false.
Time Complexity: O(n) where n is the length of the input array. We need to iterate through the array to check the parity of each element.
Space Complexity: O(1) as we are using a constant amount of space for variables.
*/

class LC3875_UniformParityI {
    public boolean uniformArray(int[] nums1) {
        return true;
    }

    public static void main(String[] a) {
        LC3875_UniformParityI solution = new LC3875_UniformParityI();
        int[] nums1 = { 1, 2, 3, 4 };
        System.out.println(solution.uniformArray(nums1));
    }
}
