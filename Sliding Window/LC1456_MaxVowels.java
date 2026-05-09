class LC1456_MaxVowels {
    private boolean isVowel(char s) {
        if (s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u') {
            return true;
        }
        return false;
    }

    public int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }
        }
        int maxCount = count;

        // slide the window
        for (int i = k; i < s.length(); i++) {
            char outgoing = s.charAt(i - k);
            char incoming = s.charAt(i);

            if (isVowel(incoming))
                count++;
            if (isVowel(outgoing))
                count--;

            maxCount = Math.max(maxCount, count);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        LC1456_MaxVowels solution = new LC1456_MaxVowels();
        String s = "abciiidef";
        int k = 3;
        int result = solution.maxVowels(s, k);
        System.out.println(result); // Output: 3
    }
}
