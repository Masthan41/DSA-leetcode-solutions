/*
LeetCode 2069 - Walking Robot Simulation II
Approach: Simulate robot movement using a circular list of positions and directions.
Time Complexity: O(n+m) where n is the number of steps and m is the perimeter of the grid.
Space Complexity: O(m) where m is the perimeter of the grid.
*/

import java.util.*;

class LC2069_WalkingSimulationII {

    int idx = 0;
    boolean moved = false;
    List<int[]> pos = new ArrayList<>();

    public Robot(int width, int height) {
        // Bottom row (left to right) - East (0)
        for (int x = 0; x < width; x++) {
            pos.add(new int[]{x, 0, 0});
        }

        // Right column (bottom to top) - North (1)
        for (int y = 1; y < height; y++) {
            pos.add(new int[]{width - 1, y, 1});
        }

        // Top row (right to left) - West (2)
        for (int x = width - 2; x >= 0; x--) {
            pos.add(new int[]{x, height - 1, 2});
        }

        // Left column (top to bottom) - South (3)
        for (int y = height - 2; y > 0; y--) {
            pos.add(new int[]{0, y, 3});
        }

        //corner case
        pos.get(0)[2]=3;
    }

    public void step(int num) {
        moved = true;
        idx = (idx + num) % pos.size();
    }

    public int[] getPos() {
        return new int[] { pos.get(idx)[0], pos.get(idx)[1] };
    }

    public String getDir() {
        if (!moved)
            return "East";

        int d = pos.get(idx)[2];

        if (d == 0)
            return "East";
        else if (d == 1)
            return "North";
        else if (d == 2)
            return "West";
        else
            return "South";
    }
}
