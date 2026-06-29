/*
LeetCode 881 - Boats to Save People
Approach: Sort the array of people's weights and use two pointers to pair the lightest and heaviest people, ensuring each boat carries at most two people and does not exceed the weight limit.
Time Complexity: O(n log n) due to sorting.
Space Complexity: O(1) since we are only using a constant amount of extra space.
*/

import java.util.*;

class LC881_BoatsToSave {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int boats = 0;
        int left = 0, right = people.length - 1;

        while (left <= right) {
            if (people[left] + people[right] <= limit) {
                left++;
            }
            right--;
            boats++;
        }
        return boats;
    }
    public static void main(String[] args){
        LC881_BoatsToSave solution = new LC881_BoatsToSave();
        int[] people = {3, 2, 2, 1};
        int limit = 3;
        int result = solution.numRescueBoats(people, limit);
        System.out.println("Minimum number of boats required: " + result);
    }
}
