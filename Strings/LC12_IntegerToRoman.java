/*
LeetCode 12 - Integer to Roman
Approach: Greedy subtraction from largest Roman values.
Time Complexity: O()
Space Complexity: O(1)
*/

class LC12_IntegerToRoman {
    public String intToRoman(int num) {

        int[] values = {
            1000, 900, 500, 400,
            100,  90,  50,  40,
            10,    9,   5,   4,
            1
        };

        String[] symbols = {
            "M", "CM", "D", "CD",
            "C", "XC", "L", "XL",
            "X", "IX", "V", "IV",
            "I"
        };

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (num >= values[i]) {
                sb.append(symbols[i]);
                num -= values[i];
            }
        }

        return sb.toString();
    }
}