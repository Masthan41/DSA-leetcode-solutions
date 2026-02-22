/*
LeetCode 401 - Binary Watch
Approach: Brute force + Bit counting
Time Complexity: O(12 × 60) = O(1)
Space Complexity: O(1)
*/

import java.util.*;

class LC401_BinaryWatch {

    public List<String> readBinaryWatch(int turnedOn) {

        List<String> result = new ArrayList<>();

        for (int hour = 0; hour < 12; hour++) {
            for (int minute = 0; minute < 60; minute++) {

                if (Integer.bitCount(hour) + Integer.bitCount(minute) == turnedOn) {

                    result.add(hour + ":" + (minute < 10 ? "0" : "") + minute);

                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        LC401_BinaryWatch solution = new LC401_BinaryWatch();
        int turnedOn = 1;
        List<String> times = solution.readBinaryWatch(turnedOn);
        System.out.println(times);
    }
    public static void main(String[] args) {
        LC401_BinaryWatch solution = new LC401_BinaryWatch();
        int turnedOn = 1;
        List<String> times = solution.readBinaryWatch(turnedOn);
        System.out.println(times);
    }
}
