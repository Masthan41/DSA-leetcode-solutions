class LC3483_Unique3DigitNums {
    public int totalNumbers(int[] digits) {
        int[] count = new int[10];

        // Count available copies of each digit
        for (int digit : digits) {
            count[digit]++;
        }

        int ans = 0;

        // Check every 3-digit number
        for (int num = 100; num <= 998; num += 2) {
            int ones = num % 10;
            int tens = (num / 10) % 10;
            int hundreds = num / 100;

            // Check if we have enough copies of each digit
            if (count[ones] > 0 &&
                count[tens] > 0 &&
                count[hundreds] > 0) {

                // If digits are same, we need multiple copies
                if (ones == tens && tens == hundreds) {
                    if (count[ones] >= 3) {
                        ans++;
                    }
                } 
                else if (ones == tens) {
                    if (count[ones] >= 2) {
                        ans++;
                    }
                } 
                else if (ones == hundreds) {
                    if (count[ones] >= 2) {
                        ans++;
                    }
                } 
                else if (tens == hundreds) {
                    if (count[tens] >= 2) {
                        ans++;
                    }
                } 
                else {
                    ans++;
                }
            }
        }

        return ans;
    }
}