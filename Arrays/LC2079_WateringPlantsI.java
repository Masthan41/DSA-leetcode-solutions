/*
LeetCode 2079 - Watering Plants I
Approach: Simulate the watering process by traversing the plants array and keeping track of the water capacity.
Time Complexity: O(n) where n is the length of the plants array
Space Complexity: O(1) where we only use constant space for variables
*/

class LC2079_WateringPlantsI {
    public int wateringPlants(int[] plants, int capacity) {
        int steps = 0;
        int cap = capacity;
        for (int i = 0; i < plants.length; i++) {
            if (plants[i] <= cap) {
                steps++;
                cap -= plants[i];
            } else {
                cap = capacity;
                cap -= plants[i];
                steps += (2 * i) + 1;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        LC2079_WateringPlantsI obj = new LC2079_WateringPlantsI();
        int[] plants = { 2, 4, 5, 1, 2 };
        int capacity = 5;
        int res = obj.wateringPlants(plants, capacity);
        System.out.println(res);
    }
}
