/*
LeetCode 2126 - Destroying Asteroids
Approach: Sort the asteroids in ascending order. Iterate through the sorted array and check if the current mass is less than the asteroid's mass. If it is, return false. If the mass is greater than or equal to 1e5, return true (since we won't encounter any larger asteroids). Otherwise, add the asteroid's mass to the current mass and continue iterating.

Time complexity: O(n log n) due to sorting the asteroids array.
Space complexity: O(1) since we are using only a constant amount of extra space.
*/

import java.util.*;

class LC2126_DestrotingAsteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);

        for (int asteroid : asteroids) {
            if (mass < asteroid)
                return false;
            else if (mass >= 1e5)
                return true;

            mass += asteroid;
        }
        return true;
    }

    public static void main(String[] args) {
        LC2126_DestrotingAsteroids solution = new LC2126_DestrotingAsteroids();
        int mass = 10;
        int[] asteroids = { 3, 9, 19, 5, 21 };
        boolean result = solution.asteroidsDestroyed(mass, asteroids);
        System.out.println(result); // Output: true//
    }
}
