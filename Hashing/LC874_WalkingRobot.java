/*
LeetCode 874 - Walking Robot Simulation
Approach: Simulate robot movement using direction vectors and efficient obstacle lookups via hashing.

Time Complexity: O(n * k + m) where n is the number of commands, k is the maximum steps in a command, and m is the number of obstacles.
Space Complexity: O(m) for the HashSet
*/

import java.util.*;

class LC874_WalkingRobot {
    public int robotSim(int[] commands, int[][] obstacles) {
        // Use HashSet to store obstacle positions as strings
        HashSet<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            String key = obs[0] + "_" + obs[1];
            obstacleSet.add(key);
        }

        int x = 0;
        int y = 0;
        int maxDistance = 0;

        // Initially pointing North
        int[] dir = { 0, 1 }; // North

        // Process each command
        for (int i = 0; i < commands.length; i++) {
            if (commands[i] == -2) { // turn left 90 degrees
                dir = new int[] { -dir[1], dir[0] };
            } else if (commands[i] == -1) { // turn right 90 degrees
                dir = new int[] { dir[1], -dir[0] };
            } else { // move forward step by step
                for (int step = 0; step < commands[i]; step++) {
                    int newX = x + dir[0];
                    int newY = y + dir[1];

                    String nextKey = newX + "_" + newY;

                    // If there's an obstacle, stop moving in this direction
                    if (obstacleSet.contains(nextKey)) {
                        break;
                    }

                    // Move to the new position
                    x = newX;
                    y = newY;
                }
            }

            // Update the maximum distance from the origin
            maxDistance = Math.max(maxDistance, x * x + y * y);
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        LC874_WalkingRobot robot = new LC874_WalkingRobot();
        int[] commands = { 4, -1, 3 };
        int[][] obstacles = {};
        System.out.println(robot.robotSim(commands, obstacles)); // Output: 25
    }
    
}  