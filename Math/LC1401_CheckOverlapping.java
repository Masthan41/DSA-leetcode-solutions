/*
LeetCode 1401 - Circle and rectangle Overlapping
Approach: Find the closest point on the rectangle to the center of the circle. If the distance from this point to the center is less than or equal to the radius, then there is an overlap.
Time complexity: O(1) as the calculations are done in constant time
Space complexity: O(1) as we are using a constant amount of space for the variables
*/

class LC1401_CheckOverlapping{
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int xi;
        int yi;

        if (x1 > xCenter) {
            xi = x1;
        } else if (x2 < xCenter) {
            xi = x2;
        } else {
            xi = xCenter;
        }

        if (y1 > yCenter) {
            yi = y1;
        } else if (y2 < yCenter) {
            yi = y2;
        } else {
            yi = yCenter;
        }

        return Math.sqrt((xi - xCenter) * (xi - xCenter) + (yi - yCenter) * (yi - yCenter)) <= radius;
    }
    public static void main(String[] a){
        LC1401_CheckOverlapping solution = new LC1401_CheckOverlapping();
        System.out.println(solution.checkOverlap(1, 0, 0, 1, -1, 3, 1));
        System.out.println(solution.checkOverlap(1, 2, 0, 1, 2, 3, 1));
    }
}