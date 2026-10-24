/*
LeetCode 2049 - Count Days Together
Approach: Convert the dates to day-of-year values and find the overlap by using the formula: overlap = min(leaveAlice, leaveBob) - max(arriveAlice, arriveBob) + 1. If the overlap is negative, return 0.

Time Complexity: O(1) as we are performing a constant number of operations regardless of the input size.
Space Complexity: O(1) as we are using a fixed amount of space for the monthDays and countMonthDays arrays.
*/

class LC2049_CountDays {
    private int findDayOfYear(String day, int[] countMonthDays) {
        int month = Integer.parseInt(day.substring(0, 2));
        int date = Integer.parseInt(day.substring(3));
        return countMonthDays[month - 1] + date;
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        int[] monthDays = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        int[] countMonthDays = new int[13];
        countMonthDays[1] = 31; // January
        for (int i = 1; i <= 12; i++) {
            countMonthDays[i] = countMonthDays[i - 1] + monthDays[i - 1];
        }

        int arriveAliceDay = findDayOfYear(arriveAlice, countMonthDays);
        int leaveAliceDay = findDayOfYear(leaveAlice, countMonthDays);
        int arriveBobDay = findDayOfYear(arriveBob, countMonthDays);
        int leaveBobDay = findDayOfYear(leaveBob, countMonthDays);

        // Now, just find the overlap
        int overlapDays = Math.min(leaveAliceDay, leaveBobDay) - Math.max(arriveAliceDay, arriveBobDay) + 1;

        return Math.max(overlapDays, 0);
    }

    public static void main(String[] args) {
        LC2049_CountDays solution = new LC2049_CountDays();
        String arriveAlice = "08-15";
        String leaveAlice = "08-18";
        String arriveBob = "08-16";
        String leaveBob = "08-19";
        int result = solution.countDaysTogether(arriveAlice, leaveAlice, arriveBob, leaveBob);
        System.out.println(result); // Output: 3
    }
}
