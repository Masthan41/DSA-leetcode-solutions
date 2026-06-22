/*
LeetCode 1189 - Max Number of Balloons
Approach: return the minimum frequency of the characters in "balloon" from the given text
Time complexity: O(n + m) where n is the length of text and m is the maximum frequency
Space complexity: O(m) ~ O(1) since m is a constant (26)
*/

class LC1189_MaxBallons {
    public int maxNumberOfBalloons(String text) {
        int freq[] = new int[26];
        for (char ch : text.toCharArray()) {
            freq[ch - 'a']++;
        }

        return Math.min(
                Math.min(
                        Math.min(freq['b' - 'a'], freq['a' - 'a']),
                        Math.min(freq['l' - 'a'] / 2, freq['o' - 'a'] / 2)),
                freq['n' - 'a']);
    }
    public static void main(String[] args) {
        LC1189_MaxBallons obj = new LC1189_MaxBallons();
        String text = "loonbalxballpoon";
        int res = obj.maxNumberOfBalloons(text);
        System.out.println(res); // Output: 2
    }
}
