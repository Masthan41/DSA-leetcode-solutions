/*
LeetCode 2105 - Watering Plants II
Approach: Two Pointers using two pointers to traverse the array from both ends and simulate the watering process.
Time Complexity: O(n) where n is the length of the plants array
Space Complexity: O(1) where we only use constant space for pointers
*/

class LC2105_WateringPlantsII {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int i = 0, j = n - 1;
        int refills = 0;
        int capa = capacityA, capb = capacityB;
        while (i < j) {
            // alice
            if (capa < plants[i]) {
                refills++;
                capa = capacityA;
            }
            capa -= plants[i];
            i++;

            // bob
            if (capb < plants[j]) {
                refills++;
                capb = capacityB;
            }
            capb -= plants[j];
            j--;
        }
        if (i == j) {
            if (Math.max(capa, capb) < plants[i]) {
                refills++;
            }
        }
        return refills;
    }

    public static void main(String[] args) {
        LC2105_WateringPlantsII obj = new LC2105_WateringPlantsII();
        int[] plants = { 2, 4, 5, 1, 2 };
        int capacityA = 5, capacityB = 7;
        int res = obj.minimumRefill(plants, capacityA, capacityB);
        System.out.println(res);
    }
}
