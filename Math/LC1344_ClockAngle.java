/*
LeetCode 1344 - Clock Angle
Approach: Calculate the angles of the hour and minute hands separately, then find the absolute difference between them. Return the minimum angle between the two hands.
Time complexity: O(1) as the calculations are done in constant time
Space complexity: O(1) as we are using a constant amount of space for the variables
*/

class LC1344_ClockAngle {
    public double angleClock(int hour, int minutes) {
        double minuteAngle = minutes * 6;
        double hourAngle = (hour % 12) * 30 + minutes * 0.5;
        double diff = Math.abs(minuteAngle - hourAngle);

        return Math.min(diff, 360 - diff);
    }

    public static void main(String[] args) {
        LC1344_ClockAngle sol = new LC1344_ClockAngle();
        System.out.println(sol.angleClock(12, 30)); // 165.0
        System.out.println(sol.angleClock(3, 30)); // 75.0
        System.out.println(sol.angleClock(3, 15)); // 7.5
    }
}
