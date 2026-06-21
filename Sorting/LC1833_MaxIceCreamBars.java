/*
LeetCode 1833 - Max Ice Cream Bars
Approach: Counting Sort
Time complexity: O(n + m) where n is the length of costs and m is the maximum cost
Space complexity: O(m) ~ O(1) since m is a constant (100000)
*/

class LC1833_MaxIceCreamBars {
    public int maxIceCream(int[] costs, int coins) {
        int freq[] = new int[100001];
        for (int cost : costs) {
            freq[cost]++;
        }
        int sum = 0;
        for (int i = 1; i < 100001; i++) {

            int buy = Math.min(freq[i], coins / i);
            sum += buy;
            coins -= buy * i;

        }
        return sum;
    }

    public static void main(String[] args) {
        LC1833_MaxIceCreamBars obj = new LC1833_MaxIceCreamBars();
        int[] costs = { 1, 3, 2, 4, 1 };
        int coins = 7;
        int res = obj.maxIceCream(costs, coins);
        System.out.println(res); // Output: 4
    }
}
